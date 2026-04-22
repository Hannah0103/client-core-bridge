package com.example.hannah_data_sdk.service;

public final class PageDataServiceFactory {
    private PageDataServiceFactory() {
    }

    public static PageDataService create(boolean useNative) {
        if (useNative) {
            return new NativeBridgePageDataService();
        }
        return new MockPageDataService();
    }
}
