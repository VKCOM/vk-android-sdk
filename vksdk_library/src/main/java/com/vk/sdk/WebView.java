package com.vk.sdk;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class WebView extends android.webkit.WebView {

	public WebView(Context context) {
		super(context);
	}

	public WebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public WebView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		View view = this;
		while (view.getParent() instanceof View) {
			view = (View) view.getParent();
			view.setBackgroundColor(Color.TRANSPARENT);
		}
	}
}