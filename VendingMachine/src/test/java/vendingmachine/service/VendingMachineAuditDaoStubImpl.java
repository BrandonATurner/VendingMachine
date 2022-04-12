/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.service;

import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachinePersistenceException;

/**
 *
 * @author Rich
 */
public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao{
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException{
    //Does not invoke any behavior. Only used for testing purposes. 
    }
    
}
