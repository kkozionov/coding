package com.kozionov.taxes;

public class EffectiveTaxes {

    public EffectiveTaxes() {
    }

    double calc(double income) {
        double amount = 0;
        double taxable = income;
        if (income > 19.750) {
            amount += 19.750 * 0.1;
            taxable-=19.750;
        }

        return amount;
    }
}
