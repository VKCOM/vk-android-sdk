//
//  Copyright (c) 2016 VK.com
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

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Item object describes a item.
 */
@SuppressWarnings("unused")
public class VKApiItem extends VKApiOwner implements android.os.Parcelable, Identifiable {

    public static Creator<VKApiItem> CREATOR = new Creator<VKApiItem>() {
        public VKApiItem createFromParcel(Parcel source) {
            return new VKApiItem(source);
        }

        public VKApiItem[] newArray(int size) {
            return new VKApiItem[size];
        }
    };
    /**
     * Item ID.
     */
    public int id;
    /**
     * User or group ID.
     * If ID is positive, owner is user.
     * If ID is negative, owner is community.
     */
    public int owner_id;
    /**
     * Screen name of the market page (e.g. apiclub or club1).
     */
    public String title;
    /**
     * Good's description.
     */
    public String description;
    /**
     * The price of the product
     */
    public VKApiPrice price;
    /**
     * Product category
     */
    public VKApiCategory category;
    /**
     * Date when the item was added as unixtime.
     */
    public long date;
    /**
     * Availability status of the item.
     *
     * @see com.vk.sdk.api.model.VKApiItem.Availability
     */
    public int availability;

    /**
     * Number of comments on the item.
     */
    public int comments;

    /**
     * Number of views_count on the item.
     */
    public int views_count;

    public VKApiItem(JSONObject from) {
        parse(from);
    }

    /**
     * Creates empty Item instance.
     */
    public VKApiItem() {

    }

    /**
     * Fills a item object from JSONObject
     *
     * @param from JSONObject describes item object according with VK Docs.
     */
    public VKApiItem parse(JSONObject from) {
        super.parse(from);
        id = from.optInt("id");
        owner_id = from.optInt("owner_id");
        title = from.optString("title");
        description = from.optString("description");
        JSONObject price = from.optJSONObject("price");
        if (price != null) this.price = new VKApiPrice().parse(price);
        JSONObject category = from.optJSONObject("category");
        if (category != null) this.category = new VKApiCategory().parse(category);
        date = from.optLong("date");
        availability = from.optInt("availability");
        comments = from.optInt("comments");
        views_count = from.optInt("views_count");

        return this;
    }

    @Override
    public String toString() {
        return "VKApiItem{" +
                "id=" + id +
                ", owner_id=" + owner_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", date=" + date +
                ", availability=" + availability +
                ", comments=" + comments +
                ", views_count=" + views_count +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Creates a item object from Parcel
     */
    public VKApiItem(Parcel in) {
        super(in);
        this.id = in.readInt();
        this.owner_id = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.price = in.readParcelable(VKApiPrice.class.getClassLoader());
        this.category = in.readParcelable(VKApiCategory.class.getClassLoader());
        this.date = in.readLong();
        this.availability = in.readInt();
        this.comments = in.readInt();
        this.views_count = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.id);
        dest.writeInt(this.owner_id);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeParcelable(this.price, flags);
        dest.writeParcelable(this.category, flags);
        dest.writeLong(this.date);
        dest.writeInt(this.availability);
        dest.writeInt(this.comments);
        dest.writeInt(this.views_count);
    }

    public static class VKApiPrice extends VKApiModel implements Parcelable {

        public static Creator<VKApiPrice> CREATOR = new Creator<VKApiPrice>() {
            public VKApiPrice createFromParcel(Parcel source) {
                return new VKApiPrice(source);
            }

            public VKApiPrice[] newArray(int size) {
                return new VKApiPrice[size];
            }
        };
        /**
         * The price of the product
         */
        public int amount;
        /**
         * Currency
         */
        public VKApiCurrency currency;
        /**
         * A string representation of the price.
         */
        public String text;

        public VKApiPrice(JSONObject from) throws JSONException {
            parse(from);
        }

        /**
         * Creates a Price instance from Parcel.
         */
        public VKApiPrice(Parcel in) {
            this.amount = in.readInt();
            this.currency = in.readParcelable(VKApiCurrency.class.getClassLoader());
            this.text = in.readString();

        }

        /**
         * Creates empty Price instance.
         */
        public VKApiPrice() {

        }

        /**
         * Fills a Price instance from JSONObject.
         */
        public VKApiPrice parse(JSONObject jo) {
            amount = jo.optInt("amount");
            text = jo.optString("text");
            JSONObject currency = jo.optJSONObject("currency");
            if (currency != null) this.currency = new VKApiCurrency().parse(currency);
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.amount);
            dest.writeParcelable(this.currency, flags);
            dest.writeString(this.text);
        }

        @Override
        public String toString() {
            return "VKApiPrice{" +
                    "amount=" + amount +
                    ", currency=" + currency +
                    ", text='" + text + '\'' +
                    '}';
        }
    }


    /**
     * Availability status of the item.
     */
    public static class Availability {
        public final static int AVAILABLE = 0;
        public final static int DELETED = 1;
        public final static int NOT_AVAILABLE = 2;
        private Availability() {
        }
    }
}
