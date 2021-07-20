package com.jetpack.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.bean.NewsItem;
import com.robert.jetpack.R;

import java.util.ArrayList;
import java.util.List;

public class My2RecyclerViewAdapter extends RecyclerView.Adapter<My2RecyclerViewAdapter.TestViewHodler> {
    public static final int ITEM_INLAND = 0;
    public static final int ITEM_FOREIGN = 1;

    private List<NewsItem> dataList = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public TestViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
       switch (viewType){
            case ITEM_INLAND:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item_inland, parent,false);
                break ;
            case ITEM_FOREIGN:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item_foreign, parent,false);
                break;
        }
        Log.e("huijun", "onCreateViewHolder TestViewHodler ");
        return new TestViewHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHodler holder, int position) {
        holder.update(dataList.get(position));
    }


    public void setDataList(List<NewsItem> data){
        if (data != null && !data.isEmpty()){
            dataList.addAll(data);
            notifyDataSetChanged();
        }
    }



    public class TestViewHodler extends RecyclerView.ViewHolder{

        private TextView falg;
        private TextView title;
        private TextView content;

        public TestViewHodler(View itemView){
            super(itemView);
            falg = itemView.findViewById(R.id.tv_flag);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
        }

        public void  update(NewsItem item){
            if (item != null){
                falg.setText(item.getType() == 0 ? "inland" : "foreign");
                title.setText(item.getTitle());
                content.setText(item.getContent());
            }

        }
    }

}
