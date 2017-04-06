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
public class OfertaOrder {
    private int idOferta;
    private int idUsuario;
    private int cantidad;

    public OfertaOrder() {
    }

    public OfertaOrder(int idOferta, int idUsuario, int cantidad) {
        this.idOferta = idOferta;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
