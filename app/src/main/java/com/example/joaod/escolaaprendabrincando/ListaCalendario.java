package com.example.joaod.escolaaprendabrincando;

import java.util.ArrayList;

/**
 * Created by joaod on 22/11/2016.
 */

public class ListaCalendario {
    private ArrayList<Calendario> listar;

    public ListaCalendario() {
    }

    public ListaCalendario(ArrayList<Calendario> listar) {
        this.listar = listar;
    }

    public ArrayList<Calendario> getListar() {
        return listar;
    }

    public void setListar(ArrayList<Calendario> listar) {
        this.listar = listar;
    }

    @Override
    public String toString() {
        return "ListaCalendario{" +
                "listar=" + listar +
                '}';
    }
}
