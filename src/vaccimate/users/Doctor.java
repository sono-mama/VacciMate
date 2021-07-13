package vaccimate.users;

import vaccimate.process.Appointment;
import vaccimate.process.CalendarManager;
import vaccimate.process.VaccinationSite;

public class Doctor extends Employee {

    public Doctor(String firstName, String lastName, VaccinationSite vaccinationSite) {
        super(firstName, lastName, vaccinationSite);
    }

    public void setVaccineStatus(String code, CalendarManager calendar){

        Appointment appointment = getAppointmentFromCode(code, calendar);
        appointment.setVaccineGiven(true);
    }
}
