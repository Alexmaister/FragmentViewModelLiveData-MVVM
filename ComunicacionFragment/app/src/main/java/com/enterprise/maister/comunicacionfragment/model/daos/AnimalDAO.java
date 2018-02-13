package com.enterprise.maister.comunicacionfragment.model.daos;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.enterprise.maister.comunicacionfragment.model.entidades.Animal;

import java.util.List;

/**
 * Created by maister on 13/02/18.
 */
@Dao
public interface AnimalDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public List<Long> insertarAnimales(Animal... la);

    @Update
    public void actualizarAnimales(Animal... la);

    @Delete
    public void borrarAnimales(Animal... la);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal")
    public LiveData<List<Animal>> cargarAnimales();

    @Query("SELECT nombre FROM Animal")
    public LiveData<List<String>> cargarNombreAnimales();

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE especie=:especie")
    public LiveData<List<Animal>> cargarxEspecies(String especie);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE raza=:raza")
    public LiveData<List<Animal>> cargarxRaza(String raza);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE tipo=:tipo")
    public LiveData<List<Animal>> cargarxTipo(String tipo);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE id=:id")
    public LiveData<Animal> cargarAnimal(int id);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE raza in (:razas)")
    public LiveData<List<Animal>> cargarxRazas(String... razas);

    @Query("SELECT id,tipo,especie,raza,nombre FROM Animal WHERE especie in (:especies)")
    public LiveData<List<Animal>> cargarxespecies(String... especies);
}
