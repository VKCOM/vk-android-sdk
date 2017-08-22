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

package com.vk.sdk.api.httpClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.webkit.MimeTypeMap;

import com.atmt.masterdetailtest.App;
import com.atmt.masterdetailtest.helper.FileTypeHelper;
import com.vk.sdk.api.model.VKAttachments;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Random;

/**
 * Class used for build upload multipart data for VK servers
 */
public class VKMultipartEntity {

    private static final String VK_BOUNDARY = "Boundary(======VK_SDK_%d======)";;

    private final String mBoundary;
    private final File[] mFiles;
    private String mType;

    public VKMultipartEntity(File[] files) {
        mBoundary = String.format(Locale.US, VK_BOUNDARY, new Random().nextInt());
        mFiles = files;
    }

    public VKMultipartEntity(File[] files, String type) {
        mBoundary = String.format(Locale.US, VK_BOUNDARY, new Random().nextInt());
        mFiles = files;
        mType = type;
    }

    public long getContentLength() {
        long length = 0;
        for (int i = 0; i < mFiles.length; i++) {
            File f = mFiles[i];
            length += f.length();
            length += getFileDescription(f, i).length();
        }
        length += getBoundaryEnd().length();
        return length;
    }

    public Pair<String, String> getContentType() {
        return new Pair<>("Content-Type", String.format("multipart/form-data; boundary=%s", mBoundary));
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    protected String getFileDescription(File uploadFile, int i) {
        String fileName;
        if (mType != null && mType.equals(VKAttachments.TYPE_DOC)) {
            fileName = "file";
        } else {
            fileName = String.format(Locale.US, "file%d", i + 1);
        }
        String extension = FileTypeHelper.getFileExtensionFromUrl(uploadFile.getAbsolutePath().toLowerCase());
        //String extension = "pdf";
        return String.format("\r\n--%s\r\n", mBoundary) +
                String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s.%s\"\r\n", fileName, fileName, extension) +
                String.format("Content-Type: %s\r\n\r\n", getMimeType(uploadFile.getAbsolutePath()));
    }

    private String getBoundaryEnd() {
        return String.format("\r\n--%s--\r\n", mBoundary);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        for (int i = 0; i < mFiles.length; i++) {
            File uploadFile = mFiles[i];
            outputStream.write(getFileDescription(uploadFile, i).getBytes("UTF-8"));
            FileInputStream reader = new FileInputStream(uploadFile);
            byte[] fileBuffer = new byte[2048];
            int bytesRead;
            while ((bytesRead = reader.read(fileBuffer)) != -1) {
                outputStream.write(fileBuffer, 0, bytesRead);
            }
            reader.close();
        }
        outputStream.write(getBoundaryEnd().getBytes("UTF-8"));
    }

    protected static String getMimeType(String url) {
        String type = null;
        String extension = FileTypeHelper.getFileExtensionFromUrl(url.toLowerCase());
        if (extension != null) {
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            type = mime.getMimeTypeFromExtension(extension);
        }
        return type;
    }

    /*public String getMimeType(Uri uri) {
        String type = null;
        Context context = App.getContextRef().get();
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver cr = context.getContentResolver();
            type = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return type;
    }*/
}