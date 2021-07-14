package vaccimate.users;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.process.*;



public class Patient extends User {

    private Address address;
    private int age;
    private Contact contact;
    private boolean allergies;

    public Patient(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Patient(String firstName, String lastName, Address address, int age, Contact contact, boolean allergies) {
        super(firstName, lastName);
        this.address = address;
        this.age = age;
        this.contact = contact;
        this.allergies = allergies;
    }

    public void setAppointment(int vaccCenter, CalendarManager calendar, Patient patient, int vaccine){

       int day = 99999999; // unsicher????
       int slot = 99999999;

       search:
        for (int i = 0; i < calendar.numberOfDays; i++){
            for (int j = 0; j < calendar.days.get(i)[vaccCenter].length; j++){
                if (!calendar.days.get(i)[vaccCenter][j].isBooked()){
                    calendar.days.get(i)[vaccCenter][j].setPatient(patient);
                    calendar.days.get(i)[vaccCenter][j].setVaccine(Init.vaccineArray[vaccine]);
                    calendar.days.get(i)[vaccCenter][j].setCode(new CodeManager().generateCode(patient.getId(), vaccCenter, i, j));
                    calendar.days.get(i)[vaccCenter][j].setBooked(true);
                    calendar.days.get(i)[vaccCenter][j].setSite(Init.vaccinationSites[vaccCenter]);
                    
                    day = i;
                    slot = j;
                    break search;
                }
            }
            System.out.println("Aktuell sind leider keine freien Termine verfügbar. Bitte versuchen Sie es zu einem " +
                    "späteren Zeitpunkt erneut.");
        }
        if (day != 99999999 && slot != 99999999){
            setFollowUpAppointment(vaccCenter, calendar, calendar.days.get(day)[vaccCenter][slot], day, slot);
        }
    }

    public void setFollowUpAppointment(int vaccCenter, CalendarManager calendar, Appointment firstAppointment, int day, int slot) throws
            IndexOutOfBoundsException {
        try{
            int nextDay = day + firstAppointment.getVaccine().getWaitingPeriod();
            calendar.days.get(nextDay)[vaccCenter][slot].setPatient(firstAppointment.getPatient());
            calendar.days.get(nextDay)[vaccCenter][slot].setVaccine(firstAppointment.getVaccine());
            calendar.days.get(nextDay)[vaccCenter][slot].setCode(new CodeManager().generateCode(firstAppointment.getPatient().getId(), vaccCenter, day, slot));
            calendar.days.get(nextDay)[vaccCenter][slot].setBooked(true);
            calendar.days.get(nextDay)[vaccCenter][slot].setSite(Init.vaccinationSites[vaccCenter]);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Eine Vergabe eines Zweittermins ist zum jetzigen Zeitpunkt leider nicht möglich.");
        }

    }

    public void cancelAppointment(String code, CalendarManager calendar){

        Appointment appointment = getAppointmentFromCode(code, calendar);

        appointment.setBooked(false);
        appointment.setVaccineGiven(false);
        appointment.setPatient(new Patient("",""));
        appointment.setCode("");
    }

    public void createPDF(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean isAllergies() {
        return allergies;
    }

    public void setAllergies(boolean allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "address=" + address +
                ", age=" + age +
                ", contact=" + contact +
                ", allergies=" + allergies +
                '}';
    }
}


