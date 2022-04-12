/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author andri
 */
public class Item {
    
    private String itemName;
    private String itemCost;
    private String itemInventory;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    /*public void setFirstName(String firstName) {
        this.firstName = firstName;
    }*/

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }

    public String getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(String itemInventory) {
        this.itemInventory = itemInventory;
    }   
}