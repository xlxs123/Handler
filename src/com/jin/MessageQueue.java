package com.jin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {

    BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);

    public void enqueueMessage(Message msg) {
        try {
            queue.put(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message next() {
        Message msg = null;
        try {
            msg = queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
