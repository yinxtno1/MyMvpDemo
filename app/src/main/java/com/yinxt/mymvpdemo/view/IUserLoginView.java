package com.yinxt.mymvpdemo.view;

/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：
 */
public interface IUserLoginView {

    String getUserName();
    String getPassword();

    void clearUserName();
    void clearPassword();

    void showLoading();
    void hideLoading();

    void toMainActivity();
    void showFailedEror();
}
