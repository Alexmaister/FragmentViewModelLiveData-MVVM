package com.enterprise.maister.comunicacionfragment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;

public class MainActivity extends AppCompatActivity {

    Observer<Integer> animal=new Observer<Integer>() {
        @Override
        public void onChanged(@Nullable Integer integer) {

            getFragmentManager().beginTransaction().attach(new BFragment()).commit();
        }
    };

    private MyActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= ViewModelProviders.of(this).get(MyActivityViewModel.class);
        getFragmentManager().beginTransaction().add(R.id.framelayout,new AFragment()).add(R.id.framelayout,new BFragment()).
        commit();
       // getFragmentManager().beginTransaction().attach(getFragmentManager().getFragments().get(0)).commit();
        viewModel.getAnimal().observe(this,animal);
    }
}
