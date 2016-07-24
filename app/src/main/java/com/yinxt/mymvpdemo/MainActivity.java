package com.yinxt.mymvpdemo;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yinxt.mymvpdemo.presenter.UserLoginPresenter;
import com.yinxt.mymvpdemo.base.BaseActivity;
import com.yinxt.mymvpdemo.view.IUserLoginView;

public class MainActivity extends BaseActivity implements IUserLoginView{

    EditText et_name;
    EditText et_password;
    Button btn_login;
    Button btn_clear;
    ProgressBar pb_loading;

    UserLoginPresenter presenter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
    }

    @Override
    public void initData() {
        presenter = new UserLoginPresenter(this);
    }

    @Override
    public void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return et_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString();
    }

    @Override
    public void clearUserName() {
        et_name.setText("");
    }

    @Override
    public void clearPassword() {
        et_password.setText("");
    }

    @Override
    public void showLoading() {
        pb_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb_loading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedEror() {
        Toast.makeText(getApplicationContext(), "账号密码错误", Toast.LENGTH_SHORT).show();
    }

}
