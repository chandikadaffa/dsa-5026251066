package lw03.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Problem 1
        System.out.println("===== Problem 1 =====");
        Scanner s1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playList = new ArrayList<>();
        while (s1.hasNext()) {
            String type = s1.next();
            if (type.equals("ADD")) {
                String song = s1.nextLine();
                playList.add(song);
            } else if (type.equals("INSERT")) {
                int index = s1.nextInt();
                String song = s1.nextLine();
                playList.add(index, song);
            } else if (type.equals("REMOVE")) {
                String song = s1.nextLine();
                playList.remove(song);
            }
        }
        s1.close();

        System.out.println("Total songs: " + playList.size());
        for (int i = 0; i < playList.size(); i++) {
            System.out.println((i + 1) + ": " + playList.get(i));
        }

        //Problem 2
        System.out.println("===== Problem 2 =====");
        Scanner s2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> partisipants = new LinkedHashSet<>();
        int duplicate = 0;
        while (s2.hasNextLine()) {
            String name = s2.nextLine();
            if (!name.isEmpty()) {
                boolean add = partisipants.add(name);
                if (!add) {
                    duplicate++;
                }
            }
        }
        s2.close();

        System.out.println("Unique participants: " + partisipants.size());
        int rank = 1;
        for (String participant : partisipants) {
            System.out.println(rank + ". " + participant);
            rank++;
        }
        System.out.println("Duplicate registrations: " + duplicate);
        
        //Problem 3
        System.out.println("===== Problem 3 =====");
        Scanner s3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;
        while (s3.hasNext()) {
            String type = s3.next();
            String product = s3.next();
            int quantity = s3.nextInt();
            if (type.equals("ADD")) {
                int stock = 0;
                if (inventory.containsKey(product)) {
                    stock = inventory.get(product);
                }
                inventory.put(product, stock + quantity);
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    int stock = inventory.get(product);
                    inventory.put(product, stock - quantity);
                } else {
                    failed++;
                }
            }
        }
        s3.close();

        for (String product : inventory.keySet()) {
            int stock = inventory.get(product);
            System.out.println(product + ": " + stock);
        }
        System.out.println("Failed sales: " + failed);
    }
}