package com.ahnlab.enginesdk;

public class AttachmentMaker {
    private native int native_makeAttachment(String str);

    static {
        System.loadLibrary("EngineManager");
    }

}
