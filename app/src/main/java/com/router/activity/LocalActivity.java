package com.router.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.router.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/** 在path这个字符串里面，”com” 就代表组的标识；“LocalActivity” 代表是Activity1类的具体表示
    组的标识和类的标识都可以自己定义的，需要记住的是组标识和类标识之间用斜杠来区分”\”
    在支持路由的页面上添加注解(必选)
    这里的路径需要注意的是至少需要有两级，/xx/xx
 */
@Route(path = "/com/LocalActivity")
public class LocalActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView textView;

    @OnClick(R.id.addFragment) void btnAdd() {
        Fragment fragment = (Fragment) ARouter.getInstance().build("/com/LocalFragment").navigation();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        ButterKnife.bind(this);
        textView.setText("参数是：" + getIntent().getStringExtra("key")); //接收参数
    }

}
