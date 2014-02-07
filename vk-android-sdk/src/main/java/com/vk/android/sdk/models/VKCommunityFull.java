package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

import static com.vk.android.sdk.models.ParseUtils.parseBoolean;

/**
 * Represents full community profile.
 */
@SuppressWarnings("unused")
public class VKCommunityFull extends VKCommunity implements Parcelable {

    /**
     * Filed city from VK fields set
     */
    public final static String CITY = "city";

    /**
     * Filed country from VK fields set
     */
    public final static String COUNTRY = "country";

    /**
     * Filed place from VK fields set
     */
    public final static String PLACE = "place";

    /**
     * Filed description from VK fields set
     */
    public final static String DESCRIPTION = "description";

    /**
     * Filed wiki_page from VK fields set
     */
    public final static String WIKI_PAGE = "wiki_page";

    /**
     * Filed members_count from VK fields set
     */
    public final static String MEMBERS_COUNT = "members_count";

    /**
     * Filed counters from VK fields set
     */
    public final static String COUNTERS = "counters";

    /**
     * Filed start_date from VK fields set
     */
    public final static String START_DATE = "start_date";

    /**
     * Filed end_date from VK fields set
     */
    public final static String END_DATE = "end_date";

    /**
     * Filed can_post from VK fields set
     */
    public final static String CAN_POST = "can_post";

    /**
     * Filed can_see_all_posts from VK fields set
     */
    public final static String CAN_SEE_ALL_POSTS = "can_see_all_posts";

    /**
     * Filed status from VK fields set
     */
    public final static String STATUS = "status";

    /**
     * Filed contacts from VK fields set
     */
    public final static String CONTACTS = "contacts";

    /**
     * Filed links from VK fields set
     */
    public final static String LINKS = "links";

    /**
     * Filed fixed_post from VK fields set
     */
    public final static String FIXED_POST = "fixed_post";

    /**
     * Filed verified from VK fields set
     */
    public final static String VERIFIED = "verified";

    /**
     * Filed blacklisted from VK fields set
     */
    public final static String BLACKLISTED = "blacklisted";

    /**
     * Filed site from VK fields set
     */
    public final static String SITE = "site";

    /**
     * Filed activity from VK fields set
     */
    public final static String ACTIVITY = "activity";

    /**
     * City specified in information about community.
     */
    public VKCity city;

    /**
     * Country specified in information about community.
     */
    public VKCountry country;

    /**
     * Audio which broadcasting to status.
     */
    public VKAudio status_audio;

    /**
     * The location which specified in information about community
     */
    public VKPlace place;

    /**
     * Community description text.
     */
    public String description;

    /**
     * Name of the home wiki-page of the community.
     */
    public String wiki_page;

    /**
     * Number of community members.
     */
    public int members_count;

    /**
     * Counters object with community counters.
     */
    public Counters counters;

    /**
     * Returned only for meeting and contain start time of the meeting as unixtime.
     */
    public long start_date;

    /**
     * Returned only for meeting and contain end time of the meeting as unixtime.
     */
    public long end_date;

    /**
     * Whether the current user can post on the community's wall
     */
    public boolean can_post;

    /**
     * Whether others' posts on the community's wall can be viewed
     */
    public boolean can_see_all_posts;

    /**
     * Group status.
     */
    public String status;

    /**
     * Information from public page contact module.
     */
    public VKList<Contact> contacts;

    /**
     * Information from public page links module.
     */
    public VKList<Link> links;

    /**
     * ID of fixed post of this community.
     */
    public int fixed_post;

    /**
     * Information whether the community has a verified page in VK
     */
    public boolean verified;

    /**
     * URL of community site
     */
    public String site;

    /**
     * Information whether the current community has add current user to the blacklist.
     */
    public boolean blacklisted;

    public VKCommunityFull parse(JSONObject jo) {
        super.parse(jo);

        JSONObject city = jo.optJSONObject(CITY);
        if(city != null) {
            this.city = new VKCity().parse(city);
        }
        JSONObject country = jo.optJSONObject(COUNTRY);
        if(country != null) {
            this.country = new VKCountry().parse(country);
        }

        JSONObject place = jo.optJSONObject(PLACE);
        if(place != null) this.place = new VKPlace().parse(place);

        description = jo.optString(DESCRIPTION);
        wiki_page = jo.optString(WIKI_PAGE);
        members_count = jo.optInt(MEMBERS_COUNT);

        JSONObject counters = jo.optJSONObject(COUNTERS);
        if(counters != null) this.counters = new Counters(place);

        start_date = jo.optLong(START_DATE);
        end_date = jo.optLong(END_DATE);
        can_post = parseBoolean(jo, CAN_POST);
        can_see_all_posts = parseBoolean(jo, CAN_SEE_ALL_POSTS);
        status = jo.optString(STATUS);

        JSONObject status_audio = jo.optJSONObject("status_audio");
        if(status_audio != null) this.status_audio = new VKAudio().parse(status_audio);

        contacts = new VKList<Contact>(jo.optJSONArray(CONTACTS), Contact.class);
        links = new VKList<Link>(jo.optJSONArray(LINKS), Link.class);
        fixed_post = jo.optInt(FIXED_POST);
        verified = parseBoolean(jo, VERIFIED);
        blacklisted = parseBoolean(jo, VERIFIED);
        site = jo.optString(SITE);
        return this;
    }



    public static class Counters implements Parcelable {

        /**
         * Значение в том случае, если счетчик не был явно указан.
         */
        public final static int NO_COUNTER = -1;

        public int photos = NO_COUNTER;
        public int albums = NO_COUNTER;
        public int audios = NO_COUNTER;
        public int videos = NO_COUNTER;
        public int topics = NO_COUNTER;
        public int docs = NO_COUNTER;

        public Counters(JSONObject from) {
            photos = from.optInt("photos", photos);
            albums = from.optInt("albums", albums);
            audios = from.optInt("audios", audios);
            videos = from.optInt("videos", videos);
            topics = from.optInt("topics", topics);
            docs = from.optInt("docs", docs);
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.photos);
            dest.writeInt(this.albums);
            dest.writeInt(this.audios);
            dest.writeInt(this.videos);
            dest.writeInt(this.topics);
            dest.writeInt(this.docs);
        }

        private Counters(Parcel in) {
            this.photos = in.readInt();
            this.albums = in.readInt();
            this.audios = in.readInt();
            this.videos = in.readInt();
            this.topics = in.readInt();
            this.docs = in.readInt();
        }

        public static Creator<Counters> CREATOR = new Creator<Counters>() {
            public Counters createFromParcel(Parcel source) {
                return new Counters(source);
            }

            public Counters[] newArray(int size) {
                return new Counters[size];
            }
        };
    }

    public static class Contact extends VKModel implements Parcelable, Identifiable {
        public int user_id;
        public VKUser user;
        public String email;
        public String desc;

        public Contact parse(JSONObject from) {
            user_id = from.optInt("user_id");
            desc = from.optString("desc");
            email = from.optString("email");
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.user_id);
            dest.writeString(this.desc);

        }

        private Contact(Parcel in) {
            this.user_id = in.readInt();
            this.desc = in.readString();
        }

        public static Creator<Contact> CREATOR = new Creator<Contact>() {
            public Contact createFromParcel(Parcel source) {
                return new Contact(source);
            }

            public Contact[] newArray(int size) {
                return new Contact[size];
            }
        };

        @Override
        public int getId() {
            return user_id;
        }

        @Override
        public String toString() {
            if(user != null) {
                return user.toString();
            } else if(email != null) {
                return email;
            }
            return null;
        }
    }

    public static class Link extends VKModel implements Parcelable, Identifiable {

        public String url;
        public String name;
        public String desc;
        public VKPhotoSizes photo = new VKPhotoSizes();

        public Link parse(JSONObject from) {
            url = from.optString("url");
            name = from.optString("name");
            desc = from.optString("desc");

            String photo_50 = from.optString("photo_50");
            if(!TextUtils.isEmpty(photo_50)) {
                photo.add(VKPhotoSize.create(photo_50, 50));
            }
            String photo_100 = from.optString("photo_100");
            if(!TextUtils.isEmpty(photo_100)) {
                photo.add(VKPhotoSize.create(photo_100, 100));
            }
            photo.sort();
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.url);
            dest.writeString(this.name);
            dest.writeString(this.desc);
            dest.writeParcelable(this.photo, flags);
        }

        public Link(Parcel in) {
            this.url = in.readString();
            this.name = in.readString();
            this.desc = in.readString();
            this.photo = in.readParcelable(null);
        }

        public static Creator<Link> CREATOR = new Creator<Link>() {
            public Link createFromParcel(Parcel source) {
                return new Link(source);
            }

            public Link[] newArray(int size) {
                return new Link[size];
            }
        };

        @Override
        public int getId() {
            return 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.city, flags);
        dest.writeParcelable(this.country, flags);
        dest.writeParcelable(this.status_audio, flags);
        dest.writeParcelable(this.place, flags);
        dest.writeString(this.description);
        dest.writeString(this.wiki_page);
        dest.writeInt(this.members_count);
        dest.writeParcelable(this.counters, flags);
        dest.writeLong(this.start_date);
        dest.writeLong(this.end_date);
        dest.writeByte(can_post ? (byte) 1 : (byte) 0);
        dest.writeByte(can_see_all_posts ? (byte) 1 : (byte) 0);
        dest.writeString(this.status);
        dest.writeParcelable(this.contacts, flags);
        dest.writeParcelable(this.links, flags);
        dest.writeInt(this.fixed_post);
        dest.writeByte(verified ? (byte) 1 : (byte) 0);
        dest.writeString(this.site);
        dest.writeByte(blacklisted ? (byte) 1 : (byte) 0);
    }

    public VKCommunityFull(Parcel in) {
        super(in);
        this.city = in.readParcelable(VKCity.class.getClassLoader());
        this.country = in.readParcelable(VKCountry.class.getClassLoader());
        this.status_audio = in.readParcelable(VKAudio.class.getClassLoader());
        this.place = in.readParcelable(VKPlace.class.getClassLoader());
        this.description = in.readString();
        this.wiki_page = in.readString();
        this.members_count = in.readInt();
        this.counters = in.readParcelable(Counters.class.getClassLoader());
        this.start_date = in.readLong();
        this.end_date = in.readLong();
        this.can_post = in.readByte() != 0;
        this.can_see_all_posts = in.readByte() != 0;
        this.status = in.readString();
        this.contacts = in.readParcelable(VKList.class.getClassLoader());
        this.links = in.readParcelable(VKList.class.getClassLoader());
        this.fixed_post = in.readInt();
        this.verified = in.readByte() != 0;
        this.site = in.readString();
        this.blacklisted = in.readByte() != 0;
    }

    public static Creator<VKCommunityFull> CREATOR = new Creator<VKCommunityFull>() {
        public VKCommunityFull createFromParcel(Parcel source) {
            return new VKCommunityFull(source);
        }

        public VKCommunityFull[] newArray(int size) {
            return new VKCommunityFull[size];
        }
    };
}
