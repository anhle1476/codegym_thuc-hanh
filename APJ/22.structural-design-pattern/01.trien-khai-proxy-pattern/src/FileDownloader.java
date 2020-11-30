import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader implements Downloader {
    String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(URL url, String saveTo) {
        try {
            downloadAndWritingFile(url, saveTo);
        } catch (IOException e) {
            System.out.println("Download failed! " + e.getMessage());
        }
    }

    private void downloadAndWritingFile(URL url, String saveTo) throws IOException {
        URLConnection urlCon = url.openConnection();
        urlCon.setRequestProperty("User-Agent", userAgent);
        BufferedInputStream inputStream = new BufferedInputStream(urlCon.getInputStream());
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(saveTo)));

        int length;
        byte[] buffer = new byte[8129];
        System.out.println("Downloading");
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        System.out.println("Download completed!");

        inputStream.close();
        outputStream.close();
    }
}
