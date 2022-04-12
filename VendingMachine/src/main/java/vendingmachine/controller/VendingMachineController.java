/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.controller;

import java.util.List;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoException;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dto.Item;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
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

    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        io.print("");
        
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List Items");
            io.print("2. Buy Item");
            io.print("3. Add Money");
            io.print("4. Show Money");
            io.print("5. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 5);
            try {
                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        viewItem();
                        break;
                    case 3:
                        io.print("ADD MONEY");
                        break;
                    case 4:
                        io.print("SHOW MONEY");
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

           
            exitMessage();
        } catch (VendingMachineDaoException e) {
            view.displayErrorMessage(e.getMessage());
            }
        }}
        /* private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }*/
        
    private void listItems() throws VendingMachineDaoException {
        view.displayDisplayAllBanner();
        List<Item> itemList = dao.getAllItems();
        view.displayItemList(itemList);
    }

    private void viewItem() throws VendingMachineDaoException {
        view.displayDisplayItemBanner();
        String itemName = view.getItemNameChoice();
        Item item = dao.getItem(itemName);
        view.displayItem(item);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
