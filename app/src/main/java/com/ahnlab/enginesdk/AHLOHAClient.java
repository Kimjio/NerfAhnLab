package com.ahnlab.enginesdk;

public class AHLOHAClient {
    private static native int native_ahlohaclientDestroy();

    private static native int native_ahlohaclientInit(String str);

    private static native int native_sendErrorReport(Object obj);

}
