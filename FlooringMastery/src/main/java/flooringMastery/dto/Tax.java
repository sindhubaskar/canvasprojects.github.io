/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author sindhu
 */
public class Tax {
    
    String stateName;
    BigDecimal taxRate;
    
    public Tax(String stateName){
        this.stateName=stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String state) {
        this.stateName = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
    
    
}
