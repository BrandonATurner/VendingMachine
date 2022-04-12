/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vendingmachine.dto.Item;

/**
 *
 * @author Rich
 */
public class VendingMachineServiceLayerImplTest {
    
    public VendingMachineServiceLayerImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
        System.out.println("getAllItems");
        VendingMachineServiceLayerImpl instance = null;
        List<Item> expResult = null;
        List<Item> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetItem() throws Exception {
        System.out.println("getItem");
        String itemName = "";
        VendingMachineServiceLayerImpl instance = null;
        Item expResult = null;
        Item result = instance.getItem(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buyItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testBuyItem() throws Exception {
        System.out.println("buyItem");
        String itemName = "";
        VendingMachineServiceLayerImpl instance = null;
        Item expResult = null;
        Item result = instance.buyItem(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBalance method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testUpdateBalance() {
        System.out.println("updateBalance");
        BigDecimal balance = null;
        VendingMachineServiceLayerImpl instance = null;
        instance.updateBalance(balance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        VendingMachineServiceLayerImpl instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
