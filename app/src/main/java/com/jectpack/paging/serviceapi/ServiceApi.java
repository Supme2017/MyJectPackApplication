package com.jectpack.paging.serviceapi;

import com.jectpack.paging.bean.DataBean;
import com.jectpack.paging.bean.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceApi {
    //开源API:http://gank.io/api/search/query/listview/category/Android/count/10/page/1
//    @GET("api/search/query/listview/category/Android/count/10/page/{page}")
//    Call<List<DataBean.ResultsBean>> getArticleList(@Path("page") int page);

    @GET("/article/list/{page}/json")
    Call<UserResponse> getArticleList(@Path("page") int page);
}
