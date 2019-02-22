package com.ahnlab.enginesdk.rc;

import java.util.TreeMap;

public class EngineManagerWrapper {
    static {
        System.loadLibrary("EngineManager");
    }

    private static native String native_getCurrentABI();

    private native int native_getInitData(Object obj, StringBuffer stringBuffer);

    private native int native_getMaxAPILevel(int i);

    private native int native_getMinAPILevel(int i);

    private native int native_getVerifyData(String str, StringBuffer stringBuffer);

    private native int native_getVerifyResult(String str, StringBuffer stringBuffer);

    private native int native_getVersion(int i, StringBuffer stringBuffer);

    private native int native_getVersionAll(int i, TreeMap<String, String> treeMap);

    private native int native_loadRCEngine(int i, String str, String str2);

    private native int native_setDebugOption(int i);

    private native int native_startRootCheck(Object obj, Object obj2);

    private native int native_unloadEngine(int i);


    public int loadEngine(String str, String str2) {
        return native_loadRCEngine(1, str, str2);
    }

    public int unloadEngine() {
        return native_unloadEngine(1);
    }

    @Deprecated
    public int getMaxAPILevel() {
        return native_getMaxAPILevel(1);
    }

    @Deprecated
    public int getMinAPILevel() {
        return native_getMinAPILevel(1);
    }

    public int getVersionAll(TreeMap<String, String> treeMap) {
        native_getVersionAll(5, treeMap);
        return native_getVersionAll(1, treeMap);
    }

    public int getEngineVersion(StringBuffer stringBuffer) {
        return native_getVersion(1, stringBuffer);
    }

    public int getSignatureVersion(StringBuffer stringBuffer) {
        return native_getVersion(4, stringBuffer);
    }

    public int check(RootCheckElement rootCheckElement, RootCheckInfo rootCheckInfo) {
        return native_startRootCheck(rootCheckElement, rootCheckInfo);
    }

    public int setDebugOption() {
        return native_setDebugOption(1);
    }

    public int getInitData(TamperDetectionElement tamperDetectionElement, StringBuffer stringBuffer) {
        return native_getInitData(tamperDetectionElement, stringBuffer);
    }

    public int getVerifyData(String str, StringBuffer stringBuffer) {
        return native_getVerifyData(str, stringBuffer);
    }

    public int getVerifyResult(String str, StringBuffer stringBuffer) {
        return native_getVerifyResult(str, stringBuffer);
    }

    public static String getCurrentABI() {
        return native_getCurrentABI();
    }

}