package com.enterprise.maister.comunicacionfragment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.model.database.AnimalesDatabase;
import com.enterprise.maister.comunicacionfragment.model.entidades.Animal;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;
/*
*
*
* */
public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;

    private MyActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnimalesDatabase.getINSTANCIA(this).animalDAO().insertarAnimales(new Animal());
        viewModel= ViewModelProviders.of(this).get(MyActivityViewModel.class);
       //
        if(findViewById(R.id.afragment)==null) {
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {

                    Fragment fragment;

                    switch (position) {


                        case 0:
                            fragment = new AFragment();

                            break;

                        case 1:
                            fragment = new BFragment();
                            break;

                        default:
                            fragment = new AFragment();
                    }
                    return fragment;
                }

                @Override
                public int getCount() {
                    return 2;
                }
            });
       }

       // getFragmentManager().beginTransaction().attach(getFragmentManager().getFragments().get(0)).commit();
        //viewModel.getAnimal().observe(this,animal);
    }
}
