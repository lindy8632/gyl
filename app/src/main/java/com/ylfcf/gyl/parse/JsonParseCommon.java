package com.ylfcf.gyl.parse;

import com.ylfcf.gyl.info.BaseInfo;
import com.ylfcf.gyl.util.MainJson;

import org.json.JSONObject;

/**
 * Created by Administrator on 2018/2/1.
 */

public class JsonParseCommon {
    private BaseInfo baseInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
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
        JsonParseCommon jsonParse = new JsonParseCommon();
        jsonParse.parseMain(result);
        return jsonParse.getBaseInfo();
    }
}
