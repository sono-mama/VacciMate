package vaccimate.process;

import vaccimate.users.Patient;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {

    private String code;
    private LocalDate date;
    private Patient patient;
    private VaccinationSite site;
    private Vaccine vaccine;
    boolean isBooked;
    boolean vaccineGiven;
    boolean patientDataChecked;

    public Appointment(LocalDate inDate) {
        this.isBooked = false;
        this.vaccineGiven = false;
        this.patientDataChecked = false;
        this.date = inDate;
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
