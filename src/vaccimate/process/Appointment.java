package vaccimate.process;

import vaccimate.users.Patient;

import java.util.Date;

public class Appointment {

    private int code;
    private Date date;
    private Patient patient;
    private VaccinationSite site;
    private boolean firstAppointment;
    private Appointment followUpAppointment;
    private Vaccine vaccine;

    public Appointment(int code, Date date, Patient patient, VaccinationSite site, boolean firstAppointment, Appointment followUpAppointment, Vaccine vaccine) {
        this.code = code;
        this.date = date;
        this.patient = patient;
        this.site = site;
        this.firstAppointment = firstAppointment;
        this.followUpAppointment = followUpAppointment;
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

    public boolean isFirstAppointment() {
        return firstAppointment;
    }

    public void setFirstAppointment(boolean firstAppointment) {
        this.firstAppointment = firstAppointment;
    }

    public Appointment getFollowUpAppointment() {
        return followUpAppointment;
    }

    public void setFollowUpAppointment(Appointment followUpAppointment) {
        this.followUpAppointment = followUpAppointment;
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
                ", firstAppointment=" + firstAppointment +
                ", followUpAppointment=" + followUpAppointment +
                ", vaccine=" + vaccine +
                '}';
    }
}
