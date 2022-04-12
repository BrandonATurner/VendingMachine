/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dto.Item;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author andri
 */
public class VendingMachineController {

    private VendingMachineView view;
    private VendingMachineDao dao;

    public VendingMachineController(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
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

                exitMessage();
            } catch (VendingMachineDaoException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }

    /* private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }*/
    private void listItems() throws VendingMachineDaoException {
        view.displayDisplayAllBanner();
        List<Item> itemList = dao.getAllItems();
        view.displayItemList(itemList);
    }

    private void viewItem() throws VendingMachineDaoException {
        view.displayItemBanner();
        String itemName = view.getItemNameChoice();
        Item item = dao.getItem(itemName);
        view.displayItem(item);
    }
    private void buyItem() {
        view.displayBuyItemBanner();
        String itemName = view.getItemNameChoice();
        //service.buyItem(itemName);
        view.displayBuyItemSuccessBanner();
        
    }

    private void displayBalance() {
        view.displayBalanceBanner();
        //BigDecimal balance = service.getBalance();
        //view.displayBalance(balance);
    }

    private void addMoney() {
        view.displayAddMoneyBanner();
        BigDecimal addedFunds = view.getAddedMoney();
        //service.updateBalance();
        view.displayAddMoneySuccessBanner();

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
