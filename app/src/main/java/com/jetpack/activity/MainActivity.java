package com.jetpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jetpack.aidl.client.AidlActivity;
import com.jetpack.aidl.client.AidlPoolsActivity;
import com.jetpack.bean.ParamsViewModel;
import com.jetpack.lifecycles.MyLifecycle;
import com.jetpack.messenger.MessengerActivty;
import com.jetpack.socket.SocketClientActivty;
import com.robert.jetpack.R;
import com.robert.jetpack.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = "自定义ViewModel传参";
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.tvId.setText("视图绑定示例");


        ViewModel viewModel =  new ViewModelProvider(this, new ParamsViewModel.Factory(name)).get(ParamsViewModel.class);

        getLifecycle().addObserver(new MyLifecycle());



    }


    @Override
    public void onClick(View v) {
        Class<? extends AppCompatActivity> clazz ;

        switch (v.getId()){
            case R.id.bt_hilt_activity:
                clazz = HiltActivity.class;
                break;
            case R.id.bt_databinding_activity:
                clazz = DataBindingActivity.class;
                break;
            case R.id.bt_kotlin_activity:
                clazz = KotlinActivity.class;
                break;

            case R.id.bt_kotlin_aidlactivity:
                clazz = AidlActivity.class;
                break;

            case R.id.bt_kotlin_aidl_pools_activity:
                clazz = AidlPoolsActivity.class;
                break;

            case R.id.bt_kotlin_socketactivity:
                clazz = SocketClientActivty.class;
                break;


            case R.id.bt_kotlin_smessengeractivity:
                clazz = MessengerActivty.class;
                break;

            case R.id.bt_recycle_activity:
                clazz = RecycleViewDataBindingActivity.class;
                break;

            case R.id.bt_recycle_section_activity:
                clazz = RecycleViewDataBindingSectionActivity.class;
                break;

            case R.id.bt_paging3_activity:
                clazz = Paging3Activity.class;
                break;
            default:
                clazz = null;
        }

        startActivity(clazz);
    }

    private void startActivity(Class<? extends AppCompatActivity> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}