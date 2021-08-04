package src.process;

import java.util.Random;

public class CodeManager {

    /*
    Class to create individual Codes for booked appointments, containing integers corresponding
    to the position in the array(s). PROBLEM: If a appointment gets canceled and a newly booked
    appointment is assigned the same timeslots, the old code could potentially still be used to
    access the new appointment. Further authentication is needed!
    */

    public String generateCode(String id, int vaccCenter, int day, int slot){

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUpper = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        Random rn = new Random();
        int max = 25;
        int min = 1;


        return Integer.valueOf(vaccCenter).toString() + alphabetUpper[rn.nextInt(max - min + 1) + min] +
                id.substring(0, 3) + alphabet[rn.nextInt(max - min + 1) + min] + Integer.valueOf(day).toString() +
                Integer.valueOf(slot).toString();
    }
}
