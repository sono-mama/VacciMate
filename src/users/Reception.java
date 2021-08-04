package users;

import auxiliary.PdfCreator;
import process.Appointment;
import process.CalendarManager;
import process.VaccinationSite;

import java.time.LocalDate;

public class Reception extends Employee {

    public Reception(String firstName, String lastName, VaccinationSite vaccinationSite) {
        super(firstName, lastName, vaccinationSite);
    }

    public void confirmPatientData(String code, CalendarManager calendar){
        Appointment appointment = getAppointmentFromCode(code, calendar);
        appointment.setPatientDataChecked(true);
    }

    public void createAppointmentList(int vaccCenter, CalendarManager calendar){

        Appointment[] appointments;

        if (calendar.getStartDate().compareTo(LocalDate.now()) == 0){
           appointments = calendar.getDays().get(0)[vaccCenter];
        } else {
            int index = calendar.getStartDate().compareTo(LocalDate.now());
            appointments = calendar.getDays().get(index)[vaccCenter];
        }

        System.out.println("Termine für heute (" + LocalDate.now() + ") in chronologischer Reihenfolge: ");
        for (Appointment appointment : appointments) {
            if (appointment.getPatient() == null){
                System.out.println(appointment.getStartTime()[0] + " " + appointment.getStartTime()[1] + " Freier Termin");
            } else {
                System.out.println(appointment.getStartTime()[0] + appointment.getStartTime()[1] + " Patient: " + appointment.getPatient().getFirstName() + ", " +
                        appointment.getPatient().getLastName() + " Code: " + appointment.getCode() +
                        " Impfstoff: " + appointment.getVaccine().getName());
            }
        }
        new PdfCreator().createAppointmentList(appointments);
        System.out.println("Ein PDF Dokument der Terminübersicht wurde erstellt!");
    }
}
