package vaccimate.users;

import vaccimate.process.Appointment;
import vaccimate.process.CalendarManager;

import java.util.UUID;

public class User {

    protected String firstName;
    protected String lastName;
    protected String id;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID().toString();
    }

    public Appointment getAppointmentFromCode (String code, CalendarManager calendar){

        int day = Character.getNumericValue(code.charAt(code.length()-1));
        int slot = Character.getNumericValue(code.charAt(code.length()-2));
        int vaccCenter = Character.getNumericValue(code.charAt(0));

        return calendar.days.get(day)[vaccCenter][slot];
    }

    public void showAppointment(String code, CalendarManager calendar){

        Appointment appointment = getAppointmentFromCode(code, calendar);

        System.out.println("Termincode: \n" + code);
        System.out.println("Datum: \n" + appointment.getDate());
        System.out.println("Uhrzeit: \n" + appointment.getStartTime()[0] + appointment.getStartTime()[1]);
        System.out.println("Patient: \n" + appointment.getPatient().firstName +
                ", " +
                appointment.getPatient().lastName);
        System.out.println("Impfstoff: \n" + appointment.getVaccine().getName());
        System.out.println("Impfzentrum: \n" + appointment.getSite().getName() +
                "\n" + appointment.getSite().getAddress().getStreetName() +
                appointment.getSite().getAddress().getStreetNo() + "\n" +
                appointment.getSite().getAddress().getPostalCode() + " " +
                appointment.getSite().getAddress().getCity());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
