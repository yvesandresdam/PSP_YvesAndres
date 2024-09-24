package Exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public static int getRandomIntNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static List<Integer> getListPrimes(int value) {
        List<Integer> listResult = new ArrayList<Integer>();
        for (int i = 2; i < value; i++) {
            if (isPrime(i)) {
                listResult.add(i);
            }
        }
        return listResult;
    }

    public static boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
