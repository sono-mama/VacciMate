package src.process;

import src.users.Patient;

import java.time.LocalDate;

public class Appointment {

    private String code;
    private LocalDate date;
    private Patient patient;
    private VaccinationSite site;
    private Vaccine vaccine;
    private boolean isBooked;
    private boolean vaccineGiven;
    private boolean patientDataChecked;
    private String[] startTime;

    public Appointment(LocalDate inDate, int slot) {
        this.isBooked = false;
        this.vaccineGiven = false;
        this.patientDataChecked = false;
        this.date = inDate;
        this.startTime = setTime(slot);
    }

    private String[] setTime(int slot){
        String[][] timeslots = {
                {"09:", "00"},
                {"09:", "20"},
                {"09:", "40"},
                {"10:", "00"},
                {"10:", "20"},
                {"10:", "40"},
                {"11:", "00"},
                {"11:", "20"},
                {"11:", "40"},
                {"12:", "00"},
                {"12:", "20"},
                {"12:", "40"},
                {"13:", "00"},
                {"13:", "20"},
                {"13:", "40"},
                {"14:", "00"},
                {"14:", "20"},
                {"14:", "40"},
                {"15:", "00"},
                {"15:", "20"},
                {"15:", "40"},
                {"16:", "00"},
                {"16:", "20"},
                {"16:", "40"},
                {"17:", "00"},
                {"17:", "20"},
                {"17:", "40"},
                {"18:", "00"},
                {"18:", "20"},
                {"18:", "40"}
        };
        return timeslots[slot];
    }

    public String[] getStartTime() {
        return startTime;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isVaccineGiven() {
        return vaccineGiven;
    }

    public void setVaccineGiven(boolean vaccineGiven) {
        this.vaccineGiven = vaccineGiven;
    }

    public boolean isPatientDataChecked() {
        return patientDataChecked;
    }

    public void setPatientDataChecked(boolean patientDataChecked) {
        this.patientDataChecked = patientDataChecked;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VaccinationSite getSite() {
        return site;
    }

    public void setSite(VaccinationSite site) {
        this.site = site;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "code=" + code +
                ", date=" + date +
                ", patient=" + patient +
                ", site=" + site +
                ", vaccine=" + vaccine +
                ", isBooked=" + isBooked +
                '}';
    }
}
