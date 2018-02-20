package com.enterprise.maister.comunicacionfragment.view;


import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maister on 6/02/18.
 */

public class BFragment extends Fragment {

    MyActivityViewModel viewModel;

    final Observer<Integer> animal=new Observer<Integer>() {
        @Override
        public void onChanged(@Nullable Integer integer) {

            cambiarVista(integer);

        }
    };

    List<String> nombreanimales;
    final Observer<List<String>> _nombreanimales=new Observer<List<String>>() {
        @Override
        public void onChanged(@Nullable List<String> strings) {

            nombreanimales=strings;
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.b_fragment_layout,container,false);

    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel= ViewModelProviders.of((FragmentActivity) getActivity()).get(MyActivityViewModel.class);
        viewModel.getAnimal().observe((LifecycleOwner) this,animal);
        viewModel.getnombreAnimales().observe((LifecycleOwner) this,_nombreanimales);
    }

    private void cambiarVista(int i){

        if(nombreanimales!=null)
        ((TextView)this.getActivity().findViewById(R.id.raza)).setText(nombreanimales.get(i));
    }
}
