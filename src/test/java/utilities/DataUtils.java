package utilities;

import java.util.Random;

public class DataUtils {

    /*
    This method will generate random email.
    Ex:
        .generateEmail(); -> return"abc12345@gmail.com
     */

    public static String generateEmail() {
        Random random = new Random();
        int emailId = random.nextInt(100000);
        String email = "abc" + emailId + "@gmail.com";
        return email;
    }

    /*
    This method will generate random number between 1 and provided parameter.
    Ex:
        .generateRandomNumber(30); ->return 5
     */

    public static int generateRandomNumber(int range) {
        Random random = new Random();
        int randomNum=random.nextInt(range);
        return randomNum;
    }

}
