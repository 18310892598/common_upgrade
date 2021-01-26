package com.example.updateapp;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

/**
 * @author : hyx
 * @date : 2021/1/26
 * 检测当前版本是否是最新版本
 */
public class DownLoadManager {

    private static String[] arrayContent = new String[]{"1.修复bug", "2.优化用户体验"};
    public static int   intTopRes=0;
    public static int progressid=0;


    /**
     * 检测当前版本是否是最新版本
     * @param mContext 当前上下文
     * @param versionName 版本号名称
     * @param type 样式类型
     */
    public  void checkAppUpdate(Activity mContext, String versionName,boolean force,int type,int bgResourceid) {

       //系统默认提供三套样式及支持自定义样式
        if(type==0||type==1){
            intTopRes=R.mipmap.appupdate_bg_app_top;
            progressid=R.drawable.appupdate_progress_bg;
        } else if(type==2){
            intTopRes=R.mipmap.appupdate_bg_app_top_two;
            progressid=R.drawable.appupdate_progress_bg_two;
        }else if(type==3){
            intTopRes=R.mipmap.appupdate_bg_app_top_three;
            progressid=R.drawable.appupdate_progress_bg_three;
        }else{
            if(bgResourceid==0){
                intTopRes=R.mipmap.appupdate_bg_app_top;
            }else {
                intTopRes = bgResourceid;
            }
            progressid=R.drawable.appupdate_progress_bg;
        }
        Log.e("TAG","本地版本号----"+versionName);
        OkGoUtils.getCode(null, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                try {
                    String json = response.body();
                    Log.d("---------------------->", json);
                    JSONObject jo = new JSONObject(json);
                    String version = jo.getString("version");
                    String downloadUrl = jo.getString("downloadUrl");
                    Log.e("TAG","服务器版本号----"+version);
                    if (!versionName.equals(version)) {
                        mContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AppUpdateManager.Builder builder = new AppUpdateManager.Builder(mContext);
                                builder.apkUrl(downloadUrl)
                                        .updateForce(force)
                                        .updateContent(arrayContent)
                                        .topResId(intTopRes)
                                        .progressDrawable(progressid)
                                        .build();
                            }
                        });


                    }else{
                        mContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(mContext,"已是最新版本!",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("TAG", e.toString());
                }
            }

            @Override
            public void onError(com.lzy.okgo.model.Response<String> response) {
                super.onError(response);
            }
        });
    }

}
