/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * This class holds the idea of the vending machine itself
 * It currently holds the state of the user's funds, but 
 * it would be a good starting point if more functionality 
 * was to be added to the program.
 */
public class VendingMachine {
    // Amount of funds deposited in the machine currently
    private BigDecimal balance;

    // Getter
    public BigDecimal getBalance() {
        return balance;
    }
    
    // Setter
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
}
