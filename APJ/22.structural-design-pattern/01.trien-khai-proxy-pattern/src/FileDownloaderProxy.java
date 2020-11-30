import java.net.URL;

public class FileDownloaderProxy implements Downloader {

    @Override
    public void download(URL url, String saveTo) {
        String userAgent = "\"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2\"";
        FileDownloader downloader = new FileDownloader(userAgent);
        downloader.download(url, saveTo);
    }
}
