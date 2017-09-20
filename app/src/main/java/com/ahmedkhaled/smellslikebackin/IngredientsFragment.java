package com.ahmedkhaled.smellslikebackin;

/**
 * Created by Ahmed Khaled on 9/6/2017.
 */

public class IngredientsFragment extends CheckboxFragment {


    @Override
    public String[] getContent(int index) {

        return Recepies.ingredients[index].split("`");
    }
}
