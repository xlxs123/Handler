package com.jin;

public class Handler {
    final MessageQueue mQueue;
    final Looper mLooper;

    public Handler() {
        mLooper = Looper.myLooper();
        mQueue = mLooper.mQueue;
    }

    public void sendMessage(Message msg) {
        enqueueMessage(msg);
    }

    private void enqueueMessage(Message msg) {
        msg.target = this;
        mQueue.enqueueMessage(msg);
    }

    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

    public void handleMessage(Message msg) {

    }
}
