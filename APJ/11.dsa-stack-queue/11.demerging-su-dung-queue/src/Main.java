import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Human female1 = new Human("Nguyen Thi A", Human.FEMALE, "1/1/1990");
        Human female2 = new Human("Nguyen Thi B", Human.FEMALE, "1/1/1993");
        Human female3 = new Human("Nguyen Thi C", Human.FEMALE, "1/1/1994");

        Human male1 = new Human("Nguyen Van A", Human.MALE, "1/1/1991");
        Human male2 = new Human("Nguyen Van B", Human.MALE, "1/1/1992");
        Human male3 = new Human("Nguyen Van C", Human.MALE, "1/1/1995");

        Human[] arr = {female1, male1, male2, female2, female3, male3};
        System.out.println("Before:");
        for (Human human : arr) {
            System.out.printf("%-20s%-10s%s%n", human.getName(), human.getGender(), human.getDayOfBirth());
        }

        System.out.println("Demerging:");
        LinkedList<Human> resultQueue = new LinkedList<>();
        Queue<Human> maleOnlyQueue = new LinkedList<>();

        for (Human human : arr) {
            if (human.getGender().equals(Human.FEMALE)) {
                resultQueue.offer(human);
            } else {
                maleOnlyQueue.offer(human);
            }
        }
        while (!maleOnlyQueue.isEmpty()) {
            resultQueue.offer(maleOnlyQueue.poll());
        }
        for (Human human : resultQueue) {
            System.out.printf("%-20s%-10s%s%n", human.getName(), human.getGender(), human.getDayOfBirth());
        }

    }
}
