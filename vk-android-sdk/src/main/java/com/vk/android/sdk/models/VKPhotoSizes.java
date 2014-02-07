package com.vk.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;

/**
 * Model to parse a list of photo with <a href="http://vk.com/dev/photo_sizes">photo sizes<a/> format.
 *
 * When {@code photo_sizes=1} parameter is used in methods,
 * response contains an info about original photo
 * copies with different sizes in sizes array with objects,
 * each of them contains following fields: <br />
 * <ul>
 *  <li>src — url of image copy;</li>
 *  <li> width — copy width, px;</li>
 *  <li> height — copy height, px;</li>
 *  <li>type — notation for copy size and ratio.</li>
 * </ul>
 */
@SuppressWarnings("unused")
public class VKPhotoSizes extends VKList<VKPhotoSize> implements Parcelable {

    private static float sQuality = 1.0f;

    /**
     * Sets the quality modifier for sampling algorithm of image resolution.
     * @param quality positive number between 0.0f and 1.0f.
     */
    public static void setQuality(float quality) {
        sQuality = quality;
    }

    /**
     * Original width of photo in pixels.
     */
    private int mOriginalWidth = 1;

    /**
     * Original height of photo in pixels.
     */
    private int mOriginalHeight = 1;

    /**
     * URL of last image thumb for width sampling algorithm.
     */
    private String mWidthThumb;
    /**
     * URL of last image thumb for height sampling algorithm.
     */
    private String mHeightThumb;

    /**
     * Width of last image thumb for width sampling algorithm.
     */
    private int mLastWidth;

    /**
     * Height of last image thumb for width sampling algorithm.
     */
    private int mLastHeight;

    /**
     * Parser that's used for parsing photo sizes.
     */
    private final Parser<VKPhotoSize> parser = new Parser<VKPhotoSize>() {
        @Override
        public VKPhotoSize parseObject(JSONObject source) throws Exception {
            return VKPhotoSize.parse(source, mOriginalWidth, mOriginalHeight);
        }
    };

    /**
     * Creates empty list of photo sizes.
     */
    public VKPhotoSizes() {
        super();
    }

    /**
     * Creates and fills list of photo sizes.
     */
    public VKPhotoSizes(JSONArray from) {
        super();
        fill(from);
    }

    /**
     * Creates list of photo sizes which fill with according data.
     * @param from array of photo sizes returned by VK.
     * @param width original photo width in pixels.
     * @param height original photo height in pixels.
     */
    public void fill(JSONArray from, int width, int height) {
        setOriginalDimension(width, height);
        fill(from);
    }

    /**
     * Fill list according with given data.
     * @param from array of photo sizes returned by VK.
     */
    public void fill(JSONArray from) {
        fill(from, parser);
        sort();
    }

    /**
     * Return image according with given type of thumb.
     * @return  URL of image thumb, or null if image with this thumb is not found in the list.
     */
    public String getByType(char type) {
        for(VKPhotoSize size: this) {
            if(size.type == type) {
                return size.src;
            }
        }
        return null;
    }

    /**
     * Sets original image dimensions.
     * @param width original photo width in pixels.
     * @param height original photo height in pixels.
     */
    public void setOriginalDimension(int width, int height) {
        if(width != 0) {
            this.mOriginalWidth = width;
        }
        if(height != 0) {
            this.mOriginalHeight = height;
        }
    }

    /**
     * Sorts thumbs according to their width.
     */
    public void sort() {
        Collections.sort(this);
    }

    /**
     * Finds an image that fits perfectly into the specified dimensions.
     * Method is uses a cache of last thumbs for better performance.
     * @param width required minimum width of image in pixels.
     * @param height required minimum height of image in pixels.
     * @return URL of selected thumb or null if image with what parameters is not found.
     */
    public String getImageForDimension(int width, int height) {
        return width >= height ? getImageForWidth(width) : getImageForHeight(height);
    }

    private String getImageForWidth(int width) {
        if((mWidthThumb != null && mLastWidth != width) || isEmpty()) {
            return mWidthThumb;
        }
        mLastWidth = width;
        mWidthThumb = null;
        width = (int) (width * sQuality);

        for(VKPhotoSize size : this) {
            if(size.width >= width) {
                mWidthThumb = size.src;
                break;
            }
        }
        return mWidthThumb;
    }

    private String getImageForHeight(int height) {
        if((mHeightThumb != null && mLastHeight != height) || isEmpty()) {
            return mHeightThumb;
        }
        mLastHeight = height;
        mHeightThumb = null;
        height = (int) (height * sQuality);

        for(VKPhotoSize size : this) {
            if(size.height >= height) {
                mHeightThumb = size.src;
                break;
            }
        }
        return mHeightThumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.mOriginalWidth);
        dest.writeInt(this.mOriginalHeight);
        dest.writeString(this.mWidthThumb);
        dest.writeInt(this.mLastWidth);
    }

    private VKPhotoSizes(Parcel in) {
        super(in);
        this.mOriginalWidth = in.readInt();
        this.mOriginalHeight = in.readInt();
        this.mWidthThumb = in.readString();
        this.mLastWidth = in.readInt();
    }

    public static Creator<VKPhotoSizes> CREATOR = new Creator<VKPhotoSizes>() {
        public VKPhotoSizes createFromParcel(Parcel source) {
            return new VKPhotoSizes(source);
        }

        public VKPhotoSizes[] newArray(int size) {
            return new VKPhotoSizes[size];
        }
    };
}
