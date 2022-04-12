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
 * @author andri
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. Buy Item");
        io.print("3. Add Money");
        io.print("4. Show Money");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

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
    public void displayBalance(BigDecimal balance){
        io.print("The current balance is: " + balance);
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===");
    }

    public void displayBalanceBanner() {
        io.print("=== Current Balance ===");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
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
