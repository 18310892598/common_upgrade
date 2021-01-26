# commom_update

## 内容列表

- [背景](#背景)
- [功能](#功能)
- [接入](#接入)
- [使用说明](#使用说明)

## 背景

`common_update` 是通用第三方下载组件，主要是服务长城中台自己搭建的应用发布平台，app发布后只要集成
SDK后就会控制app自动升级及升级中自定义展示样式。

## 功能
提供用于apk升级功能的支持，功能包括：

> 1、SDK支持检测当前版本是否是最新版本，如果不是会给出弹出框提示

> 2.自持自定义弹出框样式，目前内置了三种自定义样式，同时支持用户自定义升级弹出框提示样式

> 2.自持app下载和安装功能



详细内容 参见DEMO
 
## 接入

1.根目录build.gradle添加

```java
allprojects {
    repositories {
            maven {
            url 'http://nexus.gwm.cn/repository/maven-zhongtai-releases/'
            credentials {
                username "username"
                password "password"
            }
        }
    }
}

```

2.引入


```java
dependencies {
    api 'com.common.updateapp:update:1.0.0'
}
```
3.manifest添加

```java

        <provider
                    android:name="androidx.core.content.FileProvider"
                    android:authorities="com.example.common_upgrade.fileProvider"
                    android:exported="false"
                    android:grantUriPermissions="true">
                    <meta-data
                        android:name="android.support.FILE_PROVIDER_PATHS"
                        android:resource="@xml/filepaths" />
                </provider>
    
```


## 使用说明

1.检测版本及升级

```java

   DownLoadManager mdownload=new DownLoadManager();
   mdownload.checkAppUpdate(MainActivity.this,"1.0.0",force,type,bgResoureID);

 /**
     * 检测当前版本是否是最新版本
     * @param mContext 当前上下文
     * @param versionName 版本号名称
     * @param type 平台提供三种样式1,2,3则为样式,4 (4:表示自定义样式)
     * @bgResourceid type 样式类型，如果类型是4，自定义则必须传该字段，否则默认为0 就行
     */
    public  void checkAppUpdate(Activity mContext, String versionName,boolean force,int type,int bgResourceid)

```


