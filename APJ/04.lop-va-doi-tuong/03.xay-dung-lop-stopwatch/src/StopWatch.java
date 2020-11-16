import java.util.Date;

public class StopWatch {
    long startTime = -1;
    long endTime = -1;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public Long getElapsedTime() {
        return (startTime < 0 || endTime < 0) ? null : endTime - startTime;
    }
}
