import java.util.Random;

public class Car implements Runnable {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        Random random = new Random();

        while (isNotFinish(runDistance)) {
            try {
                runDistance = getNewRunDistance(runDistance, random);
                System.out.println("Car" + this.name + ": " + renderGraphic(runDistance) + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }

    private boolean isNotFinish(int runDistance) {
        return runDistance < Main.DISTANCE;
    }

    private int getNewRunDistance(int runDistance, Random random) {
        int speed = random.nextInt(20);
        runDistance += speed;
        return runDistance;
    }

    private String renderGraphic(int runDistance) {
        StringBuilder log = new StringBuilder("|");
        int percentTravel = getPercentTravel(runDistance);
        for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
            log.append(getChar(percentTravel, i));
        }
        log.append("|");
        return log.toString();
    }

    private int getPercentTravel(int runDistance) {
        return (runDistance * 100) / Main.DISTANCE;
    }

    private char getChar(int percentTravel, int i) {
        return (percentTravel >= i + Main.STEP)
                ? '='
                : (percentTravel >= i && percentTravel < i + Main.STEP)
                ? 'o'
                : '-';
    }


}