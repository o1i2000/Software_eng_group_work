/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thirwall.choresharingsystem;

/**
 *
 * @author thura
 */
public class User {
    /* Fields */
    private int id;
    
    private String name;
    
    private float remainingLoad;

    /* Getters & Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRemainingLoad() {
        return remainingLoad;
    }

    public void setRemainingLoad(float remainingLoad) {
        this.remainingLoad = remainingLoad;
    }
    
    /* Methods */
    @Override
    public String toString() {
        return this.name;
    }
}
