package com.ahmedkhaled.smellslikebackin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ahmed Khaled on 9/10/2017.
 */

public class GridAdapter extends RecyclerAdapter {

    private GridFragment.OnGridItemClickListener onGridItemClickListener;

    public GridAdapter(GridFragment.OnGridItemClickListener onGridItemClickListener) {
        this.onGridItemClickListener = onGridItemClickListener;
    }

    @Override
    int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    void onRecepieSelected(int index) {
         onGridItemClickListener.onGridItemClickListener(index);
    }


}


