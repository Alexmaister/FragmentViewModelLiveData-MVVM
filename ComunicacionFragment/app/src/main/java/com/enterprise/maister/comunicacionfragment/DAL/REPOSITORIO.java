package com.enterprise.maister.comunicacionfragment.DAL;

import com.enterprise.maister.comunicacionfragment.model.entidades.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maister on 6/02/18.
 */

public class REPOSITORIO {

    public final static ArrayList<Animal> animales;

    static {
        animales = new ArrayList<Animal>();
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
        animales.add(new Animal());
    }

    public final static ArrayList<String> nombreanimales;

    static {

        nombreanimales=new ArrayList<String>();
        for (Animal a:animales) {

            nombreanimales.add(a.getRaza());
        }
    }

    public static List<String> cogerNombreAnimales(List<Animal> la){

        List nombreanimales=new ArrayList<String>();
        for (Animal a:la) {

            nombreanimales.add(a.getNombre());
        }
        return nombreanimales;
    }
}
