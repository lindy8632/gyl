package com.ylfcf.gyl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylfcf.gyl.R;
import com.ylfcf.gyl.async.AsyncLogin;
import com.ylfcf.gyl.info.BaseInfo;
import com.ylfcf.gyl.info.UserInfo;
import com.ylfcf.gyl.inter.Inter;
import com.ylfcf.gyl.util.SettingManager;
import com.ylfcf.gyl.util.ThreadUtils;
import com.ylfcf.gyl.util.Util;

/**
 * Created by Administrator on 2018/2/5.
 */

public class LoginActivity extends BaseActivity{
    private TextView topTitleTV;
    private LinearLayout topLeftLayout;
    private ImageView topLeftBtn;

    private EditText unameET,pwdET;
    private Button loginBtn;
    private TextView registTV,forgetPwdTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public void findViews() {
        topTitleTV = (TextView) findViewById(R.id.common_topbar_title);
        topLeftLayout = (LinearLayout) findViewById(R.id.common_topbar_left_layout);
        topLeftLayout.setOnClickListener(this);
        topLeftBtn = (ImageView) findViewById(R.id.common_topbar_left_btn);
        topLeftBtn.setImageResource(R.drawable.close_img);
        topTitleTV.setText("登录");

        unameET = (EditText) findViewById(R.id.login_activity_phone_et);
        pwdET = (EditText) findViewById(R.id.login_activity_pwd_et);
        loginBtn = (Button) findViewById(R.id.login_activity_btn);
        loginBtn.setOnClickListener(this);
        registTV = (TextView) findViewById(R.id.login_activity_register_tv);
        registTV.setOnClickListener(this);
        forgetPwdTV = (TextView) findViewById(R.id.login_activity_forget_pwd_tv);
        forgetPwdTV.setOnClickListener(this);
    }

    @Override
    public void onViewClick(View v) {
        switch (v.getId()){
            case R.id.common_topbar_left_layout:
                finish();
                break;
            case R.id.login_activity_btn:
                checkData();
                break;
            case R.id.login_activity_register_tv:
                Intent intentReg = new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intentReg);
                break;
            case R.id.login_activity_forget_pwd_tv:
                Intent intentFor = new Intent(LoginActivity.this,ForgetPwdActivity.class);
                startActivity(intentFor);
                break;
        }
    }

    private void checkData(){
        String mobileS = unameET.getText().toString();
        String pwdS = pwdET.getText().toString();
        if(mobileS != null && !"".equals(mobileS)&&Util.checkPhoneNumber(mobileS)){
            if(pwdS != null && !"".equals(pwdS)){
                requestLogin(mobileS,Util.md5Encryption(pwdS));
            }else{
                Util.toastLong(LoginActivity.this,"请输入密码");
            }
        }else{
            Util.toastLong(LoginActivity.this,"请输入正确的手机号码");
        }
    }

    /**
     * 登录
     * @param mobile
     * @param password
     */
    private void requestLogin(String mobile,String password){
        if(mLoadingDialog != null){
            mLoadingDialog.show();
        }
        AsyncLogin loginTask = new AsyncLogin(LoginActivity.this, mobile, password,
                new Inter.OnCommonInter() {
                    @Override
                    public void back(BaseInfo baseInfo) {
                        if(mLoadingDialog != null && mLoadingDialog.isShowing()){
                            mLoadingDialog.dismiss();
                        }
                        if(baseInfo != null){
                            int resultCode = SettingManager.getResultCode(baseInfo);
                            UserInfo userInfo = baseInfo.getmUserInfo();
                            if(resultCode == 0){
                                Util.toastLong(LoginActivity.this,"登录成功");
                                SettingManager.setUserId(LoginActivity.this,userInfo.getId());
                                Intent intent = new Intent();
                                setResult(MainFragmentActivity.RESULTCODE_LOGIN,intent);
                                finish();
                            }
                        }
                    }
                });
        loginTask.executeAsyncTask(ThreadUtils.FULL_TASK_EXECUTOR);
    }
}
