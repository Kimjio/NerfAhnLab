package com.ahnlab.enginesdk.rc;

import android.content.Context;

import androidx.annotation.NonNull;

public class TamperDetectionElement {
    Context context;

    public static class Builder {
        private Context context;

        public Builder(@NonNull Context context) throws IllegalArgumentException {
            if (context == null) {
                throw new IllegalArgumentException("context cannot be null.");
            }
            this.context = context;
        }

        public TamperDetectionElement build() {
            return new TamperDetectionElement(this);
        }
    }

    TamperDetectionElement() {
    }

    private TamperDetectionElement(Builder builder) {
        this.context = builder.context;
    }

    public Context getContext() {
        return this.context;
    }

}
