package Exercise4;

import java.util.Random;

public class Utils {
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }
}
