package com.enterprise.maister.comunicacionfragment.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.enterprise.maister.comunicacionfragment.DAL.REPOSITORIO;
import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maister on 6/02/18.
 */

public class AFragment extends ListFragment {

    MyActivityViewModel viewmodel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewmodel = ViewModelProviders.of((FragmentActivity) this.getActivity()).get(MyActivityViewModel.class);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.animal_fila_layout, R.id.animal,
                viewmodel.getnombreAnimales(this.getContext()).getValue()
                )

        );

    }

    @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
        ((MutableLiveData<Integer>)viewmodel.getAnimal()).setValue(position);
    }
}
