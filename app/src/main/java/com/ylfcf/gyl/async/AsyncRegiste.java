package com.ylfcf.gyl.async;

import android.content.Context;

import com.ylfcf.gyl.info.BaseInfo;
import com.ylfcf.gyl.inter.Inter;
import com.ylfcf.gyl.parse.JsonParseCommon;
import com.ylfcf.gyl.util.BackType;
import com.ylfcf.gyl.util.HttpConnection;
import com.ylfcf.gyl.util.URLGenerator;

/**
 * Created by Administrator on 2018/2/7.
 */

public class AsyncRegiste extends AsyncTaskBase{
    private Context context;

    private String mobile;
    private String password;
    private String coName;

    private Inter.OnCommonInter onCommonInter;
    private BaseInfo baseInfo;

    public AsyncRegiste(Context context, String mobile,String password,String coName,
                       Inter.OnCommonInter onCommonInter) {
        this.context = context;
        this.mobile = mobile;
        this.password = password;
        this.coName = coName;
        this.onCommonInter = onCommonInter;
    }

    @Override
    protected String doInBackground(String... params) {
        String url[] = null;
        String result = null;
        try {
            url = URLGenerator.getInstance().getRegistURL(mobile,password,coName);
            if (result == null) {
                result = HttpConnection.postConnection(url[0], url[1]);
            }
            if (result == null) {
                result = BackType.FAILE;
            } else {
                baseInfo = JsonParseCommon.parseData(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = BackType.ERROR;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (isCancelled()) {
            return;
        }
        if (BackType.ERROR.equals(result)) {
            // 访问错误
            onCommonInter.back(null);
        } else if (BackType.FAILE.equals(result)) {
            // 获取失败
            onCommonInter.back(null);
        } else {
            // 获取成功
            onCommonInter.back(baseInfo);
        }
    }
}
