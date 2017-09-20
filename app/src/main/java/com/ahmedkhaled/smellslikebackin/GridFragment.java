package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ahmed Khaled on 9/10/2017.
 */

public class GridFragment extends Fragment {

    OnGridItemClickListener onGridItemClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       onGridItemClickListener= (OnGridItemClickListener) getActivity();
        View view=inflater.inflate(R.layout.list_fragment,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler);
        GridAdapter gridAdapter=new GridAdapter(onGridItemClickListener);
        recyclerView.setAdapter(gridAdapter);



        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),getColumnNumber()));


        return view;
    }
    interface OnGridItemClickListener {
        void onGridItemClickListener(int index);
    }

    int getColumnNumber(){
        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float dpWidth=displayMetrics.widthPixels/displayMetrics.density;
        return (int) (dpWidth/200);
    }

}
