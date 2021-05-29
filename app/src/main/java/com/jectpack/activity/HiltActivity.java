package com.jectpack.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jectpack.impl.LocalIRepositoryServer;
import com.jectpack.impl.RemoteRepositoryServerImpl;
import com.jectpack.utils.LoggerUtils;
import com.jectpack.hilt.annotation.LocalServer;
import com.jectpack.hilt.annotation.RemoteServer;
import com.jectpack.iinterface.AbstractRepositoryServer;
import com.jectpack.iinterface.IRepositoryServer;
import com.robert.jectpack.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import okhttp3.OkHttpClient;

@AndroidEntryPoint
public class HiltActivity extends AppCompatActivity {
    private static final String TAG = HiltActivity.class.getSimpleName();

    @LocalServer
    @Inject
    IRepositoryServer localServer; //接口， 有它一个多个实现时，需要在@Module中使用@Binds、自定义注解绑定如何生成该接口类的实例

    @RemoteServer
    @Inject
    IRepositoryServer remoteServer; //接口， 有它一个多个实现时，需要在@Module中使用@Binds、自定义注解绑定如何生成该接口类的实例

    @Inject
    AbstractRepositoryServer abstractServer; //抽象类， 有它一个实现时，需要在@Module中使用@Binds绑定如何生成该抽象类的实例

    @Inject
    HashMap<String, String> testMap; //当注解在第三方类时，需要在@Module中使用@Provides绑定如何生成该类的实例

    @Inject
    OkHttpClient okHttpClient; //当注解在第三方类时，需要在@Module中使用@Provides绑定如何生成该类的实例


    @Inject
    RemoteRepositoryServerImpl remoteRepositoryServer; //明确的实现类， 使用@Inject可以直接注入

    @Inject
    LocalIRepositoryServer localIRepositoryServer; //明确的实现类， 使用@Inject可以直接注入

//    @Inject
//    List<IRepositoryServer> servers; //不能list注入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilt);

//        for (IRepositoryServer server : servers){
//            server.request("www.baidu.com");
//        }

        abstractServer.request("abstractServer");
        localServer.request("localServer");
        remoteServer.request("remoteServer");

        remoteRepositoryServer.request("RemoteRepositoryServerImpl");
        localIRepositoryServer.request("RemoteRepositoryServerImpl");

        testMap.put("1111", "22222");

        for (Map.Entry entry : testMap.entrySet()){
            LoggerUtils.log(TAG, "hashmap  " + entry.getKey() + " = " + entry.getValue());
        }

        LoggerUtils.log(TAG, "okHttpClient = "+ okHttpClient.hashCode());
    }
}