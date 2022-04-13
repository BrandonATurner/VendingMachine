/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package vendingmachine.service;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dto.Item;

/**
 *
 * @author Rich
 */
public class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;
    VendingMachineDao dao;

    public VendingMachineServiceLayerImplTest() {
        dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
        //Arrange
        Item testClone = new Item("Test Snack");
        testClone.setItemCost("1.25");
        testClone.setItemInventory("5");

        //Act & Assert
        assertEquals(3, service.getAllItems().size(), "Three items should exist.");
        assertTrue(service.getAllItems().contains(testClone), "The test snack should be in the list");

    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        //Arrange
        Item testClone = new Item("Test Snack");
        testClone.setItemCost("1.25");
        testClone.setItemInventory("5");

        //Act & Assert
        Item shouldBeTestClone = service.getItem("Test Snack");
        assertNotNull(shouldBeTestClone, "The item returned by getItem() should not be null");
        assertEquals(shouldBeTestClone, testClone, "The two items should be the same");

        Item shouldBeNull = service.getItem("A Snack That Shouldn't Exist");//The service layer should not return an object that doesn't exist
        assertNull(shouldBeNull);

    }

    /**
     * Test of buyItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testBuyItem() throws Exception {

        //Assert that items with prices higher than your balance (10) cannot be purchased
        try {
            service.buyItem("Expensive Snack");
            fail("Expected InsufficientFundsException");
        } catch (InsufficientFundsException e) {
        }

        //Assert that it is not possible to buy nonexistant items
        try {
            service.buyItem("Nonexistant Item");
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
        }

        //Assert that items that are out of stock cannot be purchased
        try {
            service.buyItem("NoInv Snack");
            fail("Expected NoItemInventoryException");
        } catch (NoItemInventoryException e) {
        }

        //Assert that once funds have been adjusted to 20 you can purchase the expensive snack
        BigDecimal sufficientBalance = new BigDecimal("20");
        dao.updateBalance(sufficientBalance);
        try {
            service.buyItem("Expensive Snack");
        } catch (InsufficientFundsException e) {
            fail("Did not expect InsufficientFundsException");
        }
        
        //Reset any changes to the state caused by purchasing items.
        dao.getAllItems().clear();
        dao.getAllItems();
    }
}
