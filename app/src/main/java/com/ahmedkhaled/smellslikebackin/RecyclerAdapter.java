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

public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {



    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View row =inflater.inflate(getLayoutId(),parent,false);
            return new RecyclerHolder(row);
            }



    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
            holder.img.setImageResource(Recepies.resourceIds[position]);
            holder.txt.setText(Recepies.names[position]);
            holder.getPosition(position);
            }

    @Override
    public int getItemCount() {
        return Recepies.names.length;
        }


    abstract int getLayoutId();
    abstract void onRecepieSelected(int index);

class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView txt;
    int position;

    RecyclerHolder(View itemView) {
        super(itemView);
        img= (ImageView) itemView.findViewById(R.id.img);
        txt= (TextView) itemView.findViewById(R.id.txt);
        itemView.setOnClickListener(this);
    }

    void getPosition(int position){
        this.position=position;
    }

    @Override
    public void onClick(View view) {
        onRecepieSelected(position);
    }
}
}
