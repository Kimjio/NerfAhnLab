package com.ahnlab.enginesdk.av;

import androidx.annotation.NonNull;

class NetworkTypeChanger {
    private static NetworkTypeChanger INSTANCE = new NetworkTypeChanger();
    private EngineManagerWrapper manager = null;
    private int observerCount = 0;

    public void update(int i) {
        if (this.manager == null) {
            removeObserver();
            this.observerCount = 0;
            return;
        }
        this.manager.setNetworkType(i);
    }

    private NetworkTypeChanger() {
    }

    static NetworkTypeChanger getInstance() {
        return INSTANCE;
    }

    synchronized void add(@NonNull EngineManagerWrapper engineManagerWrapper) {
        if (engineManagerWrapper == null) {
            throw new IllegalArgumentException("EngineManagerWrapper cannot be null.");
        }
        if (this.manager == null) {
            this.manager = engineManagerWrapper;
        }
        this.observerCount++;
        registerObserver();
    }

    synchronized void remove() {
        if (this.observerCount <= 0) {
            throw new RuntimeException("Did you add to NetworkTypeChanger?");
        }
        int i = this.observerCount - 1;
        this.observerCount = i;
        if (i == 0) {
            removeObserver();
        }
    }

    private void registerObserver() {
        //ConnectivityChangeReceiver.register(this);
    }

    private void removeObserver() {
        //ConnectivityChangeReceiver.remove(this);
    }
}
