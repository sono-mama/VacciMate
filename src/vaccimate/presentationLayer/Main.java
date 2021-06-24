package vaccimate.presentationLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.process.Appointment;
import vaccimate.process.CalendarManager;
import vaccimate.process.VaccinationSite;
import vaccimate.process.Vaccine;
import vaccimate.users.Patient;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
	// write your code here


        Vaccine[] vaccineArray = new Vaccine[3];
        String[] vaccineName = {"Comirnaty", " Moderna Covid-19", "Covishield"};
        String[] vaccineBrand = {"Pfizer-BioNTech", "Moderna", "AstraZeneca"};
        int[] vaccineWaitingPeriod = {6, 6, 12};

        for(int i = 0; i < 3; i++) {
            vaccineArray[i] = new Vaccine(vaccineName[i], vaccineBrand[i], vaccineWaitingPeriod[i]);
        }

        // currently operating vaccination centers in Berlin. See: https://service.berlin.de/standorte/impfzentren/
        Address[] addressArray = new Address[6];
        String[] streetName = {"Eichenstr.", "MÃ¼llerstr.", "Saatwinklerdamm", "Terminal C", "Tempelhoferdamm", "HammarskjÃ¶ldplatz", "Paul-Heyse-Str."};
        String[] streetNo = {"4", "185", "", "57", "5", "26"};
        String[] postalCode = {"12435", "13353", "13405", "12101", "14055", "10407"};
        String[] city = {"Berlin"};

        for (int i = 0; i < 6; i++){
            addressArray[i] = new Address(streetName[i], streetNo[i],postalCode[i], city[0]);
        }

        Contact vaccSiteContact = new Contact("(030)9028-2200", "", "");
        String[] vaccinationCenterNames = {"Arena Berlin", "Erika-Hess-Eisstadion", "Flughafen Tegel", "Flughafen Tempelhof", "Messe Berlin", "Velodrom"};

        VaccinationSite[] vaccinationSites = new VaccinationSite[6];
        vaccinationSites[0] = new VaccinationSite(vaccinationCenterNames[0], vaccineArray[0], null, addressArray[0], vaccSiteContact);
        vaccinationSites[1] = new VaccinationSite(vaccinationCenterNames[1], vaccineArray[1], null, addressArray[1], vaccSiteContact);
        vaccinationSites[2] = new VaccinationSite(vaccinationCenterNames[2], vaccineArray[1], vaccineArray[0], addressArray[2], vaccSiteContact);
        vaccinationSites[3] = new VaccinationSite(vaccinationCenterNames[3], vaccineArray[1], vaccineArray[2], addressArray[3], vaccSiteContact);
        vaccinationSites[4] = new VaccinationSite(vaccinationCenterNames[4], vaccineArray[0], null, addressArray[4], vaccSiteContact);
        vaccinationSites[0] = new VaccinationSite(vaccinationCenterNames[5], vaccineArray[0], null, addressArray[5], vaccSiteContact);


        CalendarManager calendar = new CalendarManager(10);









        Address pat1Add = new Address("Musterstr.", "1", "12151", "Berlin");
        Contact pat1Cont = new Contact("03032590909", "01764589901", "max.mustermann@web.de");
        Patient pat1 = new Patient("Max", "Mustermann", 12345, pat1Add, 89, pat1Cont, true);
        
        int menuhelper = 0;
        do {
        	System.out.println("0 - Programm beenden\n1 - Anmelden als Patient\n2 - Anmelden als Mitarbeiter\n3 - Anmelden als Arzt");
        	System.out.println("Bitte Funktion durch Eingabe der passenden Zahl wählen");
        	BufferedReader din= new BufferedReader(new InputStreamReader(System.in));
        	int numberuser = Integer.parseInt(din.readLine());
		
        	switch (numberuser) {
        		case 0: menuhelper = 1; break;
        		case 1: // Patient
					do {
						System.out.println("0 - zurück\n1 - Termin buchen\n2 - Termin aufrufen");
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl wählen");
						BufferedReader dinpatient = new BufferedReader(new InputStreamReader(System.in));
						int numberpatient = Integer.parseInt(dinpatient.readLine());
						switch (numberpatient) {
							case 0: menuhelper = 1; break;
							case 1: // Aufruf setAppointment();
							case 2: // Aufruf showAppointment();
						}
					} while(menuhelper == 0); menuhelper = 0;
					break;
				case 2: // Rezeption
					do {
						System.out.println("0 - zurück\n1 - Termin aufrufen\n2 - Terminübersicht anzeigen");
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl wählen");
						BufferedReader dinreception = new BufferedReader(new InputStreamReader(System.in));
						int numberreception = Integer.parseInt(dinreception.readLine());
						switch (numberreception) {
							case 0: menuhelper = 1; break;
							case 1: // Aufruf showAppointment();
							case 2: // Aufruf showAppointmentList();
						}
        			} while(menuhelper == 0); menuhelper = 0;
        			break;
				case 3: // Arzt
					do {
						System.out.println("0 - zurück\n1 - Patient impfen");
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl wählen");
						BufferedReader dindoctor = new BufferedReader(new InputStreamReader(System.in));
						int numberdoctor = Integer.parseInt(dindoctor.readLine());
						switch (numberdoctor) {
							case 0: menuhelper = 1; break;
							case 1: // Aufruf setVaccineStatus();
						}
					} while(menuhelper == 0); menuhelper = 0;
					break;
        	}
        } while (menuhelper == 0);
    }
}
