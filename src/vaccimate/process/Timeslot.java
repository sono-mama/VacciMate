package vaccimate.process;

public class Timeslot {

    private VaccinationSite vaccinationSite;
    private int nextAvailable;
    private int availableSlots;
    private Appointment [] appointments;

    public Timeslot(VaccinationSite vaccinationSite, int availableSlots) {
        this.vaccinationSite = vaccinationSite;
        this.appointments = new Appointment[availableSlots];
        this.nextAvailable = 1;
    }
}


