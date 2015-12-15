import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by ethanmctiernan on 15/12/2015.
 */
public class day4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the puzzle string:");
        String stringIn = input.nextLine();
        System.out.println("How many zeros must the string start with?");
        int zeros=input.nextInt();
        System.out.println(getMD5(stringIn,zeros));
    }

    static long getMD5(String stringIn,int zeros) {
        String result = "There was a problem calculating";
        boolean set = false;
        int count=0;
        long number=0;
        try {
            while (true) {
                String temp = stringIn+number;
                byte[] bytesOfMessage = temp.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] theDigest = md.digest(bytesOfMessage);
                result = toHex(theDigest);
                char[] charArray = result.toCharArray();
                for (int i=0; i < zeros; i++ ) {
                    if (charArray[i] == '0') {
                        count++;
                        if (count == zeros && charArray[zeros] != 0) {
                            set = true;
                            break;
                        }
                    }
                }
                count = 0;
                if(set)break;
                number++;
            }

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
        return number;
    }

    static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

}
