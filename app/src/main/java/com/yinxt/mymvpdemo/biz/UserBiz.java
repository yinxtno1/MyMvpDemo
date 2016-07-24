package com.yinxt.mymvpdemo.biz;

import com.yinxt.mymvpdemo.bean.User;

/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String name, final String password, final OnLoginListener listener) {
        //模拟耗时（网络）操作
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //登录成功
                if("123".equals(name)&&"123".equals(password)){
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    listener.loginSuccess(user);
                }else{//登录失败
                    listener.loginFailed();
                }

            }
        }.start();
    }
}
