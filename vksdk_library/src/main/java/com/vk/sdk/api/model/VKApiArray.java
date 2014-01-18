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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for VK API arrays
 */
public abstract class VKApiArray<T extends VKApiModel> extends VKApiModel {
    private List<T> items;
    private int count;

    @Override
    public void parse(JSONObject response) {
        try {
            if (!response.has("response"))
                return;
            JSONArray jsonArray;
            if ((jsonArray = response.optJSONArray("response")) == null)
            {
                response    = response.getJSONObject("response");
                count       = response.getInt("count");
                jsonArray   = response.getJSONArray("items");
            }
            else
                count = jsonArray.length();

            items = new ArrayList<T>(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                items.add(parseNextObject(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject serialize() {
        return null;
    }

    protected T parseNextObject(JSONObject object) {
        try {
            // Get the class name of this instance's type.
            ParameterizedType pt
                    = (ParameterizedType) getClass().getGenericSuperclass();
            // You may need this split or not, use logging to check
            String parameterClassName
                    = pt.getActualTypeArguments()[0].toString().split("\\s")[1];
            // Instantiate the Parameter and initialize it.
            @SuppressWarnings("unchecked")
            T model = (T) Class.forName(parameterClassName).newInstance();
            model.parse(object);
            return model;
        } catch (Exception ignored)
        {
            return null;
        }
    }

    public T get(int index) {
        if (items == null) return null;
        return items.get(index);
    }

    public int size() { return count; }
}
