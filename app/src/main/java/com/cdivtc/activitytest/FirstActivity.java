package com.cdivtc.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    private final static String TAG ="FirstActivity";
    //定义全局变量
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TAG, "调用了onCreate()方法 ");
        Log.d(TAG, this.toString());
        setContentView(R.layout.first_layout);
        //自定义一个用于绑定控件与变量的方法
        findViews();
        //1、写button1的监听事件,显示 Intent打开第二个活动(SecondActivity
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        //2、写button2的监听事件，隐式Intent 打开浏览器，打开百度的主页
        /*button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实例化一个Intent
                Intent intent = new Intent();
                //设置动作Action
                intent.setAction("android.intent.action.VIEW");
                //设置要打开的网址，通过Uri.parse方法来进行解析，其中的字符串第一部分为协议(scheme)，第二部分为主机的域名（host)
                intent.setData(Uri.parse("http://www.baidu.com"));
                //启动
                startActivity(intent);

            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "调用了onStart()方法 ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    //通过调用findViews方法将控件与变量绑定
    private void findViews() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
    }


    public void openBrowser(View view) {
        //实例化一个Intent
        Intent intent = new Intent();
        //设置动作Action
        intent.setAction("android.intent.action.VIEW");
        //设置要打开的网址，通过Uri.parse方法来进行解析，其中的字符串第一部分为协议(scheme)，第二部分为主机的域名（host)
        intent.setData(Uri.parse("http://www.baidu.com"));
        //启动
        startActivity(intent);
    }

    public void openMap(View view) {
        //定义一个字符串地名并通过Uri.encode方法进行解析
        /*String encodeName = Uri.encode("成都工业职业技术学院");
        //用Uri.parse将地名解析为经纬度
        Uri locationUri = Uri.parse("geo:0,0?q="+encodeName);*/
        //设置动作Action
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(locationUri);
        //直接解析经纬度
        intent.setData(Uri.parse("geo:104.07,30.67?z=11"));
        startActivity(intent);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:13438039249"));
        startActivity(intent);
    }
}
