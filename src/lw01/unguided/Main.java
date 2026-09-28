package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(
            Main.class.getResourceAsStream("rentals.txt")
        );

        int totalRecords = sc.nextInt();

        Rental[] rentals = new Rental[totalRecords];

        for (int i = 0; i < totalRecords; i++) {

            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

            if (type.equals("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days, units);
            } else if (type.equals("PROJECTOR")) {
                rentals[i] = new ProjectorRental(id, days, units);
            }
        }

        sc.close();

        for (int i = 0; i < rentals.length; i++) {
            System.out.println(rentals[i].summary());
        }
    }
}