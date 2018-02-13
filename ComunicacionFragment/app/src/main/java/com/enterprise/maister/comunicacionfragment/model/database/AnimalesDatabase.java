package com.enterprise.maister.comunicacionfragment.model.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.enterprise.maister.comunicacionfragment.model.daos.AnimalDAO;
import com.enterprise.maister.comunicacionfragment.model.entidades.Animal;

/**
 * Created by maister on 13/02/18.
 */
@Database(version=1,entities={Animal.class})
public abstract class AnimalesDatabase extends RoomDatabase {

    private static AnimalesDatabase INSTANCIA;
    abstract public AnimalDAO animalDAO();

    public static AnimalesDatabase getINSTANCIA(final Context context){


        if(INSTANCIA==null){
            synchronized (AnimalesDatabase.class){

                if (INSTANCIA==null){

                    INSTANCIA=Room.databaseBuilder(context.getApplicationContext(),AnimalesDatabase.class,"animales_database").allowMainThreadQueries().build();
                }

            }

        }

        return INSTANCIA;
    }

}
