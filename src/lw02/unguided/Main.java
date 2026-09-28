package lw02.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int MAX_BORROW = 2; 
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> requestList = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>(); 
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();        
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        while (scanner.hasNext()) {
            String name = scanner.next();
            String bookTitle = scanner.next();
            requestList.add(new String[]{name, bookTitle});
            boolean exists = false;
            for (String[] member : members) {
                if (member[0].equals(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                members.add(new String[]{name, "0"}); 
            }
        }
        scanner.close();
        for (String[] req : requestList) {
            queue.add(req);
        }
    
        while (!queue.isEmpty()) {
            String[] currentReq = queue.poll();
            String borrowerName = currentReq[0];
            String bookTitle = currentReq[1];

            String[] targetBook = null;
            for (String[] b : books) {
                if (b[0].equals(bookTitle)) {
                    targetBook = b;
                    break;
                }
            }

            String[] targetMember = null;
            for (String[] m : members) {
                if (m[0].equals(borrowerName)) {
                    targetMember = m;
                    break;
                }
            }

            int currentStock = Integer.parseInt(targetBook[1]);
            int currentBorrowed = Integer.parseInt(targetMember[1]);

            if (currentStock > 0 && currentBorrowed < MAX_BORROW) {
                success.add(currentReq);
                targetBook[1] = String.valueOf(currentStock - 1);
                targetMember[1] = String.valueOf(currentBorrowed + 1);
            } else {
                failed.push(currentReq);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] req : success) {
            System.out.println(req[0] + " " + req[1]);
        }

        System.out.println("\n=== Remaining Book Stock ===");
        for (String[] b : books) {
            System.out.println(b[0] + ": " + b[1]);
        }

        System.out.println("\n=== Failed Requests ===");
        while (!failed.isEmpty()) {
            String[] req = failed.pop();
            System.out.println(req[0] + " " + req[1]);
        }
    }
}