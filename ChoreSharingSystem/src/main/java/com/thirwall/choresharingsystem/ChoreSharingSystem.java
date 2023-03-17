/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.thirwall.choresharingsystem;

/**
 *
 * @author thura
 */
public class ChoreSharingSystem {

    public static void main(String[] args) {
        
        ChoresDatabase db = new ChoresDatabase();
        System.out.println(db.getCommonTasks().toString());
        System.out.println(db.getUsers().toString());
    }
}
