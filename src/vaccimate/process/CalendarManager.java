package vaccimate.process;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarManager {

    /*
    The CalendarManager class represents the outer structure, using an array list to save individual days
    (DayManager).
    */

    private int numberOfDays;
    private ArrayList<Appointment[][]> days;
    private LocalDate startDate;

    public CalendarManager(int numberOfDays, LocalDate startDate) {
        this.numberOfDays = numberOfDays;
        this.startDate = startDate;
        days = new ArrayList<>();

        for (int i = 0; i < numberOfDays; i++){
            LocalDate nextDate = startDate.plusDays(i);
            days.add(new DayManager(nextDate).getAppointments());
        }
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public ArrayList<Appointment[][]> getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
