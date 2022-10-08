package org.example.vendingmachine;

import org.example.mechanics.KeyPad;
import org.example.mechanics.Validator;

public class SnackVendingMachineCreator extends VendingMachineFactory {

    protected KeyPad keyPad;
    protected Validator validator;

    @Override
    public SnackVendingMachine createNewMachine() {
        return new SnackVendingMachine();
    }

    @Override
    public KeyPad installKeyPad() {
        this.keyPad = KeyPad.getKeyPad();
        return this.keyPad;
    }

    @Override
    public Validator installValidator() {
        validator = new Validator();
        return validator;
    }
}
