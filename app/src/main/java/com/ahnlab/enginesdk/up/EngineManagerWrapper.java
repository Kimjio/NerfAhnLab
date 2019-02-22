package com.ahnlab.enginesdk.up;

import java.util.TreeMap;

public class EngineManagerWrapper {
    private native int native_cancelSuarez();

    private native int native_checkLicense(String str, String str2);

    private static native String native_getCurrentABI();

    private native int native_getMaxAPILevel(int i);

    private native int native_getMinAPILevel(int i);

    private native int native_getOperationFlag();

    private native int native_getProductCode();

    private native int native_getUpdateInfo(Object obj);

    private native int native_getVersion(int i, StringBuffer stringBuffer);

    private native int native_getVersionAll(int i, TreeMap<String, String> treeMap);

    private native int native_initUpdater(String str, int i);

    private native int native_loadEngine(int i, String str);

    private native int native_setDebugOption(int i);

    private native int native_startAuthentication(Object obj, Object obj2);

    private native int native_startUpdate(Object obj, Object obj2);

    private native int native_unloadEngine(int i);

    /*public int loadUpdater(String str) {
        return native_loadEngine(2, str);
    }

    public int unloadUpdater() {
        return native_unloadEngine(2);
    }

    public int initUpdater(String str, int i) {
        return native_initUpdater(str, i);
    }

    public int checkLicenseValidity(String str, String str2) {
        return native_checkLicense(str, str2);
    }

    public int startUpdate(UpdateElement updateElement, UpdateResult updateResult) {
        return native_startUpdate(updateElement, updateResult);
    }

    public int startAuthentication(AuthElement authElement, AuthResult authResult) {
        return native_startAuthentication(authElement, authResult);
    }

    public int cancelSuarez() {
        return native_cancelSuarez();
    }

    protected int getUpdateInfo(CallbackInfo callbackInfo) {
        return native_getUpdateInfo(callbackInfo);
    }

    public int getUpdaterVersion(StringBuffer stringBuffer) {
        return native_getVersion(2, stringBuffer);
    }

    public int getSuarezVersion(StringBuffer stringBuffer) {
        return native_getVersion(6, stringBuffer);
    }

    public int getProductCode() {
        return native_getProductCode();
    }

    @Deprecated
    public int getMinAPILevel() {
        return native_getMinAPILevel(2);
    }

    @Deprecated
    public int getMaxAPILevel() {
        return native_getMaxAPILevel(2);
    }

    public int getVersionAll(TreeMap<String, String> treeMap) {
        native_getVersionAll(5, treeMap);
        return native_getVersionAll(2, treeMap);
    }

    public int setDebugOption() {
        return native_setDebugOption(2);
    }

    public int getOperationFlag() {
        return native_getOperationFlag();
    }

    public static String getCurrentABI() {
        return native_getCurrentABI();
    }*/

    static {
        System.loadLibrary("EngineManager");
    }
}
