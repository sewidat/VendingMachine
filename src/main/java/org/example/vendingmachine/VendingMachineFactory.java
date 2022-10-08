package org.example.vendingmachine;

import org.example.mechanics.CoinSlot;
import org.example.mechanics.KeyPad;
import org.example.mechanics.Validator;

public abstract class VendingMachineFactory {

    KeyPad keyPad;
    Validator validator;
    CoinSlot coinSlot;

    public abstract VendingMachine createNewMachine();

    public abstract KeyPad installKeyPad();

    public abstract Validator installValidator();

}
