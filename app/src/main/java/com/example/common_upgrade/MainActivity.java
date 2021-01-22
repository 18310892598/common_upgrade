package com.example.common_upgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.updateapp.BgUpdate;
import android.os.Environment;

/**
 * 运行的应用
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 测试模拟数据
     */
    String url = "https://3g.163.com/links/4636";
    private String filePath = Environment.getExternalStorageDirectory() + "/yyy23.apk";
    private String filename=  "yyy23.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.download);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dodown(2);
            }
        });


    }

    /**
     * @updateType 1:显示dialog 2：通知栏显示
     */
    private void  dodown(int updateType){
        BgUpdate.updateForNotification(MainActivity.this, url, filename,updateType);
    }
}