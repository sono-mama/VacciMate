package vaccimate.presentationLayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.auxiliary.PdfCreator;
import vaccimate.process.*;
import vaccimate.users.Doctor;
import vaccimate.users.Patient;
import vaccimate.users.Reception;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {


		Init init = new Init();
		VaccinationSite[] vaccinationSites = init.getVaccinationSites();
		Reception[] receptionStaff = init.getReceptionStaff();
		Doctor[] doctors = init.getDoctors();
		CalendarManager calendar = new CalendarManager(90, LocalDate.now());





		int menuhelper = 0;
		Patient patient0 = new Patient("0", "0");
		Doctor doctor0 = new Doctor("", "", null);
		Vaccine vaccine0 = new Vaccine("", "", 0);
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
        do {
        	System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
        	System.out.println("0 - Programm beenden\n1 - Anmelden als Patient\n2 - Anmelden als Mitarbeiter\n3 - Anmelden als Arzt");
        	BufferedReader din= new BufferedReader(new InputStreamReader(System.in));
        	int numberuser = Integer.parseInt(din.readLine());
		
        	switch (numberuser) {
        		case 0: menuhelper = 1; break;
        		case 1: // Patient
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Termin buchen\n2 - Termin aufrufen");
						BufferedReader dinpatient = new BufferedReader(new InputStreamReader(System.in));
						int numberpatient = Integer.parseInt(dinpatient.readLine());
						switch (numberpatient) {
							case 0: menuhelper = 1; break;
							case 1: // Termin buchen Methode enth�hlt Eingabe Patientendaten, Wahl Impfzentrum und Wahl Impfstoff
								Patient patient = setPatientDataInput();
								int vaccineCenterNumber = setVaccineCenterInput(vaccinationSites);
								int vaccineNumber = setVaccineInput(vaccineCenterNumber, vaccinationSites);
								boolean eligibility = vaccine0.eligiblityCheck(patient);
								if (eligibility) {
									patient.setAppointment(vaccineCenterNumber, calendar, patient, vaccineNumber);
								}
								else {System.out.println("Der Impfstoff ist nicht geeignet");}
								break;
							case 2: // Termin aufrufen mit der M�glichkeit der Stornierung oder der PDF - Erzeugung
								do {
									System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
									System.out.println("0 - zurueck\n1 - Termin stornieren"+"\n2 - PDF erzeugen");
									int numberShow = sc2.nextInt();
									switch (numberShow) {
									case 0: menuhelper = 1; break;
									case 1: // Termin stornieren
										System.out.println("Geben Sie bitte Ihren Termincode ein");
										String appointmentCodeCancel = sc.nextLine();
										patient0.cancelAppointment(appointmentCodeCancel, calendar);
										break;
									case 2: // Termin als PDF ausgeben
										System.out.println("Geben Sie bitte Ihren Termincode ein");
										String appointmentCodePDF = sc.nextLine();
										Appointment bookedAppointment = patient0.getAppointmentFromCode(appointmentCodePDF, calendar);
										if (bookedAppointment != null && bookedAppointment.getPatient() != null){
											new PdfCreator().createConfirmationPdf(bookedAppointment);
										} else if (bookedAppointment != null && bookedAppointment.getPatient() == null){
											System.out.println("Fehler im Termincode.");
										}
										break;
									}
								} while(menuhelper == 0); menuhelper = 0;
						}
					} while(menuhelper == 0); menuhelper = 0;
					break;
				case 2: // Rezeption
					System.out.println("In welchem Impfzentrum arbeiten Sie");
					System.out.println("1 - "+vaccinationSites[0].getName()+ "\n" + "2 - "+vaccinationSites[1].getName()+ "\n" + "3 - "+vaccinationSites[2].getName()+ "\n" + "4 - "+vaccinationSites[3].getName()+ "\n" + "5 - "+vaccinationSites[4].getName()+ "\n" + "6 - "+vaccinationSites[5].getName());
		        	int numberReceptionStaff = sc.nextInt();
		        	Reception receptionSelection = new Reception(null, null, null);
		        	switch (numberReceptionStaff) {
		        		case 1: receptionSelection = receptionStaff[0]; break;
		        		case 2: receptionSelection = receptionStaff[1]; break;
		        		case 3: receptionSelection = receptionStaff[2]; break;
		        		case 4: receptionSelection = receptionStaff[3]; break;
		        		case 5: receptionSelection = receptionStaff[4]; break;
		        		case 6: receptionSelection = receptionStaff[5]; break;
		        	}
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Termin aufrufen\n2 - Terminuebersicht anzeigen");
						BufferedReader dinreception = new BufferedReader(new InputStreamReader(System.in));
						int numberreception = Integer.parseInt(dinreception.readLine());
						switch (numberreception) {
							case 0: menuhelper = 1; break;
							case 1: // Einzelnen Termin anzeigen
								System.out.println("Geben Sie bitte Ihren Termincode ein");
								String appointmentCodePDF = sc2.nextLine();
								Appointment bookedAppointment = patient0.getAppointmentFromCode(appointmentCodePDF, calendar);
								if (bookedAppointment != null && bookedAppointment.getPatient() != null){
									new PdfCreator().createConfirmationPdf(bookedAppointment);
									System.out.println("Stimmen die Patientendaten ueberein?\n1 - ja\n2 - nein");
									int numberConfirmationPatient = sc2.nextInt();
									if (numberConfirmationPatient == 1) {
										receptionSelection.confirmPatientData(appointmentCodePDF, calendar);
									}
									else {menuhelper = 1;}
								} else if (bookedAppointment != null && bookedAppointment.getPatient() == null){
									System.out.println("Fehler im Termincode.");
								}
								break;
							case 2: // Terminliste als PDF
								receptionSelection.createAppointmentList(numberReceptionStaff -1, calendar);
								break;
						}
        			} while(menuhelper == 0); menuhelper = 0;
        			break;
				case 3: // Arzt
					System.out.println("In welchem Impfzentrum arbeiten Sie");
					System.out.println("1 - "+vaccinationSites[0].getName()+ "\n" + "2 - "+vaccinationSites[1].getName()+ "\n" + "3 - "+vaccinationSites[2].getName()+ "\n" + "4 - "+vaccinationSites[3].getName()+ "\n" + "5 - "+vaccinationSites[4].getName()+ "\n" + "6 - "+vaccinationSites[5].getName());
		        	int numberDoctorStaff = sc.nextInt();
		        	Doctor doctorSelection = new Doctor(null, null, null);
		        	switch (numberDoctorStaff) {
		        		case 1: doctorSelection = doctors[0]; break;
		        		case 2: doctorSelection = doctors[1]; break;
		        		case 3: doctorSelection = doctors[2]; break;
		        		case 4: doctorSelection = doctors[3]; break;
		        		case 5: doctorSelection = doctors[4]; break;
		        		case 6: doctorSelection = doctors[5]; break;
		        	}
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Patient impfen");
						BufferedReader dindoctor = new BufferedReader(new InputStreamReader(System.in));
						int numberdoctor = Integer.parseInt(dindoctor.readLine());
						switch (numberdoctor) {
							case 0: menuhelper = 1; break;
							case 1: // Aufruf setVaccineStatus();
								System.out.println("Geben Sie bitte Ihren Termincode ein");
								String appointmentCodeStatus = sc2.nextLine();
								if (doctor0.getPatientData(appointmentCodeStatus, calendar)) {
									System.out.println("Die Impfung kann jetzt durchgefuehrt werden");
									System.out.println("1 - Impfung abgeschlossen\n2 - Impfung abgebrochen");
									int numberCompletionAppointment = sc2.nextInt();
									if (numberCompletionAppointment == 1) {
										System.out.println("Die Impfung wurde erfolgreich absolviert und der Termin ist abgearbeitet");
										doctorSelection.setVaccineStatus(appointmentCodeStatus, calendar);
									}
									if (numberCompletionAppointment == 2) {
										System.out.println("Die Impfung wurde abgebrochen");
										menuhelper = 1;
									}
								}
								break;
						}
					} while(menuhelper == 0); menuhelper = 0;
					break;
        	}
        } while (menuhelper == 0);
    }
    
    public static Patient setPatientDataInput() {
    	Scanner sc = new Scanner(System.in);
    	Scanner sc2 = new Scanner(System.in); // Boolean und Int nicht kompatibel mit String - Eingabe
    	System.out.println("Eingabe der Patientendaten");
    	System.out.println("Geben Sie bitte ihren Vornamen ein");
    	String firstName = sc.nextLine();
    	System.out.println("Geben Sie bitte ihren Nachnamen ein");
    	String lastName = sc.nextLine();
    	
    	System.out.println("Geben Sie bitte ihr Alter ein");
    	int age = sc2.nextInt();
    	System.out.println("Haben Sie Allergien?");
    	System.out.println("1 - ja"+"\n2 - nein");
    	int numberAllergies = sc2.nextInt();
    	boolean allergies = false;
    	if (numberAllergies == 1) { 
    		allergies = true; 
    	} 
    	if (numberAllergies == 2) {
    		allergies = false;
    	}
    	
    	System.out.println("Geben Sie ihre Postleitzahl ein");
    	String postalCode = sc.nextLine();
    	System.out.println("Geben Sie ihren Wohnort ein");
    	String city = sc.nextLine();
    	System.out.println("Geben Sie ihre Strasse ein");
    	String streetName = sc.nextLine();
    	System.out.println("Geben Sie ihre Strassennummer ein");
    	String streetNo = sc.nextLine();
    	System.out.println("Geben Sie ihre Festnetznummer ein");
    	String telephoneNo = sc.nextLine();
    	System.out.println("Geben Sie ihre Telefonnummer ein");
    	String mobileNo = sc.nextLine();
    	System.out.println("Geben Sie ihre E-Mail ein");
    	String email = sc.nextLine();
    	
    	Address Addr = new Address(streetName, streetNo, postalCode, city);
    	Contact Cont = new Contact(telephoneNo, mobileNo, email);
    	Patient Pat = new Patient(firstName, lastName, Addr, age, Cont, allergies);
    	return Pat;
    }
    
    public static int setVaccineInput(int vaccineCenterNumber, VaccinationSite[] vaccinationSites) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Bitte Impfstoff durch Eingabe der passenden Zahl waehlen");
    	System.out.println("1 - "+vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand());
    	if (vaccinationSites[vaccineCenterNumber].getSecondVaccine() != null) {
    		System.out.println("2 - "+vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand());
    	}
    	int numberVaccine = sc.nextInt();
    	if (numberVaccine == 1) {
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand() == "Pfizer-BioNTech") {return 0;}
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand() == "Moderna") {return 1;}
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand() == "AstraZeneca") {return 2;}
    	}
    	else {
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand() == "Pfizer-BioNTech") {return 0;}
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand() == "Moderna") {return 1;}
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand() == "AstraZeneca") {return 2;}
    	}
		return -1;
    	}
    
    public static int setVaccineCenterInput(VaccinationSite[] vaccinationSites) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Bitte Impfzentrum durch Eingabe der passenden Zahl waehlen");
    	for (int i = 0; i < vaccinationSites.length; i++) {
    		System.out.println(i+1 + " - " + vaccinationSites[i].getName());
    	}
    	int numberVaccine = sc.nextInt();
    	switch (numberVaccine) {
    		case 1: return 0; 
    		case 2: return 1; 
    		case 3: return 2;
    		case 4: return 3; 
    		case 5: return 4; 
    		case 6: return 5;
    	}
    	return -1;
}
}




