package com.ahnlab.enginesdk;

import android.os.Handler;

import java.util.TreeMap;

public class SDKManager {

    private static native int native_cancelReport();

    private static native int native_createST();

    private static native void native_deleteHandler();

    private static native int native_getVersion(int i, StringBuffer stringBuffer);

    private static native int native_sendReport(Object obj);

    private static native void native_setHandler(Handler handler);

    static {
        System.loadLibrary("EngineManager");
    }

}
