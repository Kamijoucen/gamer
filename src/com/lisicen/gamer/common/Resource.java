package com.lisicen.gamer.common;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by X6TI on 2017/5/31.
 */
public class Resource {
    public static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
}
