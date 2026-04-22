package com.example.hannah_data_sdk.bridge;

public final class NativeDataBridge {
    static {
        try {
            System.loadLibrary("hannah_data");
        } catch (Throwable ignore) {
            // AAR without so can still fallback to mock service.
        }
    }

    private NativeDataBridge() {
    }

    public static native String fetchTabPagesPayload();
}
