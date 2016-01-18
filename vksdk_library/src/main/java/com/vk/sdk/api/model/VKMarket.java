package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Describes field market of group.
 */
@SuppressWarnings("unused")
public class VKMarket extends VKApiModel implements Parcelable {

    /**
     *	Whether a market is enable (false — no, true — yes).
     */
    public boolean enabled;

    /**
     * Min market price
     */
    public int price_min;

    /**
     * Max market price
     */
    public int price_max;

    /**
     * Main market album ID
     */
    public int main_album_id;

    /**
     * Contact ID for contact with seller.
     * If ID is positive, is user.
     * If ID is negative, is community.
     */
    public int contact_id;

    /**
     * Currency
     */
    public VKApiCurrency currency;


    public VKMarket(JSONObject from) throws JSONException {
        parse(from);
    }

    /**
     * Fills a field Market instance from JSONObject.
     */
    public VKMarket parse(JSONObject jo) {
        enabled = ParseUtils.parseBoolean(jo, "enabled");
        price_min = jo.optInt("price_min");
        price_max = jo.optInt("price_max");
        contact_id = jo.optInt("contact_id");
        JSONObject currency = jo.optJSONObject("currency");
        if (currency != null) this.currency = new VKApiCurrency().parse(currency);
        return this;
    }

    /**
     * Creates empty field Market instance.
     */
    public VKMarket() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "VKApiFieldMarket{" +
                "enabled=" + enabled +
                ", price_min=" + price_min +
                ", price_max=" + price_max +
                ", main_album_id=" + main_album_id +
                ", contact_id=" + contact_id +
                ", currency=" + currency +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(enabled ? (byte) 1 : (byte) 0);
        dest.writeInt(this.price_min);
        dest.writeInt(this.price_max);
        dest.writeInt(this.main_album_id);
        dest.writeInt(this.contact_id);
        dest.writeParcelable(this.currency, flags);
    }

    protected VKMarket(Parcel in) {
        this.enabled = in.readByte() != 0;
        this.price_min = in.readInt();
        this.price_max = in.readInt();
        this.main_album_id = in.readInt();
        this.contact_id = in.readInt();
        this.currency = in.readParcelable(VKApiCurrency.class.getClassLoader());
    }

    public static final Creator<VKMarket> CREATOR = new Creator<VKMarket>() {
        public VKMarket createFromParcel(Parcel source) {
            return new VKMarket(source);
        }

        public VKMarket[] newArray(int size) {
            return new VKMarket[size];
        }
    };
}