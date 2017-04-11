/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.model;

import java.util.HashMap;

/**
 *
 * @author omarl
 */
public class ShoppingCart {

    private String nombreCompleto;
    private HashMap<Integer, OfertaOrder> cartItems;
    private int items;
    private Double precioTotal;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public ShoppingCart(String nombreCompleto, HashMap<Integer, OfertaOrder> cartItems, int items, Double precioTotal) {
        this.nombreCompleto = nombreCompleto;
        this.cartItems = new HashMap<>();
        this.items = items;
        this.precioTotal = precioTotal;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public HashMap<Integer, OfertaOrder> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Integer, OfertaOrder> cartItems) {
        this.cartItems = cartItems;
    }
    
    public void putOferta(int idPedido, OfertaOrder o){
        this.cartItems.put(idPedido, o);
    }

    public int getItems() {
        return items;
    }

    public void updateSize() {
        this.items = cartItems.size();
    }

    public void setItems(int items) {
        this.items = items;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
