# commen_update

## 内容列表

- [背景](#背景)
- [功能](#功能)
- [接入](#接入)
- [使用说明](#使用说明)

## 背景

`commen_update` 是通用第三方下载组件

## 功能
提供用于apk升级功能的支持，功能包括：  

> 1.apk下载功能

> 2.通知栏提示功能



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
            android:authorities="com.ole.travel.update.fileProvider" (此处包名修改为应用包名)
            android:exported="false"
            android:grantUriPermissions="true"
            tools:replace="android:authorities">
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/common_provider_paths"
                tools:replace="android:resource"/>
        </provider>
    
```


## 使用说明

1.apk下载功能

```java
        BgUpdate.updateForNotification(MainActivity.this, url, filename);

```

2.关闭服务

```java
        BgUpdate.closeService(this);

```
