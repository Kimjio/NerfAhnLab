package com.ahnlab.enginesdk;

public class SDKLogger {
    private static native int native_initialize(String str);

    private static native int native_logDebug(String str, String str2);

    private static native int native_logInstant(String str, String str2, String str3, int i);

    private static native int native_logNormal(String str, String str2);

    private static native int native_release();

    private static native int native_setDebugLog(String str);

    static {
        System.loadLibrary("EngineManager");
    }

}
