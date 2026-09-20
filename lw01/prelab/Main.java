package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> printList = new ArrayList<>();
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

        while(sc.hasNext()) {
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            if(type.equals("MONO")) {
                printList.add(new MonoPrint(id, pages));
            }else if(type.equals("COLOUR")) {
                printList.add(new ColourPrint(id, pages));
            }
        }
        sc.close();

        for(int i = 0; i < printList.size(); i++) {
            System.out.println(printList.get(i).summary());
        }
    }
}