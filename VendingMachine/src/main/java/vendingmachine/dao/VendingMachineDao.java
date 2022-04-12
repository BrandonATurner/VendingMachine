/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * @author andri
 */
public interface VendingMachineDao {

    /**
     * Returns a List of all students in the roster.
     *
     * @return List containing all students in the roster.
     */
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;

    /**
     * Returns the item object associated with the given item name. Returns null
     * if no such item exists
     *
     * @param itenName name of the item to retrieve
     * @return the Item object associated with the given item name, null if no
     * such item exists
     */
    Item getItem(String itemName)
            throws VendingMachinePersistenceException;
    
    Item decrementItem(String itemName) 
            
            throws VendingMachinePersistenceException;

    
    public void updateBalance(BigDecimal balance);
    public BigDecimal getBalance();
}
