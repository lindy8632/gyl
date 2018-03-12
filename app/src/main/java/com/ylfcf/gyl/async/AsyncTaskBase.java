package com.ylfcf.gyl.async;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

import java.util.concurrent.ExecutorService;

/**
 * Created by Administrator on 2018/2/1.
 */

public class AsyncTaskBase extends AsyncTask<String, Void, String> {
    public AsyncTaskBase(){}

    @Override
    protected String doInBackground(String... params) {
        return null;
    }

    /**
     * 执行
     */
    @SuppressLint("NewApi")
    public void executeAsyncTask(ExecutorService executorService) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            this.execute("");
        } else {
            this.executeOnExecutor(executorService, "");
        }
    }
}
