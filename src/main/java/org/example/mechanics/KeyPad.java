package org.example.mechanics;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KeyPad {
    private static PriorityQueue<Integer> keyPadEntries;
    private static KeyPad instance;
    private int[] keyPadNums = {1, 2, 3, 4, 5};

    private KeyPad() {
        keyPadEntries = new PriorityQueue<>();

    }

    public static KeyPad getKeyPad() {
        if (instance == null) {
            instance = new KeyPad();
        }
        return instance;
    }

    public int[] getKeyPadNums() {
        return keyPadNums;
    }

    public PriorityQueue<Integer> getKeyPadEntries() {
        keyPadEntries.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter The Row \"from 1->5\": ");
        System.out.println("\nTo Exit Please Enter 0");
        System.out.print("-> ");
        int entry = scanner.nextInt();
        if (entry == 0) {
            System.exit(0);
            keyPadEntries.clear();
            return keyPadEntries;
        }
        keyPadEntries.add(entry);
        System.out.println();
        System.out.print("Please Enter The Col \"from 1->5\": ");
        System.out.println("\nTo Exit Please Enter 0");
        System.out.print("-> ");
        entry = scanner.nextInt();
        if (entry == 0) {
            System.exit(0);
            keyPadEntries.clear();
            return keyPadEntries;
        }
        keyPadEntries.add(entry - 1);
        return keyPadEntries;
    }
}
