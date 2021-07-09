package vaccimate.process;

import vaccimate.users.Patient;

import java.util.Date;

public class Appointment {

    private String code;
    private Date date;
    private Patient patient;
    private VaccinationSite site;
    private Vaccine vaccine;
    boolean isBooked;

    public Appointment() {
        this.isBooked = false;
    }



    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
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
