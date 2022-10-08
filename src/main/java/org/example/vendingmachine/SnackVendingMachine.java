package org.example.vendingmachine;

import org.example.mechanics.SnackChamber;
import org.example.mechanics.Validator;
import org.example.product.Snack;

public class SnackVendingMachine implements VendingMachine {
    private static Validator validator;
    private SnackChamber snackChamber;

    public SnackVendingMachine() {
        snackChamber = SnackChamber.getChamberInstance();
        while (snackChamber.addProduct(new Snack())) {
            snackChamber.addProduct(new Snack());
        }
    }

    @Override
    public Validator getValidator() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;
    }
}
