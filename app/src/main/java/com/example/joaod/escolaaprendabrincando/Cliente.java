package com.example.joaod.escolaaprendabrincando;

/**
 * Created by joaod on 20/11/2016.
 */
public class Cliente {
    private boolean status;
    private String tipo;
    private int idCliente;

    public Cliente() {
    }

    public Cliente(boolean status, String tipo, int idCliente) {
        this.status = status;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public boolean isStatus() {
        return status;
}

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
