package com.ahnlab.enginesdk.rc;

public class RootCheckInfo {
    String description;
    int detectedType;
    int ruleID;

    public int getRuleID() {
        return this.ruleID;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDetectedType() {
        return this.detectedType;
    }
}
