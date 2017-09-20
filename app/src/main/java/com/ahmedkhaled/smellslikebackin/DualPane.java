package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Ahmed Khaled on 9/10/2017.
 */

public class DualPane extends Fragment {
    public static final String DUAL_FRAGMENT="dualfragment";
    private static final String INGREDIENT_FRAGMENT = "ingerdient_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";
    public static int index;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        index=getArguments().getInt(DUAL_FRAGMENT);
        View view=inflater.inflate(R.layout.dualpane_fragment,container,false);
        getActivity().setTitle(Recepies.names[index]);
        handleLeftSide(index);
        handleRightSide(index);
        return view;



    }

    void handleRightSide(int index){
        DirectionsFragment mDirectionsFragment= (DirectionsFragment) getChildFragmentManager()
                .findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (mDirectionsFragment==null) {
            DirectionsFragment directionsFragment = new DirectionsFragment();
            getChildFragmentManager().beginTransaction()
                    .add(R.id.rightPlaceholder, directionsFragment, DIRECTIONS_FRAGMENT).commit();
        }

    }
    void handleLeftSide(int index) {
        IngredientsFragment mIngredientsFragment = (IngredientsFragment) getChildFragmentManager()
                .findFragmentByTag(INGREDIENT_FRAGMENT);
        if (mIngredientsFragment == null) {
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            getChildFragmentManager().beginTransaction()
                    .add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENT_FRAGMENT).commit();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
    }
}
