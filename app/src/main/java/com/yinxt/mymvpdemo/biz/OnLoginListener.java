package com.yinxt.mymvpdemo.biz;

import com.yinxt.mymvpdemo.bean.User;

/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：登陆回调的接口
 */
public interface OnLoginListener {

    void loginSuccess(User user);
    void loginFailed();
}
