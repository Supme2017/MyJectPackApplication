package com.jetpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.jetpack.adapter.MyBindingRecyclerViewAdapter;
import com.jetpack.bean.NewsItem;
import com.robert.jetpack.R;
import com.robert.jetpack.databinding.ActivityRecycleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewDataBindingActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = DataBindingActivity.class.getSimpleName();
    private ActivityRecycleViewBinding binding;
    private  int news_item_count_start = 0;
    private static  int NEWS_ITEM_COUNT = 20;

//    private MultiRecyclerViewAdapter<NewsItem> adapter = new MultiRecyclerViewAdapter();
    private MyBindingRecyclerViewAdapter adapter = new MyBindingRecyclerViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        news_item_count_start = 0;

//        绑定方式一
//        binding = ActivityDatabindingBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        //        绑定方式二
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle_view);


        //MultiRecyclerViewAdapter时使用
//        adapter.addAdapter(new ForeignAdapter());
//        adapter.addAdapter(new InlandAdapter());

        adapter.setDataList(generateData(NEWS_ITEM_COUNT));
        binding.rvJetpackRecyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == binding.update.getId()){

            adapter.setDataList(generateData(NEWS_ITEM_COUNT));
        } else if (id == binding.change.getId()){
            changeItem(3);
        } else if (id == binding.add.getId()){
            add(7);
        } else if (id == binding.delete.getId()){
            deleted(6);
        } else if (id == binding.deleteAll.getId()){
            deletedAll();
        }

    }

    private List<NewsItem> generateData(int itemCount){
        List<NewsItem> list = new ArrayList<>();

        int count = news_item_count_start + itemCount;

        for (int i= news_item_count_start; i<count; i++){
            list.add(new NewsItem("title : " + i, "content : " + i, i));
        }


        news_item_count_start = count;
        return list;
    }


    private void changeItem(int position){
        NewsItem item = adapter.getDataList().get(position);
        item.setTitle("s-" + item.getTitle());
        item.setContent("s-" + item.getContent());


        adapter.getDataList().set(position, item);
    }

    private void add(int position){
        adapter.getDataList().add(position, new NewsItem("add:" + position, "add content :" + position, position));
    }

    private void deleted(int position){
        adapter.getDataList().remove(position);
    }

    private void deletedAll(){
        adapter.deletedDataList();
    }
}