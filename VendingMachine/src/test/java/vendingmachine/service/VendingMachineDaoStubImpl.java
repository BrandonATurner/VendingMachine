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
    public Item testItemEmpty;
    public Item testItemExpensive;
    public Change testChange = new Change();
    public VendingMachine testVm = new VendingMachine();

    //Setup test items.
    public VendingMachineDaoStubImpl() {
        testItem = new Item("Test Snack");
        testItem.setItemCost("1.25");
        testItem.setItemInventory("5");
        
        testItemEmpty = new Item("NoInv Snack");
        testItemEmpty.setItemCost("1.25");
        testItemEmpty.setItemInventory("0");

        testItemExpensive = new Item("Expensive Snack");
        testItemExpensive.setItemCost("20");
        testItemExpensive.setItemInventory("1");

        //Setup vending machine with ten credits
        testVm.setBalance(BigDecimal.TEN);
    }
    
    public VendingMachineDaoStubImpl(Item testItem) {
        this.testItem = testItem;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        List<Item> itemList = new ArrayList<>();
        itemList.add(testItem);
        itemList.add(testItemEmpty);
        itemList.add(testItemExpensive);
        return itemList;
    }

    @Override
    public Item getItem(String itemName) throws VendingMachinePersistenceException {
        if (itemName.equals(testItem.getItemName())) {
            return testItem;
        } 
        else if(itemName.equals(testItemEmpty.getItemName())){
            return testItemEmpty;
        }
        else if(itemName.equals(testItemExpensive.getItemName())){
            return testItemExpensive;
        }
        
        return null;
        
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
