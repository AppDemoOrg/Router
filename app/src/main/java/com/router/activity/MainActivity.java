package com.router.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.router.R;
import com.router.service.IService;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @描述：     @MainActivity
 * @作者：     @黄卫旗
 * @创建时间： @21/05/2018
 */
public class MainActivity extends AppCompatActivity implements NavigationCallback {

    @Autowired(name = "/service/hello")
    IService mAlphaService;

    @Autowired(name = "/service/hey")
    IService mBetaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt1) void bt1Click() {
        ARouter.getInstance().build("/com/LocalActivity").withString("key", "value:123").navigation(this, this);
    }

    /** 自定义路由分组，发起路由 */
    @OnClick(R.id.bt2) void bt2Click() {
        ARouter.getInstance().build("/com/GroupActivity", "customGroup").navigation();
    }

    /** 加载本地html */
    @OnClick(R.id.bt3) void bt3Click() {
        ARouter.getInstance().build("/com/WebActivity").navigation();
    }

    /** 暴露服务 */
    @OnClick(R.id.bt4) void bt4Click() {
        ARouter.getInstance().inject(this);
        mAlphaService.sayHello(this);
    }

    /** 暴露服务 */
    @OnClick(R.id.bt5) void bt5Click() {
        ARouter.getInstance().inject(this);
        mBetaService.sayHello(this);
    }

    @Override
    public void onFound(Postcard postcard) {
        Logger.e("onArrival: 找到了 ");
    }

    @Override
    public void onLost(Postcard postcard) {
        Logger.e("onArrival: 找不到 ");
    }

    @Override
    public void onArrival(Postcard postcard) {
        String group = postcard.getGroup();
        Logger.e("onArrival: 跳转完了，分组是: " + group);
    }

    @Override
    public void onInterrupt(Postcard postcard) {
        Logger.e("onArrival: 被拦截了 ");
    }
}
