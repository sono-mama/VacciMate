package vaccimate.process;

import vaccimate.users.Patient;

import java.util.Date;

public class Appointment {

    private int code;
    private Date date;
    private Patient patient;
    private VaccinationSite site;
    private Vaccine vaccine;
    boolean isBooked;

    public Appointment() {
        this.isBooked = false;
    }

    public Appointment(int code, Date date, Patient patient, VaccinationSite site, Vaccine vaccine) {
        this.code = code;
        this.date = date;
        this.patient = patient;
        this.site = site;
        this.vaccine = vaccine;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
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
                ", firstAppointment=" +
                ", followUpAppointment=" +
                ", vaccine=" + vaccine +
                '}';
    }
}
