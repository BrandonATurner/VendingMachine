/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

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

    public BigDecimal bigdecimalItemCost() {
        return new BigDecimal(itemCost);
    }

    //Override the hash codes of the Item properties so they can be compared
    //to other Item objects
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.itemName);
        hash = 89 * hash + Objects.hashCode(this.itemCost);
        hash = 89 * hash + Objects.hashCode(this.itemInventory);
        return hash;
    }

    
    //Override the equals method to compare the state of this object with another 
    //of type Item
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        if (!Objects.equals(this.itemInventory, other.itemInventory)) {
            return false;
        }
        return true;
    }
}
