package com.yinxt.mymvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：尹晓童
 * 创建时间：2016/7/20
 * 作用：
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    public abstract void initView();
    public abstract void initData();
    public abstract void initListener();
}
