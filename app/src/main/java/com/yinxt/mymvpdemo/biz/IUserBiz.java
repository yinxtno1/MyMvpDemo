package com.yinxt.mymvpdemo.biz;

/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：
 */
public interface IUserBiz {

    void login(String name,String password,OnLoginListener listener);
}
