package com.enterprise.maister.comunicacionfragment.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.enterprise.maister.comunicacionfragment.DAL.REPOSITORIO;
import com.enterprise.maister.comunicacionfragment.model.daos.AnimalDAO;
import com.enterprise.maister.comunicacionfragment.model.database.AnimalesDatabase;
import com.enterprise.maister.comunicacionfragment.model.entidades.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maister on 6/02/18.
 */

public class MyActivityViewModel extends AndroidViewModel {

/*    public MyActivityViewModel() {
        animal=new MutableLiveData<>();
        ((MutableLiveData)animal).setValue(Integer.valueOf(1));
        nombreanimales=new MutableLiveData<>();
        ((MutableLiveData)nombreanimales).setValue(REPOSITORIO.nombreanimales);
    }*/

 public MyActivityViewModel(Application app){
     super(app);


 }

    private LiveData<List<String>> nombreanimales;



    private LiveData<Integer> animal;


    public LiveData<Integer> getAnimal() {

        if(animal==null){

            animal=new MutableLiveData<>();
            ((MutableLiveData)animal).setValue(Integer.valueOf(0));
        }
        return animal;
    }
    public LiveData<List<String>> getnombreAnimales(){

      if(nombreanimales==null){


         nombreanimales=AnimalesDatabase.getINSTANCIA(this.getApplication().getApplicationContext()).animalDAO().cargarNombreAnimales();
      }


      return nombreanimales;
    }
}
