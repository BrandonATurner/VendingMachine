/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author andri
 */
public class Change
    {
    private BigDecimal amount;
    private BigDecimal pennies, nickels, dimes, quarters;
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
    
    public void setChange()
        {
            quarters = amount.divide(Denomination.QUARTER.value);
            BigDecimal lessQuarters = amount.subtract(quarters.multiply(Denomination.QUARTER.value));
            dimes = lessQuarters.divide(Denomination.QUARTER.value);
            BigDecimal lessDimes = lessQuarters.subtract(dimes.multiply(Denomination.DIME.value));
            nickels = lessDimes.divide(Denomination.QUARTER.value);
            BigDecimal lessNickels = lessDimes.subtract(dimes.multiply(Denomination.DIME.value));
            pennies = lessNickels.divide(Denomination.PENNY.value);
        }
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