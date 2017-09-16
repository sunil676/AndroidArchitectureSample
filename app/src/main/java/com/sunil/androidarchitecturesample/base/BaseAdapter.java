package com.sunil.androidarchitecturesample.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by sunil on 16-09-2017.
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

    public abstract void setData(List<Data> data);
}