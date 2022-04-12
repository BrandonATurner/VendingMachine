/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Item;

/**
 *
 * @author andri
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private final VendingMachineDao dao;
    private final VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Item> getAllItems() throws
            VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemName) throws
            VendingMachinePersistenceException {
        return dao.getItem(itemName);
    }

    @Override
    public String buyItem(String itemName) throws
            VendingMachinePersistenceException,
            NoItemInventoryException,
            InsufficientFundsException{
        //Get item reference from dao
        Item itemToBuy = dao.getItem(itemName);
        
        //Check that item is in stock and the user has sufficent funds to purchase
        //item. Throw exception otherwise.
        if (Integer.parseInt(itemToBuy.getItemInventory()) <= 0) {
            throw new NoItemInventoryException("This item is not in stock");
        }
        else if (dao.getBalance().compareTo(itemToBuy.bigdecimalItemCost()) < 0){
            throw new InsufficientFundsException("Insufficient Funds");
        }

        //Debit the item cost from the users balance.
        BigDecimal newBalance =  dao.getBalance().subtract(itemToBuy.bigdecimalItemCost());
        String change = dao.updateBalance(newBalance);
        
        dao.decrementItem(itemName);
        return change;
    }

    @Override
    public String updateBalance(BigDecimal balance) {
        return dao.updateBalance(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return dao.getBalance();
    }

    
}
