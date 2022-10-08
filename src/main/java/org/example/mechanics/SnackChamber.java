package org.example.mechanics;

import org.example.product.Product;
import org.example.product.ProductsSupplier;
import org.example.product.Snack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SnackChamber extends ProductsSupplier {
    private static HashMap<Integer, Column[]> map;
    private static SnackChamber snackChamberInstance;
    private int whereToAddRow;
    private int whereToAddCol;

    private SnackChamber() {
        map = new HashMap<>();
        map.put(1, initializeCol());
        map.put(2, initializeCol());
        map.put(3, initializeCol());
        map.put(4, initializeCol());
        map.put(5, initializeCol());


    }

    public static SnackChamber getChamberInstance() {
        if (snackChamberInstance == null) {
            snackChamberInstance = new SnackChamber();
        }
        return snackChamberInstance;
    }

    private Column[] initializeCol() {
        Column[] columns = new Column[5];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new Column();
        }
        return columns;
    }

    @Override
    public boolean addProduct(Product product) {
        for (Map.Entry<Integer, Column[]> entry : map.entrySet()) {

            for (int i = 0; i < entry.getValue().length; i++) {
                Column column = entry.getValue()[i];
                if (column.addSnack((Snack) product)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Product getProduct() {
        KeyPad keyPad = KeyPad.getKeyPad();
        PriorityQueue<Integer> priorityQueue = keyPad.getKeyPadEntries();
        int row = priorityQueue.poll();
        int col = priorityQueue.poll();
        if (!map.get(row)[col].getSnacks().isEmpty()) {
            Snack snack = map.get(row)[col].getSnacks().get(0);
            map.get(row)[col].getSnacks().remove(0);
            return snack;

        }
        return null;

    }
}
