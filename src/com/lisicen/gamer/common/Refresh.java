package com.lisicen.gamer.common;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.Ref;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 根据刷新率平滑刷新
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

    public static Refresh create(int rate, int poolSize) {
        return new Refresh(rate, Executors.newFixedThreadPool(poolSize));
    }


    public void execute(int count, CallBack back) {
        service.execute(() -> {
            int i = count;
            while (!isDown && (--i) >= 0) {
                exe(back);
            }
        });
    }

    public void execute(CallBack back) {
        service.execute(() -> {
            while (!isDown) {
                exe(back);
            }
        });
    }

    public void shutdown() {
        isDown = true;
        service.shutdown();
    }

    private void exe(CallBack back) {
        long before = System.nanoTime();
        back.call();
        long after = System.nanoTime();
        long total = after - before;
        if (total > fpsTime) {
            return;
        }
        try {
            Thread.sleep((fpsTime - total) / 1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
