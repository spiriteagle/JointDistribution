package com.acuit.jointdistribution.Common.Presenter;

import android.app.Activity;

import com.acuit.jointdistribution.Common.View.Activity.FirstActivity;
import com.acuit.jointdistribution.Common.View.Activity.LoginView_Interface;
import com.acuit.jointdistribution.Common.Model.Interface.LoginModel_Interface;
import com.acuit.jointdistribution.Common.Model.LoginModel_Impl;

/**
 * 类名: LoginPresenter <p>
 * 创建人: YanJ <p>
 * 创建时间: 2017/8/18 17:23 <p>
 * 描述:
 * <p>
 * 更新人: <p>
 * 更新时间: <p>
 * 更新描述: <p>
 */

public class LoginPresenter {

    private LoginView_Interface mView;
    private LoginModel_Interface mModel;
    private Activity activity;


    public LoginPresenter(LoginView_Interface mView) {
        this.mView = mView;
        this.mModel = new LoginModel_Impl(this);
        this.activity = (Activity) mView;
    }


    /**
     * 检测账户记录
     */
    public void chickHistory() {
        if (mModel.chickHistory()) {
//            存在账户记录
            mModel.login();

        } else {
//            跳转登录界面
            mModel.startLoginActivity(1000);
        }
    }


    public void login(String account, String phone, String pwd) {
        mModel.login(account, phone, pwd);
    }

    public void showToast(String msg) {
        mView.showToast(msg);
    }

    public void startLoginActivity() {
        mView.startLoginActivity();
        if (mView instanceof FirstActivity ? true : false) {
            mView.finish();
        }
    }

    public void startStoremanHome() {
        mView.startStoremanHome();
        mView.finish();
    }

    public void startSupplierHome() {
        mView.startSupplierHome();
        mView.finish();
    }
}
