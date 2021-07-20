package com.jetpack.paging;

import androidx.annotation.NonNull;
import androidx.paging.ListenableFuturePagingSource;
import androidx.paging.PagingState;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.jetpack.net.RetrofitClient;
import com.jetpack.paging.bean.UserResponse;
import com.jetpack.paging.serviceapi.ServiceApi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.HttpException;

public class Paging3ListenableFutureDataSource extends ListenableFuturePagingSource<Integer, UserResponse.Data.User> {

    @NonNull
//    private Executor mBgExecutor = Executors.newSingleThreadExecutor();
    private ListeningExecutorService mBgExecutor =  MoreExecutors.listeningDecorator(Executors.newCachedThreadPool()); //MoreExecutors.newDirectExecutorService();



    @NotNull
    @Override
    public ListenableFuture<LoadResult<Integer, UserResponse.Data.User>> loadFuture(@NotNull LoadParams<Integer> loadParams) {
        // Start refresh at page 1 if undefined.

        ListenableFuture<LoadResult<Integer, UserResponse.Data.User>> result = null;
        int page = loadParams.getKey() == null ? 0 : loadParams.getKey();


        Integer prevKey = null;
        Integer nextKey = 1;


        if (loadParams.getKey() != null){
            prevKey = loadParams.getKey() - 1;
            nextKey = loadParams.getKey() + 1;
        }/*else {
            prevKey = page - 1;
            nextKey = page + 1;
        }*/

        page = 0;
        try {
            ListenableFuture<LoadResult<Integer, UserResponse.Data.User>> pageFuture = createPageFuture(page, prevKey, nextKey);

            ListenableFuture<LoadResult<Integer, UserResponse.Data.User>> partialLoadResultFuture =
                    Futures.catching(pageFuture, HttpException.class, LoadResult.Error::new, mBgExecutor);

            result =  Futures.catching(partialLoadResultFuture,  IOException.class, LoadResult.Error::new, mBgExecutor);

        }catch (Exception  e){
            e.printStackTrace();
        } catch (Throwable ee){
            ee.printStackTrace();
        }

        return result;
    }




    @Nullable
    @Override
    public Integer getRefreshKey(@NotNull PagingState<Integer, UserResponse.Data.User> state) {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }

        LoadResult.Page<Integer, UserResponse.Data.User> anchorPage = state.closestPageToPosition(anchorPosition);
        if (anchorPage == null) {
            return null;
        }

        Integer prevKey = anchorPage.getPrevKey();
        if (prevKey != null) {
            return prevKey + 1;
        }

        Integer nextKey = anchorPage.getNextKey();
        if (nextKey != null) {
            return nextKey - 1;
        }

        return null;
    }

    private ListenableFuture<LoadResult<Integer, UserResponse.Data.User>> createPageFuture(Integer page, Integer prevKey, Integer nextKey){

        return Futures.transform(requestService(page),
                (response) -> new LoadResult.Page<Integer, UserResponse.Data.User>(response.getData().getDatas(), prevKey, nextKey) ,
                mBgExecutor);
    }

    private ListenableFuture<UserResponse>  requestService(int page){

        LoadResult<Integer, UserResponse.Data.User> result = null;
        List<UserResponse> list = new ArrayList<>(1);

        Call<UserResponse> call = RetrofitClient.getInstance().createApi(ServiceApi.class).getArticleList(page);

        return mBgExecutor.submit(() -> call.execute().body());
    }


}
