package com.enterprise.maister.comunicacionfragment.view;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;

import java.util.ArrayList;

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
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.b_fragment_layout,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel= ViewModelProviders.of((FragmentActivity) getActivity()).get(MyActivityViewModel.class);
        viewModel.getAnimal().observe((LifecycleOwner) getActivity(),animal);
    }

    private void cambiarVista(int i){

        ((TextView)this.getActivity().findViewById(R.id.raza)).setText(viewModel.getnombreAnimales().getValue().get(i)+i);
    }
}
