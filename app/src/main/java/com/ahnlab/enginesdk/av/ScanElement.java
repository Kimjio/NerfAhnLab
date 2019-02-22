package com.ahnlab.enginesdk.av;

import android.content.Context;
import android.os.Handler;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ScanElement {
    boolean cloudExtScanOn;
    int cloudScanType;
    Context context;
    Handler handler;
    boolean recursiveScanOn;
    int scanScope;

    protected static abstract class Builder {
        private boolean cloudExtScanOn = false;
        private int cloudScanType = 0;
        private Context context;
        private Handler handler = null;
        private boolean recursiveScanOn = false;
        private int scanScope = 1;

        public abstract ScanElement build() throws IllegalStateException;

        protected Builder(@NonNull Context context) {
            this.context = context;
        }

        public Context getContext() {
            return this.context;
        }

        public int getScanScope() {
            return this.scanScope;
        }

        public boolean isRecursiveScanOn() {
            return this.recursiveScanOn;
        }

        public int getCloudScanType() {
            return this.cloudScanType;
        }

        public Handler getHandler() {
            return this.handler;
        }

        public boolean getCloudExtraScanOn() {
            return this.cloudExtScanOn;
        }

        public Builder setScanScope(@IntRange(from = 1, to = 3) int i) {
            this.scanScope = i;
            return this;
        }

        public Builder setRecursiveScanOn(boolean z) {
            this.recursiveScanOn = z;
            return this;
        }

        public Builder setCloudScanType(int i) {
            this.cloudScanType = i;
            return this;
        }

        public Builder setCloudExtraScanOn(boolean z) {
            this.cloudExtScanOn = z;
            return this;
        }

        public Builder setHandler(@Nullable Handler handler) {
            this.handler = handler;
            return this;
        }
    }

    protected ScanElement(Builder builder) {
        this.scanScope = builder.getScanScope();
        this.context = builder.getContext();
        this.recursiveScanOn = builder.isRecursiveScanOn();
        this.cloudScanType = builder.getCloudScanType();
        this.cloudExtScanOn = builder.getCloudExtraScanOn();
        this.handler = builder.getHandler();
    }

    ScanElement() {
    }

    public String toString() {
        return "cloud scan type: " + this.cloudScanType + ", " + "scan scope: " + this.scanScope + ", " + "r-scan: " + this.recursiveScanOn + ", " + "cloud extra on: " + this.cloudExtScanOn;
    }

    public int getCloudScanType() {
        return this.cloudScanType;
    }

    public Context getContext() {
        return this.context;
    }

    public int getScanScope() {
        return this.scanScope;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public boolean getCloudExtraScanOn() {
        return this.cloudExtScanOn;
    }

    public boolean isRecursiveScanOn() {
        return this.recursiveScanOn;
    }
}
