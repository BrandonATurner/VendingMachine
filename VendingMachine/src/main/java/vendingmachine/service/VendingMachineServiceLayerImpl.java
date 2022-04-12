/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.service;

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
    public Item buyItem(String itemName) throws
            VendingMachinePersistenceException,
            NoItemInventoryException{
            if (Integer.parseInt(dao.getItem(itemName).getItemInventory()) <= 0){
            throw new NoItemInventoryException("This item is not in stock");
            }
            
            
        return dao.decrementItem(itemName);
    }
}
