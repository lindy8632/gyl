package com.ylfcf.gyl.util;

import android.util.Log;

/**
 * Created by Administrator on 2018/2/1.
 */

public class MyLogger {
    private static final boolean DEBUG = true;
    private static String tagTemp = "gyl";

    /**
     * 运行时日志，打包之后不会显示
     * @param msg
     */
    public static void d(String msg) {
        if (DEBUG) {
            Log.d(tagTemp, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(tagTemp, msg);
        }
    }

    public static void i(String tag,String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }
}
