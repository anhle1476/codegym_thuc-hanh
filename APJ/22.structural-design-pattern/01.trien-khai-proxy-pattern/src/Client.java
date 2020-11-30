import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Download url:");
        String testURL = "https://google.com";
        System.out.println(testURL);
        System.out.println("Save file to:");
        String saveTo = scanner.nextLine();

        try {
            FileDownloaderProxy proxy = new FileDownloaderProxy();
            proxy.download(new URL(testURL), saveTo);
        } catch (IOException e) {
            System.out.println("URL invalid");
        }
    }
}
