package com.vk.sdk.api.httpClient;
import android.text.TextUtils;
import java.util.regex.Pattern;

/**
 * Created by Vlad Pylyp on 22.08.2017.
 */

public class FileTypeHelper {

	private FileTypeHelper() {
	}


	public static String getFileExtensionFromUrl(String url) {
		if (!TextUtils.isEmpty(url)) {
			int fragment = url.lastIndexOf('#');
			if (fragment > 0) {
				url = url.substring(0, fragment);
			}

			int query = url.lastIndexOf('?');
			if (query > 0) {
				url = url.substring(0, query);
			}

			int filenamePos = url.lastIndexOf('/');
			String filename =
					0 <= filenamePos ? url.substring(filenamePos + 1) : url;

			// if the filename contains special characters, we don't
			// consider it valid for our matching purposes:
			if (!filename.isEmpty() &&
					Pattern.matches("[[\\w][\\_\\.\\-][\\(\\)\\%]]+", filename)) {
				int dotPos = filename.lastIndexOf('.');
				if (0 <= dotPos) {
					return filename.substring(dotPos + 1);
				}
			}
		}

		return "";
	}
}
