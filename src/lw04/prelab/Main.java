package lw04.prelab;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = input.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = input.nextInt();
        }

        int m = input.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = input.nextInt();
        }
        input.close();

        for (int i = 1; i <= 3; i++) {
            int temp = branches[i];
            int j = i - 1;
            while (j >= 0 && branches[j] < temp) {
                branches[j + 1] = branches[j];
                j--;
            }
            branches[j + 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(branches[i]);
        }
        System.out.println();

        for (int t = 0; t < m; t++) {
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (branches[i] == target[t]) {
                    index = i;
                    break;
                }
            }
            if (index >= 0) {
                System.out.println(target[t] + ": FOUND at index " + index);
            } else {
                System.out.println(target[t] + ": NOT FOUND");
            }
        }
    }
}