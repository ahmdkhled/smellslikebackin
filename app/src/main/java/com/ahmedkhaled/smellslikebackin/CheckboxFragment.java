package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Ahmed Khaled on 9/9/2017.
 */

public abstract class CheckboxFragment extends Fragment {

    private static final String STATE_KEY = "is checked";
    public static final String DUAL_KEY = "dual";
    String[] contents;
    CheckBox[] checkBoxes;
    boolean[] states;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index =DetailFragment.position;
        boolean isTablet=getResources().getBoolean(R.bool.isTablet);
        if (isTablet){index=DualPane.index;}
        contents=getContent(index);
        checkBoxes=new CheckBox[contents.length];
        View view=inflater.inflate(R.layout.checkbox_fragment,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.Container);
        if (savedInstanceState !=null &&savedInstanceState.getBooleanArray(STATE_KEY)!=null){
            states=savedInstanceState.getBooleanArray(STATE_KEY);
            Log.d("TAG","ok");
        }
        setup(contents,linearLayout,states);
        return view;
    }


    void setup(String[] contents, ViewGroup container, boolean[] states){
        for (int i=0;i<contents.length;i++) {
            checkBoxes[i] = new CheckBox(getActivity());
            checkBoxes[i].setPadding(7, 7, 7, 7);
            checkBoxes[i].setText(contents[i]);
            checkBoxes[i].setTextSize(20);

            if (states!=null){
                checkBoxes[i].setChecked(states[i]);
            }

            container.addView(checkBoxes[i]);
        }

    }

     abstract String[] getContent(int index);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] states=new boolean[checkBoxes.length];


        for (int i=0;i<checkBoxes.length;i++) {

            if (checkBoxes[i]!=null) {
                states[i] =checkBoxes[i].isChecked();

            }
        }
        outState.putBooleanArray(STATE_KEY,states);
        super.onSaveInstanceState(outState);
    }

}
