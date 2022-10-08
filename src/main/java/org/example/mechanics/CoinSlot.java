package org.example.mechanics;

import org.example.types.CoinSlotTypes;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CoinSlot {
    private static CoinSlot coinSlotInstance;
    private PriorityQueue<CoinSlotTypes> priorityQueue;

    private CoinSlot() {
        priorityQueue = new PriorityQueue<>();
    }

    public static CoinSlot getInstance() {
        if (coinSlotInstance == null) {
            coinSlotInstance = new CoinSlot();
        }
        return coinSlotInstance;
    }

    protected PriorityQueue<CoinSlotTypes> takeMoney() {
        double totalAmount = 0;
        priorityQueue.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What To Insert?!");
        System.out.println("[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]");
        System.out.println("To Finish Enter -1");
        int read = scanner.nextInt();
        do {

            switch (read) {
                case 1 -> {
                    priorityQueue.add(CoinSlotTypes.TenCoin);
                    totalAmount += 0.1;
                }
                case 2 -> {
                    priorityQueue.add(CoinSlotTypes.TwentyCoin);
                    totalAmount += 0.2;
                }
                case 3 -> {
                    priorityQueue.add(CoinSlotTypes.FiftyCoin);
                    totalAmount += 0.5;
                }
                case 4 -> {
                    priorityQueue.add(CoinSlotTypes.Dollar);
                    totalAmount += 1;
                }
                case 5 -> {
                    priorityQueue.add(CoinSlotTypes.TwentyNote);
                    totalAmount += 20;
                }
                case 6 -> {
                    priorityQueue.add(CoinSlotTypes.FiftyNote);
                    totalAmount += 50;
                }

            }
            System.out.println("total amount: " + totalAmount);
            System.out.println("What To Insert?!");
            System.out.println("[1->10C|2->20C|3->50C|4->1$|5->20$|6->50$]");
            System.out.println("To Finish Enter -1");
            read = scanner.nextInt();
        } while (read != -1);
        System.out.println("-----------------------");
        return priorityQueue;
    }
}
