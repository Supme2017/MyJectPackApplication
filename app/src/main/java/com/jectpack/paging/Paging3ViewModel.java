package com.jectpack.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import com.jectpack.paging.bean.UserResponse;

import kotlinx.coroutines.CoroutineScope;

import static androidx.lifecycle.ViewModelKt.getViewModelScope;

public class Paging3ViewModel extends ViewModel {
    PagingConfig pagingConfig = new PagingConfig(10, 3, false);


    public LiveData<PagingData<UserResponse.Data.User>> getUserData() {

        CoroutineScope viewModelScope = getViewModelScope(this);
        Pager<Integer, UserResponse.Data.User> pager = new Pager<>(pagingConfig, () -> new Paging3ListenableFutureDataSource());

        LiveData<PagingData<UserResponse.Data.User>> cachedResult= PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);

        //如果需要对数据进行转换
//        LiveData<PagingData<UserResponse.Data.User>> cachedResult = PagingLiveData.cachedIn(
//                Transformations.map(PagingLiveData.getLiveData(pager),  (pagingData) -> { pagingData}) , viewModelScope);
        return cachedResult;
    }

}
