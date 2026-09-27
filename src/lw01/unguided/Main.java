package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int units = sc.nextInt();
        Rental[] rentals = new Rental[units];
        int index = 0;

        while(sc.hasNext()) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();

            if(type.equals("LAPTOP")) {
                rentals[index++] = new LaptopRental(id, days, units);
            }else if(type.equals("PROJECTOR")) {
                rentals[index++] = new ProjectorRental(id, days, units);
            }
        }
        sc.close();

        for(int i = 0; i < index; i++) {
            System.out.println(rentals[i].summary());
        }
    }
}
