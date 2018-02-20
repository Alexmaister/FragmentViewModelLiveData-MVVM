package com.enterprise.maister.comunicacionfragment.model.entidades;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by maister on 6/02/18.
 */
@Entity(indices={@Index("id"),@Index("tipo"),@Index("raza"),@Index("especie")})//,//@Index(value={"especie","raza"})})
public class Animal {
@PrimaryKey
    private int id;
    private String tipo;
    private String especie;
    private String raza;
    private String nombre;
    @Ignore
    protected static int contador_id=0;

    public Animal(){

        id=contador_id++;
        tipo="mamifero";
        especie="perro";
        nombre="miperro";
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
