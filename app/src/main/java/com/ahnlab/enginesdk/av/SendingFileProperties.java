package com.ahnlab.enginesdk.av;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public class SendingFileProperties {
    int fileType;
    String path;

    public static class Builder {
        private int fileType = -1;
        private String path = null;

        public Builder setPath(@NonNull String str) {
            this.path = str;
            return this;
        }

        public Builder setFileType(@IntRange(from = 0, to = 1) int i) {
            this.fileType = i;
            return this;
        }

        public SendingFileProperties build() {
            if (this.path == null) {
                throw new IllegalArgumentException("SendingFileProperties path cannot be null.");
            } else if (this.fileType == 0 || this.fileType == 1) {
                return new SendingFileProperties(this);
            } else {
                throw new IllegalArgumentException("SendingFileProperties fileType is invalid.");
            }
        }
    }

    private SendingFileProperties(Builder builder) {
        this.path = builder.path;
        this.fileType = builder.fileType;
    }

    SendingFileProperties() {
    }
}
