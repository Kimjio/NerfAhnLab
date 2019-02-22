package com.ahnlab.enginesdk.av;

import java.util.ArrayList;

public class ListScanResult {
    int completedCnt = 0;
    int detectedCnt = 0;
    protected ArrayList<MalwareInfo> detectedList = new ArrayList<>();
    int totalCnt = 0;

    protected ListScanResult() {
    }

    public int getCompletedCount() {
        return this.completedCnt;
    }

    public int getTotalCount() {
        return this.totalCnt;
    }

    public int getDetectedCount() {
        return this.detectedCnt;
    }

    public ArrayList<MalwareInfo> getDetectedList() {
        return this.detectedList;
    }
}
