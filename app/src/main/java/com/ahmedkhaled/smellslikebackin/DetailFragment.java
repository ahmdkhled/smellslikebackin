package com.ahmedkhaled.smellslikebackin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Ahmed Khaled on 9/1/2017.
 */

public class DetailFragment extends Fragment {

    public static final String KEY="DetailFragment";
    public static int position;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         position=getArguments().getInt(KEY);
        getActivity().setTitle(Recepies.names[position]);
        View view=inflater.inflate(R.layout.detail_fragment,container,false);
        ViewPager viewPager= (ViewPager) view.findViewById(R.id.view_pager);
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
