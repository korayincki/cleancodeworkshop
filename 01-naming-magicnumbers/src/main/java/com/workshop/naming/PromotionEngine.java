package com.workshop.naming;
package com.workshop.constants;

/**
 * Dirty: duplicated rules, same calculations scattered in different class
 */
public class DiscountCalculationEngine {
    // returns discount percent as a fraction
    public double calculateDiscount(int customerType, double amount) {
        if (customerType == 2) {
            return 0.07;
        }
        if (customerType == 3) {
            double d = 0.15;
            if (amount > 1000) {
                d += 0.05;
            }
            return d;
        }
        if (customerType == 4) {
            double d = 0.10;
            if (amount > 800) {
                d += 0.02;
            }
            return d;
        }
        if (amount > 500) {
            return 0.03;
        }
        return 0.0;
    }

    public double getCustomerDefaultDiscountPercentence(int customerType) {
        return CustomerType.getRateByType(customerType);
    }
    public double recalculateDiscountPercentageForAmount(CustomerClass customerClass, int customerType,double rate, double amount) {
        if (customerClass.getHasExtraDiscuntByAmount){

        }
    }
    public double getDiscountRateByAmountValue(double amount,int customerType){
        if (amount > 1000){
            return AmountRateEnum.getRateByType(1000)
        }
        if (amount > 500){
            return AmountRateEnum.getRateByType(500)

        }
        if (amount > 800){
            return AmountRateEnum.getRateByType(800)

        }
    }
    public double calculateTotalDiscount(double defaultRate,double extraDiscountRate){
        return defaultRate+extraDiscountRate;
    }
}
