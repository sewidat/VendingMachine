package org.example.mechanics;

import org.example.product.Snack;

import java.util.ArrayList;

public class Column {
    private ArrayList<Snack> snacks;

    public Column() {
        snacks = new ArrayList<>();
    }

    public ArrayList<Snack> getSnacks() {
        return snacks;
    }

    public boolean addSnack(Snack snack) {
        if (snacks.size() <= 10) {
            snacks.add(snack);
            return true;
        }
        return false;

    }
}
