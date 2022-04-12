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
    public void buyItem(String itemName) {
        dao.buyItem(itemName);
    }
    @Override
    public void updateBalance(BigDecimal balance) {
        dao.updateBalance(balance);
    }
    @Override
    public BigDecimal getBalance(){
        return dao.getBalance();
    }
}
