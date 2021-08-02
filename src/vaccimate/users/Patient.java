package vaccimate.users;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.auxiliary.PdfCreator;
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

       // setting non plausible values so that setFollowUpAppointment only gets called if the first appointment was booked successfully.
       int day = 99999999;
       int slot = 99999999;

       search:
        for (int i = 0; i < calendar.getNumberOfDays(); i++){
            for (int j = 0; j < calendar.getDays().get(i)[vaccCenter].length; j++){
                if (!calendar.getDays().get(i)[vaccCenter][j].isBooked()){
                    calendar.getDays().get(i)[vaccCenter][j].setPatient(patient);
                    calendar.getDays().get(i)[vaccCenter][j].setVaccine(Init.vaccineArray[vaccine]);
                    calendar.getDays().get(i)[vaccCenter][j].setCode(new CodeManager().generateCode(patient.getId(), vaccCenter, i, j));
                    calendar.getDays().get(i)[vaccCenter][j].setBooked(true);
                    calendar.getDays().get(i)[vaccCenter][j].setSite(Init.vaccinationSites[vaccCenter]);
                    
                    Appointment bookedAppointment = calendar.getDays().get(i)[vaccCenter][j];

                    day = i;
                    slot = j;

                    System.out.println("Dies ist der nächste verfügbare Termin. Er wurde automatisch für sie gebucht.");
                    System.out.println("Datum: " + bookedAppointment.getDate());
                    System.out.println("Uhrzeit: " + bookedAppointment.getStartTime()[0] +
                            bookedAppointment.getStartTime()[1]);
                    System.out.println("Impfzentrum: " + bookedAppointment.getSite().getName() + " " +
                            bookedAppointment.getSite().getAddress().getStreetName() + " " +
                            bookedAppointment.getSite().getAddress().getStreetNo() + " " +
                            bookedAppointment.getSite().getAddress().getPostalCode() + " " +
                            bookedAppointment.getSite().getAddress().getCity());
                    System.out.println("Impfstoff: " + bookedAppointment.getVaccine().getBrand() + " " +
                            bookedAppointment.getVaccine().getName());
                    System.out.println("Termin-Code: " + bookedAppointment.getCode());

                    new PdfCreator().createConfirmationPdf(bookedAppointment);
                    System.out.println("Eine PDF mit der Terminbestätigung wurde erstellt.");
                    break search;
                }
            }
            System.out.println("Aktuell sind leider keine freien Termine verfügbar. Bitte versuchen Sie es zu einem " +
                    "späteren Zeitpunkt erneut.");
        }
        if (day != 99999999 && slot != 99999999){
            setFollowUpAppointment(vaccCenter, calendar, calendar.getDays().get(day)[vaccCenter][slot], day, slot);
        }
    }

    // setting a corresponding second appointment after a set duration according to STIKO guidelines.
    public void setFollowUpAppointment(int vaccCenter, CalendarManager calendar, Appointment firstAppointment, int day, int slot) throws
            IndexOutOfBoundsException {
        try{
            int nextDay = day + firstAppointment.getVaccine().getWaitingPeriod();
            calendar.getDays().get(nextDay)[vaccCenter][slot].setPatient(firstAppointment.getPatient());
            calendar.getDays().get(nextDay)[vaccCenter][slot].setVaccine(firstAppointment.getVaccine());
            calendar.getDays().get(nextDay)[vaccCenter][slot].setCode(new CodeManager().generateCode(firstAppointment.getPatient().getId(), vaccCenter, day, slot));
            calendar.getDays().get(nextDay)[vaccCenter][slot].setBooked(true);
            calendar.getDays().get(nextDay)[vaccCenter][slot].setSite(Init.vaccinationSites[vaccCenter]);

            Appointment bookedAppointment = calendar.getDays().get(nextDay)[vaccCenter][slot];

            System.out.println("Dies ist ihr Zweittermin:");
            System.out.println("Datum: " + bookedAppointment.getDate());
            System.out.println("Uhrzeit: " + bookedAppointment.getStartTime()[0] +
                    bookedAppointment.getStartTime()[1]);
            System.out.println("Termin-Code: " + bookedAppointment.getCode());

            new PdfCreator().createConfirmationPdf(bookedAppointment);
            System.out.println("Eine PDF mit der Terminbestätigung für ihren Zweittermin wurde erstellt.");



        } catch (IndexOutOfBoundsException e){
            System.out.println("Eine Vergabe eines Zweittermins ist zum jetzigen Zeitpunkt leider nicht möglich.");
        }

    }

    public void cancelAppointment(String code, CalendarManager calendar){

        Appointment appointment = getAppointmentFromCode(code, calendar);

        if (appointment != null && appointment.getPatient() != null){
            appointment.setBooked(false);
            appointment.setVaccineGiven(false);
            appointment.setPatient(new Patient("",""));
            appointment.setCode("");
        } else if (appointment != null && appointment.getPatient() == null){
            System.out.println("Fehler im Termincode.");
        }
    }

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


