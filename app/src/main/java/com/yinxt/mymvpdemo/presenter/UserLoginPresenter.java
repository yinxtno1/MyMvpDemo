package com.yinxt.mymvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.yinxt.mymvpdemo.bean.User;
import com.yinxt.mymvpdemo.biz.IUserBiz;
import com.yinxt.mymvpdemo.biz.OnLoginListener;
import com.yinxt.mymvpdemo.biz.UserBiz;
import com.yinxt.mymvpdemo.view.IUserLoginView;


/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：
 */
public class UserLoginPresenter {

    private IUserLoginView userLoginView;
    private IUserBiz userBiz;
    private Handler handler ;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userBiz = new UserBiz();
        handler = new Handler(Looper.getMainLooper());
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                //主线程执行
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.toMainActivity();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //主线程执行
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showFailedEror();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
