//
//  Copyright (c) 2014 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

package com.vk.sdk.api.model;

import com.vk.sdk.VKObject;
import com.vk.sdk.util.VKJsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Basic class for API objects
 */
public abstract class VKApiModel extends VKObject {
    /**
     * Fields of JSON object from original response
     */
    public Map<String, Object> fields;

    /**
     * Parse json object into object model
     * @param response JSONObject to parse
     */
    public void parse(JSONObject response) {
        if (response.has("response")) {
            response = response.optJSONObject("response");
        }
        if (response == null)
            return;
        Field[] allFields = this.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if (!response.has(field.getName()))
                continue;
            try {
                String fName = field.getName();
                Class<?> fType  = field.getType();
                if (fType.isPrimitive() || fType.equals(String.class)) {
                    Object value = response.get(fName);
                    if (value.getClass().equals(fType))
                        field.set(this, response.get(fName));
                    else {
                        //If primitive type is not assignable, parse it
                        String sValue = String.valueOf(value);
                        if (fType.equals(int.class)) {
                            field.setInt(this, Integer.parseInt(sValue));
                        } else if (fType.equals(long.class)) {
                            field.setLong(this, Long.parseLong(sValue));
                        } else if (fType.equals(float.class)) {
                            field.setFloat(this, Float.parseFloat(sValue));
                        } else if (fType.equals(double.class)) {
                            field.setDouble(this, Double.parseDouble(sValue));
                        }
                    }

				} else if (fType.isArray()) {
					field.set(this, VKJsonHelper.toArray(response.getJSONArray(fName), fType));
                } else if (fType.isAssignableFrom(Map.class)) {
                    field.set(this, VKJsonHelper.getMap(response, fName));
                } else if (fType.isAssignableFrom(List.class)) {
                    field.set(this, VKJsonHelper.toList(response.getJSONArray(fName) ) );
                } else if (VKApiModel.class.isAssignableFrom(fType)) {
                    VKApiModel obj = (VKApiModel) field.getType().newInstance();
                    obj.parse(response.getJSONObject(fName));
                    field.set(this, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            fields = VKJsonHelper.toMap(response);
        } catch (JSONException ignored) {}
    }

    /**
     * Serialize object to JSON
     * @return Serialized JSONObject
     */
    public JSONObject serialize() {
        Field[] allFields = this.getClass().getDeclaredFields();
        JSONObject object = new JSONObject();
        for (Field field : allFields) {
            if (field.getType().isPrimitive()) {
                try {
                    object.put(field.getName(), field.get(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (field.getType().isAssignableFrom(VKApiModel.class)) {
                try {
                    object.put(field.getName(), ((VKApiModel) field.get(this)).serialize());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
