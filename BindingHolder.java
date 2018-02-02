package com.scanor.chatcore.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BindingHolder extends RecyclerView.ViewHolder {
    public static BindingHolder newInstance(int layout, ViewGroup parent) {
        View itemView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layout, parent, false).getRoot();
        return new BindingHolder(itemView);
    }

    private BindingHolder(View itemView) {
        super(itemView);
    }

    public <T extends ViewDataBinding> T getBinding() {
        return DataBindingUtil.getBinding(itemView);
    }
}