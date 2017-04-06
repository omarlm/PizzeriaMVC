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
    private HashMap<Integer, Object> cartItems;
    private String items;
    private Double precioTotal;

    public ShoppingCart() {
    }

    public ShoppingCart(String nombreCompleto, HashMap<Integer, Object> cartItems, String items, Double precioTotal) {
        this.nombreCompleto = nombreCompleto;
        this.cartItems = cartItems;
        this.items = items;
        this.precioTotal = precioTotal;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public HashMap<Integer, Object> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Integer, Object> cartItems) {
        this.cartItems = cartItems;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
