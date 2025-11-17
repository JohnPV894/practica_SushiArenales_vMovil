package com.example.act2_movil;

import com.google.gson.annotations.SerializedName;

public class Producto {
    @SerializedName("_id")
    private String mongoId;

    private int id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private int precio;

    public Producto(int id, String nombre, String descripcion, String urlImagen, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
    }

    //Getters y setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public String getUrlImagen() {return urlImagen;}

    public void setUrlImagen(String urlImagen) {this.urlImagen = urlImagen;}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }
}
