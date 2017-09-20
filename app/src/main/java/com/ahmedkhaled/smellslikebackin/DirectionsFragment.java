package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by Ahmed Khaled on 9/6/2017.
 */

public  class DirectionsFragment extends CheckboxFragment {


    @Override
    public String[] getContent(int index) {
        return Recepies.directions[index].split("`");
    }
}
