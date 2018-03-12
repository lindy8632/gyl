package com.ylfcf.gyl.ui;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/1.
 */

public class MyApplication extends android.app.Application{
    private List<Activity> activityList;
    private static MyApplication theApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        theApplication = this;
        activityList = new ArrayList<Activity>();
        init();
    }

    private void init(){

    }
    private static void initialize() {
        theApplication = new MyApplication();
        theApplication.onCreate();
    }

    /**
     *
     * @return
     */
    public static MyApplication getApplication() {
        if (theApplication == null)
            initialize();
        return theApplication;
    }

    public MainFragmentActivity getMainActivity() {
        MainFragmentActivity mainActivity = null;
        for (Activity activity : activityList) {
            if (activity instanceof MainFragmentActivity) {
                mainActivity = (MainFragmentActivity) activity;
                break;
            }
        }
        return mainActivity;
    }

    public static MyApplication getContext() {
        return theApplication;
    }

    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    public void finishAllActivity() {
        for (Activity activity : activityList) {
            if (null != activity) {
                activity.finish();
            }
        }
    }
}
