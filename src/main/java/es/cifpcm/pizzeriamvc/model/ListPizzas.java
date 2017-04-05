/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.model;

/**
 *
 * @author omarl
 */
public class ListPizzas {
    private int idOfertas;
    private String nombre;
    private String descripcion;
    private Double precioTotal;
    private String urlImagen;

    public ListPizzas() {
    }

    public ListPizzas(int idOfertas, String nombre, String descripcion, Double precioTotal, String urlImagen) {
        this.idOfertas = idOfertas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
        this.urlImagen = urlImagen;
    }

    public int getIdOfertas() {
        return idOfertas;
    }

    public void setIdOfertas(int idOfertas) {
        this.idOfertas = idOfertas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
}
