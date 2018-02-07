package com.enterprise.maister.comunicacionfragment.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.enterprise.maister.comunicacionfragment.DAL.REPOSITORIO;

import java.util.ArrayList;

/**
 * Created by maister on 6/02/18.
 */

public class MyActivityViewModel extends ViewModel {

    public MyActivityViewModel() {
        animal=new MutableLiveData<>();
        animal.setValue(Integer.valueOf(1));
        nombreanimales=new MutableLiveData<>();
        nombreanimales.setValue(REPOSITORIO.nombreanimales);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    private MutableLiveData<ArrayList<String>> nombreanimales;



    private MutableLiveData<Integer> animal;


    public MutableLiveData<Integer> getAnimal() {

        if(animal==null){

            animal=new MutableLiveData<>();
            animal.setValue(Integer.valueOf(1));
        }
        return animal;
    }
    public MutableLiveData<ArrayList<String>> getnombreAnimales(){

      if(nombreanimales==null){

          nombreanimales=new MutableLiveData<>();
          nombreanimales.setValue(REPOSITORIO.nombreanimales);
      }

      return nombreanimales;
    }
}
