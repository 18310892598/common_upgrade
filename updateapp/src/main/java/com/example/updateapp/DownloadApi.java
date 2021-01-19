package com.example.updateapp;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DownloadApi {

    @GET
    Observable<ResponseBody> downloadFile(@Url String fileUrl);

}
