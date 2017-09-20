package com.ahmedkhaled.smellslikebackin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ahmed Khaled on 9/1/2017.
 */

class ListAdapter extends RecyclerAdapter {

    ListFragment.OnItemClickListener onItemClickListener;

    public ListAdapter(ListFragment.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    void onRecepieSelected(int index) {
        onItemClickListener.onItemClicked(index);
    }

}
