package com.lisicen.gamer.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by X6TI on 2017/6/1.
 */
public class Refresh {
    private boolean isDown = false;
    private long fpsTime = 0;
    private ExecutorService service = null;

    private Refresh(int rate, ExecutorService service) {
        fpsTime = (1000 / rate) * 1000000;
        this.service = service;
    }

    public static Refresh create(int rate) {
        return new Refresh(rate, Executors.newSingleThreadExecutor());
    }

    public void exe(CallBack back) {
        service.execute(() -> {
            while (!isDown) {
                long before = System.nanoTime();
                back.call();
                long after = System.nanoTime();
                long total = after - before;
                if (total > fpsTime) {
                    continue;
                }
                try {
                    Thread.sleep((fpsTime - total) / 1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void shutdown() {
        isDown = true;
        service.shutdown();
    }
}
