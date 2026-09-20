import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();

        InputStream input = Main.class.getResourceAsStream("jobs.txt");

        if (input == null) {
            System.out.println("File jobs.txt not found");
            return;
        }

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                String type = scanner.next();     
                String id = scanner.next();      
                int pages = scanner.nextInt();   

                if (type.equals("MONO")) {
                    jobs.add(new MonoPrint(id, pages));
                } else if (type.equals("COLOUR")) {
                    jobs.add(new ColourPrint(id, pages));
                }
            }
        }

        for (int i = 0; i < jobs.size(); i++) {
            PrintJob job = jobs.get(i);
            System.out.println(job.summary());
        }
    }
}