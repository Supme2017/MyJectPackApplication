package com.jectpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.ConcatAdapter;

import android.os.Bundle;
import android.view.View;

import com.jectpack.bean.NewsItem;
import com.jectpack.paging.Paging3ViewModel;
import com.jectpack.paging.adapter.FooterAdapter;
import com.jectpack.paging.adapter.Paging3Adapter;
import com.jectpack.paging.bean.UserResponse;
import com.robert.jectpack.R;
import com.robert.jectpack.databinding.ActivityPaging3Binding;

import java.util.ArrayList;
import java.util.List;

public class Paging3Activity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPaging3Binding binding;
    Paging3Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_paging3);

        adapter =  new Paging3Adapter();
        ConcatAdapter concatAdapter = adapter.withLoadStateHeaderAndFooter(new FooterAdapter(), new FooterAdapter());

        binding.rvPaging3RecyclerView.setAdapter(concatAdapter);

        Paging3ViewModel viewModel=new ViewModelProvider(this).get(Paging3ViewModel.class);

        viewModel.getUserData().observe(this, pagingData -> adapter.submitData(getLifecycle(),pagingData));

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == binding.change.getId()){
            adapter.change(3);
        }

    }
}