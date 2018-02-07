package com.enterprise.maister.comunicacionfragment.model;

/**
 * Created by maister on 6/02/18.
 */

public class Animal {

    private String tipo;
    private String especie;
    private String raza;

    public Animal(){

        tipo="mamifero";
        especie="perro";
        raza="Golden Retriever";
    }

    public String getTipo() {
        return tipo;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

}
