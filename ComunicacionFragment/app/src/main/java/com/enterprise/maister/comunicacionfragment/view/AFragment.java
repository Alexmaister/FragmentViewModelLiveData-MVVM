package com.enterprise.maister.comunicacionfragment.view;

import android.app.ListFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.enterprise.maister.comunicacionfragment.R;
import com.enterprise.maister.comunicacionfragment.model.Animal;
import com.enterprise.maister.comunicacionfragment.viewmodel.MyActivityViewModel;

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
                R.layout.animal_fila_layout, R.id.animal,viewmodel.getnombreAnimales().getValue()));

    }

    @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            viewmodel.getAnimal().setValue(position);
    }
}
