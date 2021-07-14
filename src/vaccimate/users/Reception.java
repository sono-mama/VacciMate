package vaccimate.users;

import vaccimate.process.Appointment;
import vaccimate.process.CalendarManager;
import vaccimate.process.VaccinationSite;

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

        if (calendar.startDate.compareTo(LocalDate.now()) == 0){
           appointments = calendar.days.get(0)[vaccCenter];
        } else {
            int index = calendar.startDate.compareTo(LocalDate.now());
            appointments = calendar.days.get(index)[vaccCenter];
        }

        System.out.println("Termine für heute (" + LocalDate.now() + ") in chronologischer Reihenfolge: ");
        for (Appointment appointment : appointments) {
            System.out.println("Patient: " + appointment.getPatient().getFirstName() + ", " +
                    appointment.getPatient().getLastName());
            System.out.println("Code: " + appointment.getCode());
            System.out.println("Uhrzeit: " + appointment.getStartTime()[0] + appointment.getStartTime()[1]);
            System.out.println("Impfstoff: " + appointment.getVaccine());
        }

        // createPdf();

    }
}
