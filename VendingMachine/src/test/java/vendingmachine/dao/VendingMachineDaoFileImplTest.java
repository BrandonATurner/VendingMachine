/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author westo
 */
public class VendingMachineDaoFileImplTest {
    
    public VendingMachineDaoFileImplTest() {
    }

    @Test
    public void testChangeSetterGetter() {
        Change change = new Change();
        change.setAmount(BigDecimal.ONE);
        boolean isSet = (change.getAmount() == BigDecimal.ONE);
        //System.out.println("isSet = " + isSet);
        assertTrue(isSet);
        
    }
    @Test
    public void testGetItem() {
        VendingMachineDaoFileImpl dao = new VendingMachineDaoFileImpl();
        String itemName = "Sprite";
        try {
            Item sprite = dao.getItem(itemName);
            boolean result = sprite.getItemCost().equals("1.51");
            assertTrue(result);
        } catch (VendingMachinePersistenceException ex) {
            Logger.getLogger(VendingMachineDaoFileImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
