package com.sunil.androidarchitecturesample.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.sunil.androidarchitecturesample.api.Resource;
import com.sunil.androidarchitecturesample.base.BaseAdapter;

import java.util.List;

/**
 * Created by sunil on 16-09-2017.
 */

public final class ListBindingAdapter{
    @BindingAdapter(value = "resource")
    public static void setResource(RecyclerView recyclerView, Resource resource){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter == null)
            return;

        if(resource == null || resource.data == null)
            return;

        if(adapter instanceof BaseAdapter){
            ((BaseAdapter)adapter).setData((List) resource.data);
        }
    }
}