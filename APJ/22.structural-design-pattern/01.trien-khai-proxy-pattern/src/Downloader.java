import java.net.URL;

public interface Downloader {
    void download(URL url, String saveTo);
}
