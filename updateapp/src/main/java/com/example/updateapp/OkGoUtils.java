package com.example.updateapp;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

public class OkGoUtils {
    //获取服务器版本号
    public static void getCode(Object tag, StringCallback callback) {
        OkGo.<String>get("http://2b6993734b57b648.test.paas.gwm.cn/api/v1/public/user/wms/bucket/wmsapp/file/wms_update_test.json?key=1f8a8e69e52d0517")
                .tag(tag)
                .execute(callback);
    }
}
