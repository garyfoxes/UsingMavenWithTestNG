package testngexamples.dataprovider;

/**
 * Created by gfox on 04/05/2016.
 */
public class PrimeNumberChecker {

    public static Boolean validate(final Integer primeNumber) {

        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
