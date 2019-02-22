package com.ahnlab.enginesdk.av;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListScanElement extends ScanElement {
    int appScope;
    String targetDir;

    public static class Builder extends ScanElement.Builder {
        private int appScope = 0;
        private String targetDir;

        public Builder(@NonNull Context context) {
            super(context);
        }

        public Builder setScanScope(@IntRange(from = 1, to = 3) int i) {
            super.setScanScope(i);
            return this;
        }

        public Builder setCloudScanType(int i) {
            super.setCloudScanType(i);
            return this;
        }

        public Builder setCloudExtraScanOn(boolean z) {
            super.setCloudExtraScanOn(z);
            return this;
        }

        public Builder setRecursiveScanOn(boolean z) {
            super.setRecursiveScanOn(z);
            return this;
        }

        public Builder setHandler(@Nullable Handler handler) {
            super.setHandler(handler);
            return this;
        }

        public Builder setTargetAppScope(@IntRange(from = 0, to = 2) int i) {
            this.appScope = i;
            return this;
        }

        public Builder setTargetDirectory(@Nullable String str) {
            this.targetDir = str;
            return this;
        }

        public int getTargetAppScope() {
            return this.appScope;
        }

        public String getTargetDirectory() {
            return this.targetDir;
        }

        public ListScanElement build() throws IllegalStateException {
            if (this.appScope != 0 || !TextUtils.isEmpty(this.targetDir)) {
                return new ListScanElement(this);
            }
            throw new IllegalStateException("Scan Target has not been determined.");
        }
    }

    private ListScanElement(Builder builder) {
        super(builder);
        this.appScope = builder.getTargetAppScope();
        this.targetDir = builder.getTargetDirectory();
    }

    ListScanElement() {
    }

    public String toString() {
        return "target dir: " + this.targetDir + ", " + "application scope: " + this.appScope + ", " + super.toString();
    }

    public int getTargetAppScope() {
        return this.appScope;
    }

    public String getTargetDirectory() {
        return this.targetDir;
    }
}
