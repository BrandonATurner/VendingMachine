/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author Rich
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public Item testItem;
    public Change testChange = new Change();
    public VendingMachine testVm = new VendingMachine();

    public VendingMachineDaoStubImpl() {
        testItem = new Item("Test Snack");
        testItem.setItemCost("1.25");
        testItem.setItemInventory("5");

        testVm.setBalance(BigDecimal.TEN);
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        List<Item> itemList = new ArrayList<>();
        itemList.add(testItem);
        return itemList;
    }

    @Override
    public Item getItem(String itemName) throws VendingMachinePersistenceException {
        if (itemName.equals(testItem.getItemName())) {
            return testItem;
        } else {
            return null;
        }
    }

    @Override
    public void decrementItem(String itemName) throws VendingMachinePersistenceException {
        int decrementUpdate = Integer.parseInt(testItem.getItemInventory());
        decrementUpdate--;
        testItem.setItemInventory(Integer.toString(decrementUpdate));
    }

    @Override
    public String updateBalance(BigDecimal balance) {

        testVm.setBalance(balance);
        testChange.setAmount(balance);
        testChange.setChange();
        return testChange.getChange();
    }

    @Override
    public BigDecimal getBalance() {
        return testVm.getBalance();
    }

}
