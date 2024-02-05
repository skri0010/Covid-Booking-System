package utility;

import java.util.Random;

/**
 * Class represent the StringGenerator
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 */
public class StringGenerator {

    /**
     * Create a random string
     *
     * @return String
     */
    public String createString(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringB = new StringBuilder();
        Random random = new Random();
        while (stringB.length() < 18) { // length of the random string.
            int index = (int) (random.nextFloat() * chars.length());
            stringB.append(chars.charAt(index));
        }
        String generatedStr = stringB.toString();
        return generatedStr;
    }
}
