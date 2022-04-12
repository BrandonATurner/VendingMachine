/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Item;

/**
 *
 * @author andri
 */
public interface VendingMachineServiceLayer {

    List<Item> getAllItems() throws
            VendingMachinePersistenceException;
    
    String buyItem(String itemName) throws
            VendingMachinePersistenceException,
            NoItemInventoryException,
            InsufficientFundsException;

    Item getItem(String itemName) throws
            VendingMachinePersistenceException;
    //void buyItem(String itemName);
    public String updateBalance(BigDecimal balance);
    public BigDecimal getBalance();
}
