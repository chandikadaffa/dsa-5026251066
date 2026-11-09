package lw04.unguided;

import java.util.*;
public class Main {
    static void selectionSort(int[] arr, int pass) {
        for (int i = 0; i < pass; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = input.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = input.nextInt();
        }
        input.close();

        selectionSort(cards, 2);

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = linearSearch(cards, requests[i]);
            if (idx >= 0) {
                System.out.println(requests[i] + ": FOUND at index " + idx);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }
    }
}