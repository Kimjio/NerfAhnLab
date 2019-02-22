package com.ahnlab.enginesdk.av;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.util.TreeMap;

public class EngineManagerWrapper {
    private native int native_cancelScanList();

    private static native String native_getCurrentABI();

    private native int native_getMaxAPILevel(int i);

    private native int native_getMinAPILevel(int i);

    private native int native_getReadyFileCountToSend();

    private native int native_getScanStatus(Object obj);

    private native int native_getVersion(int i, StringBuffer stringBuffer);

    private native int native_getVersionAll(int i, TreeMap<String, String> treeMap);

    private native int native_loadEngine(int i, String str);

    private native int native_sendFiles(Object obj);

    private native int native_setAllowFileSending(Object obj);

    private native int native_setDebugOption(int i);

    private native int native_setNetworkType(int i);

    private native int native_startScanFile(Object obj, Object obj2);

    private native int native_startScanList(Object obj, Object obj2);

    private native int native_stopSendingFiles();

    private native int native_unloadEngine(int i);

    public int loadEngine(String str) {
        return native_loadEngine(0, str);
    }

    public int getVersionAll(TreeMap<String, String> treeMap) {
        native_getVersionAll(5, treeMap);
        return native_getVersionAll(0, treeMap);
    }

    public int getEngineVersion(StringBuffer stringBuffer) {
        return native_getVersion(0, stringBuffer);
    }

    public int getSignatureVersion(StringBuffer stringBuffer) {
        return native_getVersion(3, stringBuffer);
    }

    @Deprecated
    public int getMinAPILevel() {
        return native_getMinAPILevel(0);
    }

    @Deprecated
    public int getMaxAPILevel() {
        return native_getMaxAPILevel(0);
    }

    public int unloadEngine() {
        return native_unloadEngine(0);
    }

    public int scanFile(SingleScanElement singleScanElement, MalwareInfo malwareInfo) {
        initializeCloudScan(singleScanElement);
        int native_startScanFile = native_startScanFile(singleScanElement, malwareInfo);
        finalizeCloudScan(singleScanElement);
        return native_startScanFile;
    }

    public int scanList(ListScanElement listScanElement, ListScanResult listScanResult) {
        initializeCloudScan(listScanElement);
        int native_startScanList = native_startScanList(listScanElement, listScanResult);
        finalizeCloudScan(listScanElement);
        return native_startScanList;
    }

    public int cancelScanList() {
        return native_cancelScanList();
    }

    public int getScanStatus(ListScanResult listScanResult) {
        return native_getScanStatus(listScanResult);
    }

    public int setNetworkType(int i) {
        return native_setNetworkType(i);
    }

    public int getReadyFileCountToSend() {
        return native_getReadyFileCountToSend();
    }

    public int setAllowFileSending(SendingFileProperties sendingFileProperties) {
        return native_setAllowFileSending(sendingFileProperties);
    }

    public int sendFiles(Context context, Handler handler) {
        registerNetworkObserver(context);
        int native_sendFiles = native_sendFiles(handler);
        unregisterNetworkObserver();
        return native_sendFiles;
    }

    public int stopSendingFiles() {
        return native_stopSendingFiles();
    }

    public static String getCurrentABI() {
        return native_getCurrentABI();
    }

    public int setDebugOption() {
        return native_setDebugOption(0);
    }

    private void initializeCloudScan(ScanElement scanElement) {
        if (scanElement.getCloudScanType() != 0) {
            registerNetworkObserver(scanElement.getContext());
        }
    }

    private void finalizeCloudScan(ScanElement scanElement) {
        if (scanElement.getCloudScanType() != 0) {
            unregisterNetworkObserver();
        }
    }

    private void registerNetworkObserver(Context context) {
        setNetworkType(getConnectedNetworkType(context));
        NetworkTypeChanger.getInstance().add(this);
    }

    private void unregisterNetworkObserver() {
        NetworkTypeChanger.getInstance().remove();
    }

    public int getConnectedNetworkType(Context context) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("Invalid application context.");
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    static {
        System.loadLibrary("EngineManager");
    }
}