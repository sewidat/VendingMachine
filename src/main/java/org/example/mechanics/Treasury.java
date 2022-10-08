package org.example.mechanics;

import org.example.types.CoinSlotTypes;

import java.util.HashMap;
import java.util.Map;

public class Treasury {
    private static Treasury singleInventory;
    private static HashMap<CoinSlotTypes, Integer> safe;
    private double visaAmount = 0;

    private Treasury() {
        safe = new HashMap<>();
        //initially

        safe.put(CoinSlotTypes.TenCoin, 20);
        safe.put(CoinSlotTypes.TwentyCoin, 20);
        safe.put(CoinSlotTypes.FiftyCoin, 20);
        safe.put(CoinSlotTypes.Dollar, 20);
        safe.put(CoinSlotTypes.FiftyNote, 20);
        safe.put(CoinSlotTypes.TwentyNote, 20);


    }

    public static Treasury getInventoryInstance() {
        if (safe == null) {
            singleInventory = new Treasury();
        }
        return singleInventory;
    }

    protected HashMap getSafe() {
        return this.safe;
    }

    public boolean takeMoney(HashMap<CoinSlotTypes, Integer> hashMap) {
        for (Map.Entry<CoinSlotTypes, Integer> entry : hashMap.entrySet()) {
            safe.put(entry.getKey(), safe.get(entry.getKey()) + entry.getValue());

        }
        return false;
    }

    public boolean takeVisa(double amount) {
        // more about visa api ~~~
        visaAmount += amount;
        return true;
    }

    public double getVisaAmount() {
        return visaAmount;
    }


    protected double getAllCumulative() {
        return getCumulativeAmountOf10Coins() + getCumulativeAmountOf20Coins() + getCumulativeAmountOf50Coins()
                + getCumulativeAmountOf1$Coins() + getCumulativeAmountOf20$Coins() + getCumulativeAmountOf50$Coins() + visaAmount;
    }

    private double getCumulativeAmountOf10Coins() {
        try {
            return 0.1 * safe.get(CoinSlotTypes.TenCoin);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }

    }

    private double getCumulativeAmountOf20Coins() {
        try {
            return 0.2 * safe.get(CoinSlotTypes.TwentyCoin);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }
    }

    private double getCumulativeAmountOf50Coins() {
        try {
            return 0.5 * safe.get(CoinSlotTypes.FiftyCoin);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }

    }

    private double getCumulativeAmountOf1$Coins() {
        try {
            return 1 * safe.get(CoinSlotTypes.Dollar);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }


    }

    private double getCumulativeAmountOf20$Coins() {
        try {
            return 20 * safe.get(CoinSlotTypes.TwentyNote);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }

    }

    private double getCumulativeAmountOf50$Coins() {
        try {
            return 50 * safe.get(CoinSlotTypes.FiftyNote);
        } catch (NullPointerException nullPointerException) {
            return 0;
        }

    }


}
