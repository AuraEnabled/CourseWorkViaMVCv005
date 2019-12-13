package sample.classes;

import java.util.Random;


public class Utils {

    private static Random random = new Random();


    public static int getRandomInteger(final int size) {
        return random.nextInt(size + 1);
    }

    public static int getRandomInteger(final int left, final int right) {
        return left + random.nextInt(right - left + 1);
    }
}
