import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + File.separator + "test.cvs";
        String[] fileContent = cvsReader(new File(filePath));
        if (fileContent == null) {
            System.out.println("File not found");
            return;
        }
        for (String line : fileContent) {
            String[] dataParts = line.split(",");
            String country = format(dataParts[5]);
            String countryCode = format(dataParts[4]);
            System.out.printf("%-3s: %s%n", countryCode, country);
        }
    }

    public static String[] cvsReader(File file) {
        try {
            Scanner scanner = new Scanner(file);
            List<String> data = new ArrayList<>();
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            return data.toArray(new String[0]);
        } catch (IOException e) {
            return null;
        }
    }

    public static String format(String data) {
        String[] parts = data.split("\"");
        return (parts.length == 2) ? parts[1] : "Invalid Data at: " + data;
    }
}
