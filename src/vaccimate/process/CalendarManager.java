package vaccimate.process;

import java.util.ArrayList;

public class CalendarManager {

    /*
    The CalendarManager class represents the outer structure, using an array list to save individual days
    (DayManager).
    */

    public int numberOfDays;
    public ArrayList<Appointment[][]> days;

    public CalendarManager(int numberOfDays) {
        this.numberOfDays = numberOfDays;
        days = new ArrayList<>();

        for (int i = 0; i < numberOfDays; i++){
            days.add(new DayManager().appointments);
        }

    }
}
