package com.vk.api.sdk.browser;

import androidx.annotation.NonNull;

public interface BrowserMatcher {
    boolean matches(@NonNull BrowserDescriptor descriptor);
}