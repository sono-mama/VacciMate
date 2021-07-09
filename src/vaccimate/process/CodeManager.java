package vaccimate.process;

import java.util.Random;

public class CodeManager {

    public String generateCode(String id, int vaccCenter, int day, int slot){

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        Random rn = new Random();
        int max = 25;
        int min = 1;

        String code = Integer.valueOf(vaccCenter).toString() + alphabetUpper[rn.nextInt(max - min + 1) + min] +
                id.substring(0, 3) + alphabet[rn.nextInt(max - min + 1) + min] + Integer.valueOf(day).toString() +
                Integer.valueOf(slot).toString();
        return code;
    }
}
