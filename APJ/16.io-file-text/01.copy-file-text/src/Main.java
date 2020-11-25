import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner cliScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Path to the copy file:");
        String fromFilePath = cliScanner.nextLine();
        File fromFile = new File(fromFilePath);

        System.out.println("Path to the destination file:");
        String toFilePath = cliScanner.nextLine();
        File toFile = new File(toFilePath);

        try {
            System.out.println("Reading file...");
            String fileContent = readFile(fromFile);
            System.out.println("Writing file...");
            writeFile(toFile, fileContent);
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static String readFile(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        bufferedReader.close();
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void writeFile(File file, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(content);
        fileWriter.close();
    }
}
