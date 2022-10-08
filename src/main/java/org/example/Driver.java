package org.example;

import org.example.vendingmachine.SnackVendingMachine;
import org.example.vendingmachine.VendingMachine;

public class Driver {
    public static void main(String[] args) {
        VendingMachine snackVendingMachine = new SnackVendingMachine();
        System.out.println("Welcome ^_^");
        while (true) {
            snackVendingMachine.getValidator().mainProcedure();
        }
    }


}
