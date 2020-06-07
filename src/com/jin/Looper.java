package com.jin;

public class Looper {

    MessageQueue mQueue;
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    public static void loop() {
        final Looper me = myLooper();
        final MessageQueue queue = me.mQueue;
        for (; ; ) {
            Message msg = queue.next();
            if (msg != null) {
                msg.target.dispatchMessage(msg);
            }
        }
    }

}
