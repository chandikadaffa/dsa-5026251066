package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> enrollment = new LinkedHashMap<>();
        int reject = 0;

        System.out.println("===== Enrollment Checks =====");
        while (input.hasNext()) {
            String operation = input.next();
            String courseCode = input.next();
            if (operation.equals("REGISTER")) {
                int count = input.nextInt();
                if (count <= 0) {
                    reject++;
                } else {
                    int currentCount = 0;
                    if (enrollment.containsKey(courseCode)) {
                        currentCount = enrollment.get(courseCode);
                    }
                    enrollment.put(courseCode, currentCount + count);
                }
            } else if (operation.equals("WITHDRAW")) {
                int count = input.nextInt();
                if (count <= 0) {
                    reject++;
                } else if (enrollment.containsKey(courseCode) && enrollment.get(courseCode) >= count) {
                    int currentCount = enrollment.get(courseCode);
                    enrollment.put(courseCode, currentCount - count);
                } else {
                    reject++;
                }
            } else if (operation.equals("CHECK")) {
                if (enrollment.containsKey(courseCode)) {
                    System.out.println(courseCode + ": " + enrollment.get(courseCode) + " students");
                } else {
                    System.out.println(courseCode + ": Not found");
                }
            }
        }
        input.close();

        System.out.println("===== Final Enrollment =====");
        for (String courseCode : enrollment.keySet()) {
            System.out.println(courseCode + ": " + enrollment.get(courseCode) + " students");
        }
        System.out.println("Rejected operations: " + reject);
    }
}