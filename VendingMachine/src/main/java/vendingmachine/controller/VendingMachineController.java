/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Item;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoItemInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * The controller orchestrates the functions of the Service Layer and View
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = view.printMenuAndGetSelection();
            try {
                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        viewItem();
                        break;
                    case 3:
                        addMoney();
                        break;
                    case 4:
                        displayBalance();
                        break;
                    case 5:
                        buyItem();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            } catch (VendingMachinePersistenceException // Exceptions based on missing inventory, funds, or files
                    | NoItemInventoryException
                    | InsufficientFundsException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
        exitMessage();
    }

    // Uses a lambda function to list all of the items in the machine's inventory
    private void listItems() throws VendingMachinePersistenceException {
        view.displayDisplayAllBanner();
        List<Item> itemList = service.getAllItems().stream()
                .filter((item) -> (Integer.parseInt(item.getItemInventory())) > 0)
                .collect(Collectors.toList());
        view.displayItemList(itemList);
    }
    // Prompts the user for the name of an item and then displays its details
    private void viewItem() throws VendingMachinePersistenceException {
        view.displayItemBanner();
        String itemName = view.getItemNameChoice();
        Item item = service.getItem(itemName);
        view.displayItem(item);
    }
    // Prompts for the name of the item to buy, checks funds, subtracts cost & updates inventory
    private void buyItem() throws VendingMachinePersistenceException,
            NoItemInventoryException,
            InsufficientFundsException {
        view.displayBuyItemBanner();
        String itemName = view.getItemNameChoice();
        String change = service.buyItem(itemName);
        view.displayChange(change);
        view.displayBuyItemSuccessBanner();

    }
    // Displays the remaining funds
    private void displayBalance() {
        view.displayBalanceBanner();
        BigDecimal balance = service.getBalance();
        view.displayBalance(balance);
    }
    // Simulates the addition of funds
    private void addMoney() {
        view.displayAddMoneyBanner();
        BigDecimal addedFunds = view.getAddedMoney();
        service.updateBalance(addedFunds);
        view.displayAddMoneySuccessBanner();

    }
    // Let's the user know their command is not supported
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    // Displays Goodbye!!! when exiting the program
    private void exitMessage() {
        view.displayExitBanner();
    }
}
