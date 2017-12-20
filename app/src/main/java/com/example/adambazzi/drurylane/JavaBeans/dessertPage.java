package com.example.adambazzi.drurylane.JavaBeans;

import android.widget.Button;

/**
 * Created by web on 2017-12-06.
 */

public class dessertPage {

    private String name;
    private String definition;
    private Button cart;
    private Integer price;
    public dessertPage(){

    }
    public dessertPage(String name, String definition,Integer price, Button cart){
        this.name = name;
        this.definition = definition;
        this.price = price;
        this.cart = cart;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }
    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public String toString(){
        return this.name;
    }

    public Button getCart() {
        return cart;
    }

    public void setCart(Button cart) {
        this.cart = cart;
    }

    public Integer getPrice(){
        return price;
    }

    public void setPrice(Integer price){
        this.price = price;
    }

}
