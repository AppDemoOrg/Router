package com.router.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.router.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/com/WebActivity")
public class WebActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        webView.loadUrl("file:///android_asset/schema.html");
    }
}
