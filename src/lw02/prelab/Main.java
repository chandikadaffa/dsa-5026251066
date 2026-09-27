package lw02.prelab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>(); 

        while (input.hasNext()) {
            String name = input.next();
            String type = input.next();
            String amount = input.next();
            transactions.add(new String[]{name, type, amount});
            boolean exists = false;
            for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    exists = true;
                }
            }
            if (!exists) {
                customer.add(new String[]{name, "0"});
            }
        }
        input.close();

        Queue<String[]> queue = new LinkedList<>();
        for (String[] trans : transactions) {
            queue.add(trans);
        }

        Stack<String[]> failedTrans= new Stack<>();
        while (!queue.isEmpty()) {
            String[] trans = queue.poll();
            String name = trans[0];
            String type = trans[1];
            int amount = Integer.parseInt(trans[2]);
            for (String[] cust : customer) {
                if (cust[0].equals(name)) {
                    int saldo = Integer.parseInt(cust[1]);
                    if (type.equals("DEPOSIT")) {
                        saldo += amount;
                        cust[1] = String.valueOf(saldo);
                    } else if (type.equals("WITHDRAW")) {
                        if (amount > saldo) {
                            failedTrans.push(trans);
                        } else {
                            saldo -= amount;
                            cust[1] = String.valueOf(saldo);
                        }
                    }
                }               
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] cust : customer) {
            System.out.println(cust[0] + ": " + cust[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!failedTrans.isEmpty()) {
            String[] failed = failedTrans.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}