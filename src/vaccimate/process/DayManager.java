package vaccimate.process;

public class DayManager {

    /*
    The DayManager class represents a day with bookable appointments. The vaccine centers are open
    09:00 - 19:00 and can serve 3 patients per hours resulting in 30 timeslots per day per center. The
    first dimension of the 2-dimensional array represents the 6 centers and the 2nd dimension the 30 available
    timeslots. This class provides the structure for saving the appointments.
    */

    public int numberOfSites = 6;
    public int numberOfSlots = 30;
    public Appointment[][] appointments;

    public DayManager() {
        appointments = new Appointment[numberOfSites][numberOfSlots];

    }
}