package src.users;

import src.process.Appointment;
import src.process.CalendarManager;
import src.process.VaccinationSite;

public class Doctor extends Employee {

    public Doctor(String firstName, String lastName, VaccinationSite vaccinationSite) {
        super(firstName, lastName, vaccinationSite);
    }

    public void setVaccineStatus(String code, CalendarManager calendar){

        Appointment appointment = getAppointmentFromCode(code, calendar);
        appointment.setVaccineGiven(true);
    }

    public boolean getPatientData(String code, CalendarManager calendar){
        Appointment appointment = getAppointmentFromCode(code, calendar);
        System.out.println("Patient: " + appointment.getPatient().getFirstName() + appointment.getPatient().getLastName());
        System.out.println("Alter: " + appointment.getPatient().getAge());
        System.out.println("Impfstoff: " + appointment.getVaccine().getName());
        if(appointment.isPatientDataChecked()){
            System.out.println("Die Patientendaten wurden bestätigt.");
            if (appointment.getPatient().isAllergies()){
                System.out.println("Der Patient hat angegeben eine Allergie zu haben. Bitte Rücksprache mit dem Patieten führen.");
            } else {
                System.out.println("Der Patient hat keine Allergien.");
            }
            return true;
        } else {
            System.out.println("Die Patientendaten wurden noch nicht bestätigt.");
            return false;
        }
    }

}
