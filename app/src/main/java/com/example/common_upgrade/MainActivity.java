package com.example.common_upgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Environment;

import com.example.updateapp.AppUpdateManager;
import com.example.updateapp.DownLoadManager;

/**
 * 测试运行的应用demo
 * @author hyx
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.download);
        //样式1普通
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",false,1,0);
            }
        });
       //样式1强制
        Button bt1=findViewById(R.id.download_one);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",true,1,0);
            }
        });

        Button bt2=findViewById(R.id.downloadtwo);
        //样式2普通
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",false,2,0);
            }
        });
        //样式2强制
        Button bt_one=findViewById(R.id.downloadtwo_one);
        bt_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",true,2,0);
            }
        });


        Button bt3=findViewById(R.id.downloadthree);
        //样式3普通
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",false,3,0);
            }
        });
        //样式3强制
        Button bt3_one=findViewById(R.id.downloadthree_one);
        bt3_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",true,3,0);
            }
        });

        //自定义样式
        Button bt_four=findViewById(R.id.download_four);
        bt_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(MainActivity.this,"1.0.1",false,4,R.mipmap.update_top_bg);
            }
        });

    }

    /**
     *
     * @param activity  当前activity
     * @param versonName 当前版本
     * @param force 是否强制升级
     * @param type  平台提供三种样式1,2,3则为样式,4 (4:表示自定义样式)
     * @param bgResoureID ：如果type=4，则需要传入自定义背景图片，非自定义直接传0
     */
    private void  dodown(Activity activity,String versonName, boolean force,int type,int bgResoureID){
        DownLoadManager mdownload=new DownLoadManager();
        mdownload.checkAppUpdate(MainActivity.this,"1.0.0",force,type,bgResoureID);
    }
}