package com.ahmedkhaled.smellslikebackin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ahmed Khaled on 9/6/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs=new String[]{"ingredients","Directions"};
    private Fragment[] fragments=new Fragment[]{new IngredientsFragment(),new DirectionsFragment()};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragments[position];
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

}
