package org.example.mechanics;

import org.example.product.Snack;
import org.example.types.CoinSlotTypes;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Validator {
    PriorityQueue<CoinSlotTypes> temp;
    PriorityQueue<CoinSlotTypes> temp2;
    private int[][] snackPlace = new int[1][1];
    private Treasury treasury;
    private SnackChamber snackChamber;
    private double productPrice;

    public Validator() {
        this.treasury = Treasury.getInventoryInstance();
        this.snackChamber = SnackChamber.getChamberInstance();
        temp2 = new PriorityQueue<>();
    }

    public boolean mainProcedure() {
        Snack snack;

        try {
            snack = (Snack) snackChamber.getProduct();
            productPrice = snack.getProductPrice();
        } catch (Exception e) {
            System.out.println("Here we go again");
            return false;
        }
        System.out.println("How do wish to pay\n-> 1- cash\n-> 2- visa");
        Scanner scanner = new Scanner(System.in);
        int read = scanner.nextInt();
        System.out.println("-----------------------");
        if (read == 1) {
            System.out.println("Please Add Cash");
            addMoney(CoinSlot.getInstance().takeMoney());
            System.out.println("here is your change:");
            System.out.println(temp2.toString());
            System.out.println("-----------------------");
            System.out.println("-----------------------");
        } else if (read == 2) {
            System.out.println("please enter your visa");
            treasury.takeVisa(productPrice);
            System.out.println("done");
            System.out.println("-----------------------");
        }
        System.out.println("cash report:\n-> view into the cash\n" + treasury.getSafe().toString());
        System.out.println("All the money\"Cash+Visa\"" + treasury.getAllCumulative());
        return true;
    }


    public boolean addMoney(PriorityQueue<CoinSlotTypes> priorityQueue) {
        temp2.clear();
        this.temp = new PriorityQueue<>(priorityQueue);
        double amount = 0;
        amount = fromQueueToTreasury(priorityQueue);
        if (amount > productPrice == false) {
            System.out.println("Not Enough!");
            while (!temp.isEmpty()) {
                CoinSlotTypes coinSlotTypes = temp.poll();
                temp2.add(coinSlotTypes);
                Integer value = (Integer) treasury.getSafe().get(coinSlotTypes) - 1;
                treasury.getSafe().put(coinSlotTypes, value);
            }
            return false;
        }


        double toBeRefunded = (amount * 10) - (productPrice * 10);
        toBeRefunded = toBeRefunded / 10;
        boolean valid = attempt(toBeRefunded);
        if (!valid) fromQueueToTreasury(temp2);
        //  else temp2 = temp;
        return true;
    }

    public boolean attempt(double amount) {
        if (amount == 0) {
            return true;
        }
        if (amount >= 50 && (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyNote) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyNote) > 0) {

            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyNote) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.FiftyNote, value);
                temp2.add(CoinSlotTypes.FiftyNote);
                amount = mathematics(amount, 500);
                attempt(amount);
            }


        } else if (amount >= 20 && (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyNote) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyNote) > 0) {
            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyNote) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.TwentyNote, value);
                temp2.add(CoinSlotTypes.TwentyNote);
                amount = mathematics(amount, 200);
                attempt(amount);
            }

        } else if (amount >= 1 && (Integer) treasury.getSafe().get(CoinSlotTypes.Dollar) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.Dollar) > 0) {
            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.Dollar) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.Dollar, value);
                temp2.add(CoinSlotTypes.Dollar);
                amount = mathematics(amount, 10);
                attempt(amount);
            }

        } else if (amount >= 0.5 && (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyCoin) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyCoin) > 0) {
            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.FiftyCoin) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.FiftyCoin, value);
                temp2.add(CoinSlotTypes.FiftyCoin);
                amount = mathematics(amount, 5);
                attempt(amount);
            }

        } else if (amount >= 0.2 && (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyCoin) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyCoin) > 0) {
            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.TwentyCoin) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.TwentyCoin, value);
                temp2.add(CoinSlotTypes.TwentyCoin);
                amount = mathematics(amount, 2);
                attempt(amount);
            }

        } else if (amount >= 0.1 && (Integer) treasury.getSafe().get(CoinSlotTypes.TenCoin) != null && (Integer) treasury.getSafe().get(CoinSlotTypes.TenCoin) > 0) {
            Integer value = (Integer) treasury.getSafe().get(CoinSlotTypes.TenCoin) - 1;
            if (value >= 0) {
                treasury.getSafe().put(CoinSlotTypes.TenCoin, value);
                temp2.add(CoinSlotTypes.TenCoin);
                amount = mathematics(amount, 1);
                attempt(amount);
            }

        } else {
            return false;
        }
        return true;


    }

    private double mathematics(double amount, double howMuch) {
        amount *= 10;
        amount -= howMuch;
        amount /= 10;
        return amount;
    }

    private double fromQueueToTreasury(PriorityQueue<CoinSlotTypes> priorityQueue) {
        double amount = 0;
        while (!priorityQueue.isEmpty()) {
            CoinSlotTypes coinSlotTypes = priorityQueue.poll();
            switch (coinSlotTypes) {
                case TenCoin -> amount += 0.1;
                case TwentyCoin -> amount += 0.2;
                case Dollar -> amount += 1;
                case TwentyNote -> amount += 20;
                case FiftyNote -> amount += 50;
            }
            Integer value = (Integer) treasury.getSafe().get(coinSlotTypes) + 1;
            treasury.getSafe().put(coinSlotTypes, value);
        }
        return amount;
    }


}
