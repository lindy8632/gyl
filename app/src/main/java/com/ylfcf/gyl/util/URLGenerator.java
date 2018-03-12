package com.ylfcf.gyl.util;

/**
 * Created by Administrator on 2018/2/1.
 */

public class URLGenerator {
    private static final String API_DOMAIN_URL = "http://www.gylapi.com";//API环境
    private static URLGenerator mUrlGenerator;

    private final String UPLOAD_URL = "/co_user/info/updateCompUser";//文件上传
    private final String REGISTE_URL = "/co_user/info/register";//注册
    private final String LOGIN_URL = "/co_user/info/login";//登录

    public static URLGenerator getInstance() {
        if (mUrlGenerator == null) {
            mUrlGenerator = new URLGenerator();
        }
        return mUrlGenerator;
    }

    /**
     * 文件上传
     * @param userId
     * @param file
     * @param filename
     * @return
     */
    public String[] getUploadURL(String userId,String file,String filename){
        StringBuffer sb = new StringBuffer();
        sb.append("&id=").append(userId).append("&yyzz_img=").append(file).append("&yyzz_img_file=").append(filename);
        return new String[] { API_DOMAIN_URL + UPLOAD_URL, sb.toString() };
    }

    /**
     * 注册
     * @param mobile
     * @param password
     * @param coName
     * @return
     */
    public String[] getRegistURL(String mobile,String password,String coName){
        StringBuffer sb = new StringBuffer();
        sb.append("&mobile=").append(mobile).append("&password=").append(password).append("&co_name=").append(coName);
        return new String[] { API_DOMAIN_URL + REGISTE_URL, sb.toString() };
    }

    /**
     * 登录
     * @param mobile
     * @param password
     * @return
     */
    public String[] getLoginURL(String mobile,String password){
        StringBuffer sb = new StringBuffer();
        sb.append("&mobile=").append(mobile).append("&password=").append(password);
        return new String[] { API_DOMAIN_URL + LOGIN_URL, sb.toString() };
    }
}
