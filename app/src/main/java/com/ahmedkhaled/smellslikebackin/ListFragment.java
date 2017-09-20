package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Ahmed Khaled on 9/1/2017.
 */

public class ListFragment extends Fragment {

    OnItemClickListener onItemClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        onItemClickListener= (OnItemClickListener) getActivity();
        View view=inflater.inflate(R.layout.list_fragment,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler);
        ListAdapter listAdapter=new ListAdapter(onItemClickListener);
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));



        return view;
    }

    interface OnItemClickListener{
        void onItemClicked(int position);
    }

}
