package com.jectpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jectpack.aidl.client.AidlActivity;
import com.jectpack.aidl.client.AidlPoolsActivity;
import com.jectpack.lifecycles.MyLifecycle;
import com.jectpack.messenger.MessengerActivty;
import com.jectpack.socket.SocketClientActivty;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.tvId.setText("视图绑定示例");

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