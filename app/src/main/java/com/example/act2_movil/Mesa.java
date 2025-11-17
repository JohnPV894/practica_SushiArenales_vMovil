package com.example.act2_movil;

public class Mesa {
    private String ID;
    private int numeroMesa;
    private int capacidad;
    private boolean mesaLibre;

    public Mesa(String ID, int numeroMesa, int capacidad, boolean mesaLibre) {
        this.ID = ID;
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.mesaLibre = mesaLibre;
    }

    public String getID() {return ID;}

    public void setID(String ID) {this.ID = ID;}

    public int getNumeroMesa() {return numeroMesa;}

    public void setNumeroMesa(int numeroMesa) {this.numeroMesa = numeroMesa;}

    public int getCapacidad() {return capacidad;}

    public void setCapacidad(int capacidad) {this.capacidad = capacidad;}

    public boolean isMesaLibre() {return mesaLibre;}

    public void setMesaLibre(boolean mesaLibre) {this.mesaLibre = mesaLibre;}
}
