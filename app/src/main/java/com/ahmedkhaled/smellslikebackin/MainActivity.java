package com.ahmedkhaled.smellslikebackin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener
                                                                ,GridFragment.OnGridItemClickListener{

    public static final String LIST_FRAGMENT="list_fragment";
    public static final String GRID_FRAGMENT="grid_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet=getResources().getBoolean(R.bool.isTablet);
        if (isTablet){
            GridFragment mGridFragment= (GridFragment) getSupportFragmentManager()
                    .findFragmentByTag(GRID_FRAGMENT);
            if (mGridFragment==null) {
                GridFragment gridFragment = new GridFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.activity_main, gridFragment, GRID_FRAGMENT).commit();
            }
        }else {
            ListFragment mListFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
            if (mListFragment == null) {
                ListFragment listFragment = new ListFragment();
                getSupportFragmentManager().beginTransaction().
                        add(R.id.activity_main, listFragment, LIST_FRAGMENT)
                        .commit();
                                        }
                }

    }

    @Override
    public void onItemClicked(int position) {
        DetailFragment detailFragment=new DetailFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(DetailFragment.KEY,position);
        detailFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null).replace(R.id.activity_main,detailFragment)
                .commit();
    }

    @Override
    public void onGridItemClickListener(int index) {
        DualPane dualPane=new DualPane();
        Bundle bundle=new Bundle();
        bundle.putInt(DualPane.DUAL_FRAGMENT,index);
        dualPane.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().addToBackStack(null)
                .replace(R.id.activity_main,dualPane).commit();

    }
}
