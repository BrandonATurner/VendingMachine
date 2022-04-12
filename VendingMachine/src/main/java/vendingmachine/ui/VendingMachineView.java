/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * The view class handles displaying information
 * and prompting the user for additional information
 */
public class VendingMachineView {

    private UserIO io;
    // Constructor that accepts an input interface
    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    // Displays optinos to the user
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. View Item");
        io.print("3. Add Money");
        io.print("4. Show Money");
        io.print("5. Buy Item");
        io.print("6. Exit");
        
        // Restricts input to correct choices
        return io.readInt("Please select from the above choices.", 1, 6); 
    }

    // Formatted Display of Items in Inventory
    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            String itemInfo = String.format("Item Name: %s : Item Cost: $%s : Items left: 30%s",
                    currentItem.getItemName(),
                    currentItem.getItemCost(),
                    currentItem.getItemInventory());
            io.print(itemInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    
    /*Banners and Prompts*/
    
    public void displayChange(String change) {
        io.print(change);
    }

    public void displayBalance(BigDecimal balance) {
        io.print("The current balance is: " + balance);
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }

    public void displayBalanceBanner() {
        io.print("=== Current Balance ===");
    }

    public void displayAddMoneyBanner() {
        io.print("=== Add Funds ===");
    }

    public void displayAddMoneySuccessBanner() {
        io.print("=== Funds Added ===");
    }

    public BigDecimal getAddedMoney() {
        return io.readBigDecimal("How much money is being added?");
    }

    public void displayItemBanner() {
        io.print("=== Display Item ===");
    }

    public void displayBuyItemBanner() {
        io.print("=== Buy Item ===");
    }

    public void displayBuyItemSuccessBanner() {
        io.print("=== Item Purchased ===");
    }

    public String getItemNameChoice() {
        return io.readString("Please enter the Item Name.");
    }

    public void displayItem(Item item) {
        if (item != null) {
            io.print(item.getItemName());
            io.print(item.getItemCost());
            io.print(item.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
