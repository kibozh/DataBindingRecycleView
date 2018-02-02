package com.scanor.chatcore.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */

public abstract class BaseRecyclerBindingAdapter<T> extends RecyclerView.Adapter<BindingHolder> {
    private List<T> mDataList = new ArrayList<>();

    public BaseRecyclerBindingAdapter() {
    }

    @Override
    public int getItemCount() {
        return mDataList == null?0:mDataList.size();
    }

    public List<T> getDataList() {
        return mDataList;
    }
}
