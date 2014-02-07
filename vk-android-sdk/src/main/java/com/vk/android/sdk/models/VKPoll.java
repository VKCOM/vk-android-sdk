/**
 * PollAttachment.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import android.os.Parcel;
import org.json.JSONObject;
import static com.vk.android.sdk.models.VKAttachments.*;

/**
 * Describes poll on the wall on board.
 */
@SuppressWarnings("unused")
public class VKPoll extends VKAttachments.VKAttachment implements android.os.Parcelable {

    /**
     * Poll ID to get information about it using polls.getById method;
     */
    public int id;

    /**
     * ID of the user or community that owns this poll.
     */
    public int owner_id;

    /**
     * Date (in Unix time) the poll was created.
     */
    public long created;

    /**
     * Question in the poll.
     */
    public String question;

    /**
     * The total number of users answered.
     */
    public int votes;

    /**
     * Response ID of the current user(if the current user has not yet posted in this poll, it contains 0)
     */
    public int answer_id;

    /**
     * Array of answers for this question.
     */
    public VKList<Answer> answers;

    /**
     * Fills a Poll instance from JSONObject.
     */
    public VKPoll parse(JSONObject source) {
        id = source.optInt("id");
        owner_id = source.optInt("owner_id");
        created = source.optLong("created");
        question = source.optString("question");
        votes = source.optInt("votes");
        answer_id = source.optInt("answer_id");
        answers = new VKList<Answer>(source.optJSONArray("answers"), Answer.class);
        return this;
    }

    /**
     * Creates a Poll instance from Parcel.
     */
    public VKPoll(Parcel in) {
        this.id = in.readInt();
        this.owner_id = in.readInt();
        this.created = in.readLong();
        this.question = in.readString();
        this.votes = in.readInt();
        this.answer_id = in.readInt();
        this.answers = in.readParcelable(VKList.class.getClassLoader());
    }

    /**
     * Creates empty Country instance.
     */
    public VKPoll() {

    }

    @Override
    public CharSequence toAttachmentString() {
        return null;
    }

    @Override
    public String getType() {
        return TYPE_POLL;
    }

    @Override
    public int getId() {
        return id;
    }

    /**
     * Represents answer for the poll
     */
    public final static class Answer extends VKModel implements Identifiable, android.os.Parcelable {

        /**
         * ID of the answer for the question
         */
        public int id;

        /**
         * Text of the answer
         */
        public String text;

        /**
         * Number of users that voted for this answer
         */
        public int votes;

        /**
         * Rate of this answer in percent
         */
        public double rate;

        public Answer parse(JSONObject source) {
            id = source.optInt("id");
            text = source.optString("text");
            votes = source.optInt("votes");
            rate = source.optDouble("rate");
            return this;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.text);
            dest.writeInt(this.votes);
            dest.writeDouble(this.rate);
        }

        public Answer(Parcel in) {
            this.id = in.readInt();
            this.text = in.readString();
            this.votes = in.readInt();
            this.rate = in.readDouble();
        }

        public static Creator<Answer> CREATOR = new Creator<Answer>() {
            public Answer createFromParcel(Parcel source) {
                return new Answer(source);
            }

            public Answer[] newArray(int size) {
                return new Answer[size];
            }
        };

        @Override
        public int getId() {
            return id;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.owner_id);
        dest.writeLong(this.created);
        dest.writeString(this.question);
        dest.writeInt(this.votes);
        dest.writeInt(this.answer_id);
        dest.writeParcelable(this.answers, flags);
    }

    public static Creator<VKPoll> CREATOR = new Creator<VKPoll>() {
        public VKPoll createFromParcel(Parcel source) {
            return new VKPoll(source);
        }

        public VKPoll[] newArray(int size) {
            return new VKPoll[size];
        }
    };
}
