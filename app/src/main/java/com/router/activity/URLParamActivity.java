package com.router.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.router.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/com/URLParamActivity")
public class URLParamActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView textView;
    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired
    boolean boy;
    @Autowired
    int high;
    @Autowired
    String obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_url2);
        ButterKnife.bind(this);

        textView.setText("参数是： " + "name: " + name + "  age: " + age
                + " boy: " + boy + " Name: " + getIntent().getExtras().getString("name") + " obj: " + obj.toString());
    }
}
