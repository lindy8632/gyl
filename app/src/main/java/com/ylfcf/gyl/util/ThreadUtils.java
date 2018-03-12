package com.ylfcf.gyl.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ThreadUtils {
    public static ExecutorService FULL_TASK_EXECUTOR = (ExecutorService) Executors.newFixedThreadPool(4);
}
