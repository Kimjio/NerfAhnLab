package com.ahnlab.enginesdk.rc;

import android.content.Context;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import java.util.Objects;

public class RootCheckElement {
    final int checkScopes;
    final Context context;
    final int interval;
    final int options;

    public static class Builder {
        private int checkScopes = 7;
        private Context context;
        private int interval = 0;
        private int options = 0;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder setOptions(@IntRange(from = 0) int i) {
            this.options |= i;
            return this;
        }

        public Builder setInterval(@IntRange(from = 5, to = 600) int i) {
            if (i < 5) {
                this.interval = 5;
            } else if (i > 600) {
                this.interval = 600;
            } else {
                this.interval = i;
            }
            return this;
        }

        public Builder setCheckScope(@IntRange(from = 1) int i) {
            this.checkScopes |= i;
            return this;
        }

        public RootCheckElement build() {
            if (this.context == null)
                throw new NullPointerException("context == null");
            return new RootCheckElement(this);
        }
    }

    private RootCheckElement(Builder builder) {
        this.context = builder.context;
        this.options = builder.options;
        this.interval = builder.interval;
        this.checkScopes = builder.checkScopes;
    }

    RootCheckElement(Context context, int i, int i2, int i3) {
        this.context = context;
        this.options = i;
        this.interval = i2;
        this.checkScopes = i3;
    }

    public Context getContext() {
        return this.context;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getOptions() {
        return this.options;
    }

    public int getCheckScopes() {
        return this.checkScopes;
    }
}
