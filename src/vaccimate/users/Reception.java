package vaccimate.users;

import vaccimate.process.Appointment;
import vaccimate.process.CalendarManager;
import vaccimate.process.VaccinationSite;

public class Reception extends Employee {

    public Reception(String firstName, String lastName, VaccinationSite vaccinationSite) {
        super(firstName, lastName, vaccinationSite);
    }

    public void confirmPatientData(String code, CalendarManager calendar){
        Appointment appointment = getAppointmentFromCode(code, calendar);
        appointment.setPatientDataChecked(true);
    }
}
