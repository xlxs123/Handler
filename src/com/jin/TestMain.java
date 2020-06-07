package com.jin;


import java.util.UUID;

public class TestMain {

    public static void main(String[] args) {
        Looper.prepare();
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                System.out.println("Thread Id: " + Thread.currentThread().getName() + " received msg: " + msg.toString());
            }
        };
        new Thread(() -> {
            int count = 10;
            for (int i = 0; i < count; i++) {
                Message msg = new Message(UUID.randomUUID().toString());
                System.out.println(Thread.currentThread().toString() + " send message: " + msg.toString());
                handler.sendMessage(msg);
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();

        Looper.loop();

    }

}
