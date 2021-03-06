/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 *
 * A class encapsulating the idea of the currency returned to the user after 
 * they have made a purchase. It takes an amount, divides it into the appropriate
 * coinage, and returns a summary.
 */
public class Change
    {
    private BigDecimal amount;
    private BigDecimal pennies, nickels, dimes, quarters;
    // Enumerated constants to represent the value of coins
    public enum Denomination {
    
        QUARTER(BigDecimal.valueOf(.25)),
        DIME(BigDecimal.valueOf(.10)),
        NICKEL(BigDecimal.valueOf(.05)),
        PENNY(BigDecimal.valueOf(.01));
        
        private final BigDecimal value;
        
        Denomination(BigDecimal value){
            this.value = value;
        }
    }
    
    // Updates the number of each denomination of currency based on the amount variable
    public void setChange()
        {
            quarters = amount.divide(Denomination.QUARTER.value, 0, RoundingMode.DOWN);
            BigDecimal lessQuarters = amount.subtract(quarters.divide(BigDecimal.valueOf(4), 0, RoundingMode.DOWN));
            
            dimes = lessQuarters.divide(Denomination.DIME.value, 0, RoundingMode.DOWN);
            BigDecimal lessDimes = lessQuarters.subtract(dimes.divide(BigDecimal.valueOf(10), 1, RoundingMode.DOWN));
            
            nickels = lessDimes.divide(Denomination.NICKEL.value, 0, RoundingMode.DOWN);
            BigDecimal lessNickels = lessDimes.subtract(nickels.divide(BigDecimal.valueOf(20), 2, RoundingMode.DOWN));
            
            pennies = lessNickels.divide(Denomination.PENNY.value, 0, RoundingMode.DOWN);
            
        }
    
    // Returns a string allowing the user to know the denominations of their change
    public String getChange()
        {
            String change = "Your change is " + quarters + " quarters, " + dimes + " dimes " + nickels + " nickels and " + pennies + " pennies.";
            return change;
        }
    
    // Setters
    public void setAmount(BigDecimal amount)
        {
        this.amount = amount;
        }

    

    // Getters
    public BigDecimal getAmount()
        {
        return amount;
        }
    
    }