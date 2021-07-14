package vaccimate.presentationLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.process.*;
import vaccimate.users.Patient;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
	// write your code here

		Init init = new Init();



		CalendarManager calendar = new CalendarManager(90, LocalDate.now());


        Address pat1Add = new Address("Musterstr.", "1", "12151", "Berlin");
        Contact pat1Cont = new Contact("03032590909", "01764589901", "max.mustermann@web.de");
        Patient pat1 = new Patient("Max", "Mustermann", pat1Add, 89, pat1Cont, true);

		pat1.setAppointment(1, calendar, pat1, 1);

		System.out.println(calendar.days.get(0)[1][0].getCode());
		System.out.println(calendar.days.get(0)[1][0].getDate());


		System.out.println(calendar.days.get(42)[1][0].getCode());
		System.out.println(calendar.days.get(42)[1][0].getDate());




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


