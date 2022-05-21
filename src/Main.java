import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //initializes counter
        int counter = 0;

        //loop to find average
        int number_of_iterations = 10;
        for (int i=0;i<number_of_iterations;i++){

            //Generates random key and iv
            Random random = new Random();
            byte[] key = new byte[10];
            byte[] iv = new byte[10];
            random.nextBytes(key);
            random.nextBytes(iv);
            String key_string = new String(key, StandardCharsets.ISO_8859_1);
            String iv_string = new String(iv, StandardCharsets.ISO_8859_1);


            //Initializes trivium
            trivium tr = new trivium(key_string,iv_string);

            //starts countdown
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            //Generates bits
            while(totalTime < 1000){
                tr.getNextBit();
                counter++;
                endTime = System.currentTimeMillis();
                totalTime = endTime - startTime;
            }
        }

        //print result
        System.out.println("Average number of bits generated in 1 second: " + counter/number_of_iterations);
    }
}