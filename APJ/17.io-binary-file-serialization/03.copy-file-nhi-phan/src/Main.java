import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("From file path:");
        String fromFilePath = scanner.nextLine();
        System.out.println("To file path:");
        String toFilePath = scanner.nextLine();
        copyFile(fromFilePath, toFilePath);
    }

    public static void copyFile(String fromFilePath, String toFilePath) {
        File fromFile = new File(fromFilePath);
        File toFile = new File(toFilePath);

        if (!fromFile.exists()) {
            System.out.println("File " + fromFilePath + "not found!");
            return;
        }
        if (toFile.exists()) {
            System.out.println("The file " + toFilePath + " already exist!");
            return;
        }

        System.out.println("Copying...");
        try (
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fromFile));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(toFile));
        ) {
            int len;
            byte[] buffer = new byte[8192];
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer,0, len);
            }
            System.out.println("Copy file success");
        } catch (IOException e) {
            System.out.println("Copy file failed");
            e.printStackTrace();
        }
    }
}
