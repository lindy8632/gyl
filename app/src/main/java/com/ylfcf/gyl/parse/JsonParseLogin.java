package com.ylfcf.gyl.parse;

import com.ylfcf.gyl.info.BaseInfo;
import com.ylfcf.gyl.info.UserInfo;
import com.ylfcf.gyl.util.MainJson;
import com.ylfcf.gyl.util.SettingManager;

import org.json.JSONObject;

/**
 * Created by Administrator on 2018/3/8.
 */

public class JsonParseLogin {
    private BaseInfo baseInfo;
    private UserInfo userInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void parseUserInfo(String s) throws Exception{
        JSONObject object = null;
        try {
            object = new JSONObject(s);
        } catch (Exception e) {
        }

        if (object != null) {
            userInfo = (UserInfo) MainJson.fromJson(UserInfo.class, object);
            baseInfo.setmUserInfo(userInfo);
        }
    }

    /**
     * @param result
     * @throws Exception
     */
    public void parseMain(String result) throws Exception {
        JSONObject object = null;
        try {
            object = new JSONObject(result);
        } catch (Exception e) {
        }

        if (object != null) {
            baseInfo = (BaseInfo) MainJson.fromJson(BaseInfo.class, object);
            int resultCode = SettingManager.getResultCode(baseInfo);
            if(resultCode == 0){
                parseUserInfo(baseInfo.getMsg());
            }
        }
    }

    /**
     * 解析调用接口
     *
     * @param result
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static BaseInfo parseData(String result) throws Exception {
        JsonParseLogin jsonParse = new JsonParseLogin();
        jsonParse.parseMain(result);
        return jsonParse.getBaseInfo();
    }
}
