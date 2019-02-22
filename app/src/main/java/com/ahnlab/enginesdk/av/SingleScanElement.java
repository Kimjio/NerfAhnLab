package com.ahnlab.enginesdk.av;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SingleScanElement extends ScanElement {
    boolean isInstalled;
    String pkgName;
    String target;

    public static class Builder extends ScanElement.Builder {
        private String target = null;

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

        public Builder setTargetPath(@NonNull String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalStateException("Scan Target has not been determined.");
            }
            this.target = str;
            return this;
        }

        public String getTargetPath() {
            return this.target;
        }

        public SingleScanElement build() throws IllegalStateException {
            if (!TextUtils.isEmpty(this.target)) {
                return new SingleScanElement(this);
            }
            throw new IllegalStateException("Scan Target has not been determined.");
        }
    }

    private SingleScanElement(Builder builder) {
        super(builder);
        this.target = builder.target;
        this.pkgName = getPkgName(builder);
        if (this.pkgName != null) {
            this.isInstalled = true;
        } else {
            this.isInstalled = false;
        }
    }

    SingleScanElement() {
    }

    public String toString() {
        return "target path: " + this.target + ", " + "application pkgName: " + this.pkgName + ", " + "application installed: " + this.isInstalled + ", " + super.toString();
    }

    public String getTargetPath() {
        return this.target;
    }

    public String getPackageName() {
        return this.pkgName;
    }

    public boolean isInstalled() {
        return this.isInstalled;
    }

    private String getPkgName(Builder builder) {
        Context context = builder.getContext();
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(this.target, PackageManager.MATCH_UNINSTALLED_PACKAGES);
            if (packageArchiveInfo == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageArchiveInfo.packageName, PackageManager.MATCH_UNINSTALLED_PACKAGES);
            if (packageInfo == null) {
                return null;
            }
            if (this.target.equals(packageInfo.applicationInfo.sourceDir)) {
                return packageInfo.packageName;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
