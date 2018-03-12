package com.ylfcf.gyl.info;

/**
 * Created by Administrator on 2018/2/1.
 */

public class BaseInfo implements java.io.Serializable{
    private static final long serialVersionUID = 7558055137995192708L;

    private String time;
    /*
     * 网络请求返回的错误编号 0表示成功
     */
    private String error_id;
    private String error;
    /*
     * 网络请求的结果描述
     */
    private String msg;

    private UserInfo mUserInfo;

    public UserInfo getmUserInfo() {
        return mUserInfo;
    }

    public void setmUserInfo(UserInfo mUserInfo) {
        this.mUserInfo = mUserInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getError_id() {
        return error_id;
    }

    public void setError_id(String error_id) {
        this.error_id = error_id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
