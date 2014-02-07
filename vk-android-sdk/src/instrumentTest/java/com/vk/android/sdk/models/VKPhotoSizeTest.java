/**
 * PhotoSizeTest.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 13.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.android.sdk.models;

import junit.framework.TestCase;
import org.json.JSONObject;

public class VKPhotoSizeTest extends TestCase {

    public void testDimensionS() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 's'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 750;
        originalHeight = 500;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 75);
        assertTrue(size.width == 75 && size.height == 50);

        // Test 2, for portrait image
        originalWidth = 750;
        originalHeight = 1000;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 75);
        assertTrue(size.width == 75 && size.height == 100);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 75);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 75);
        assertTrue(size.width == 60 && size.height == 40);
    }

    public void testDimensionM() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'm'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 1300;
        originalHeight = 870;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 130);
        assertTrue(size.width == 130 && size.height == 87);

        // Test 2, for portrait image
        originalWidth = 1300;
        originalHeight = 2000;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width == 130 && size.height == 200);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width == 60 && size.height == 40);
    }

    public void testDimensionX() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'x'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 6040;
        originalHeight = 4040;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 604);
        assertTrue(size.width == 604 && size.height == 404);

        // Test 2, for portrait image
        originalWidth = 6040;
        originalHeight = 6050;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 604);
        assertTrue(size.width == 604 && size.height == 605);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 604);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 604);
        assertTrue(size.width == 60 && size.height == 40);

//
//
//        JSONObject js = new JSONObject("{" +
//                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
//                "    type: 'x'\n" +
//                "    }");
//
//        PhotoSize size = PhotoSize.parse(js, 6040, 4040);
//        assertTrue(size.width == 604 && size.height == 404);
    }

    public void testDimensionY() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'y'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 8070;
        originalHeight = 5400;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 807);
        assertTrue(size.width == 807 && size.height == 540);

        // Test 2, for portrait image
        originalWidth = 8070;
        originalHeight = 10000;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 807);
        assertTrue(size.width == 807 && size.height == 1000);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 807);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 807);
        assertTrue(size.width == 60 && size.height == 40);


//        JSONObject js = new JSONObject("{" +
//                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
//                "    type: 'y'\n" +
//                "    }");
//
//        PhotoSize size = PhotoSize.parse(js, 8070, 5400);
//        assertTrue(size.width == 807 && size.height == 540);
    }

    public void testDimensionO() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'o'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 150;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 130);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 2, for scaled image
        originalWidth = 3000;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 130);
        assertTrue(size.width == 60 && size.height == 40);
    }

    public void testDimensionP() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'p'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 150;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 200);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 2, for scaled image
        originalWidth = 3000;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 200);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 200);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 200);
        assertTrue(size.width == 60 && size.height == 40);
    }

    public void testDimensionQ() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'q'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 150;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 320);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 2, for scaled image
        originalWidth = 3000;
        originalHeight = 100;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 320);
        assertTrue(size.width  / (float) size.height <= 1.5f);

        // Test 3, for small portrait images
        originalWidth = 40;
        originalHeight = 80;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 320);
        assertTrue(size.width == 40 && size.height == 80);

        // Test 4, for small landspace images
        originalWidth = 60;
        originalHeight = 40;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);

        assertTrue(size.width <= 320);
        assertTrue(size.width == 60 && size.height == 40);
    }

    public void testDimensionZ() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'z'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 750;
        originalHeight = 500;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 1280 && size.height <= 1024);
        assertTrue(size.width == 750 && size.height == 500);

        // Test 2, for out sided image
        originalWidth = 12800;
        originalHeight = 500;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 1280 && size.height <= 1024);
        assertTrue(size.width == 1280 && size.height == 50);

        // Test 2, for out sided image
        originalWidth = 12800;
        originalHeight = 10240;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 1280 && size.height <= 1024);
        assertTrue(size.width == 1280 && size.height == 1024);
    }

    public void testDimensionW() throws Exception {
        JSONObject js = new JSONObject("{" +
                "    src: 'http://cs323930.vk.me/v323930021/53f7/OwV0l2YFJ7s.jpg'," +
                "    type: 'w'\n" +
                "    }");
        int originalWidth;
        int originalHeight;
        VKPhotoSize size;

        // Test 1, for album image
        originalWidth = 750;
        originalHeight = 500;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 2560 && size.height <= 2048);
        assertTrue(size.width == 750 && size.height == 500);

        // Test 2, for out sided image
        originalWidth = 25600;
        originalHeight = 500;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 2560 && size.height <= 2048);
        assertTrue(size.width == 2560 && size.height == 50);

        // Test 2, for out sided image
        originalWidth = 25600;
        originalHeight = 20480;

        size = VKPhotoSize.parse(js, originalWidth, originalHeight);
        assertTrue(size.width <= 2560 && size.height <= 2048);
        assertTrue(size.width == 2560 && size.height == 2048);
    }
}
