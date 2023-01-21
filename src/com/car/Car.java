package com.car;

import java.util.concurrent.Semaphore;

public class Car {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(8);
        for (int i = 0; i < 51; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println("车辆"+Thread.currentThread().getName() + " 停车并加油" );
                        Thread.sleep(6000);
                        System.out.println("车辆"+Thread.currentThread().getName() + " 停车、加油6秒后离开 ");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                });
                thread.setName(String.valueOf(i));
                thread.start();
        }
    }
}
