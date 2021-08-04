package presentationLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import org.jdom2.Document;
import process.*;
import save.*;
import users.Doctor;
import users.Patient;
import users.Reception;
import auxiliary.*;

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
				case 0 -> menuhelper = 1;
				case 1 -> { // Patient
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Termin buchen\n2 - Termin aufrufen");
						BufferedReader dinpatient = new BufferedReader(new InputStreamReader(System.in));
						int numberpatient = Integer.parseInt(dinpatient.readLine());
						switch (numberpatient) {
							case 0 -> menuhelper = 1;
							case 1 -> { // Book appointment, contains asking for patient data, vaccine center choice and vaccine choice
								Patient patient = setPatientDataInput();
								int vaccineCenterNumber = setVaccineCenterInput(vaccinationSites);
								int vaccineNumber = setVaccineInput(vaccineCenterNumber, vaccinationSites);
								boolean eligibility = vaccine0.eligiblityCheck(patient);
								if (eligibility) {

									XML_Return bookedAppointments = patient.setAppointment(vaccineCenterNumber, calendar, patient, vaccineNumber);
									//ohne XML_Return bookedAppointments =

									//Beginn Save

									Document docPatient = null;
									String PatientFilename = "XML_Patient.xml";
									File filePatient = new File(PatientFilename);
									if (filePatient.exists() && !filePatient.isDirectory()) {
										XML_ReadPatient readPatient = new XML_ReadPatient();
										docPatient = readPatient.readPatientDocument(PatientFilename);
									}

									XML_WritePatient Patient = new XML_WritePatient();

									if (docPatient == null) {
										docPatient = Patient.createDocPatient("Patient");
									}

									Patient.writeDocPatient(docPatient,
											patient.getFirstName(),
											patient.getLastName(),
											patient.getId(),
											String.valueOf(patient.getAge()),
											String.valueOf(patient.isAllergies()));
									Patient.writeXMLPatient(docPatient);


									Document docAddress = null;
									String AddressFilename = "XML_Address.xml";
									File fileAddress = new File(AddressFilename);
									if (fileAddress.exists() && !fileAddress.isDirectory()) {
										XML_ReadAddress readAddress = new XML_ReadAddress();
										docAddress = readAddress.readAddressDocument(AddressFilename);
									}

									XML_WriteAddress Address = new XML_WriteAddress();

									if (docAddress == null) {
										docAddress = Address.createDocAddress("Address");
									}

									Address address = patient.getAddress();
									Address.writeDocAddress(docAddress,
											address.getStreetName(),
											address.getStreetNo(),
											address.getPostalCode(),
											address.getCity(),
											patient.getId());
									Address.writeXMLAddress(docAddress);


									Document docContact = null;
									String ContactFilename = "XML_Contact.xml";
									File fileContact = new File(ContactFilename);
									if (fileContact.exists() && !fileContact.isDirectory()) {
										XML_ReadContact readContact = new XML_ReadContact();
										docContact = readContact.readContactDocument(ContactFilename);
									}

									XML_WriteContact Contact = new XML_WriteContact();

									if (docContact == null) {
										docContact = Contact.createDocContact("Contacts");
									}

									Contact contact = patient.getContact();
									Contact.writeDocContact(docContact,
											contact.getTelephoneNo(),
											contact.getMobileNo(),
											contact.getEmail(),
											patient.getId());
									Contact.writeXMLContact(docContact);


									Document docAppointment = null;
									String AppointmentFilename = "XML_Appointment.xml";
									File fileAppointment = new File(AppointmentFilename);
									if (fileAppointment.exists() && !fileAppointment.isDirectory()) {
										XML_ReadAppointment readAppointment = new XML_ReadAppointment();
										docAppointment = readAppointment.readAppointmentDocument(AppointmentFilename);
									}

									XML_WriteAppointment Appointment = new XML_WriteAppointment();

									if (docAppointment == null) {
										docAppointment = Appointment.createDocAppointment("Appointment");
									}

									Appointment.writeDocAppointment(docAppointment,
											String.valueOf(bookedAppointments.getFirst().getCode()),
											String.valueOf(bookedAppointments.getFirst().getDate()),
											String.valueOf(bookedAppointments.getFirst().getPatient().getId()),
											String.valueOf(vaccineCenterNumber),
											bookedAppointments.getFirst().getVaccine(),
											String.valueOf(bookedAppointments.getFirst().isBooked()),
											String.valueOf(bookedAppointments.getFirst().isVaccineGiven()),
											String.valueOf(bookedAppointments.getFirst().isPatientDataChecked()),
											Arrays.toString(bookedAppointments.getFirst().getStartTime()));

									Appointment.writeDocAppointment(docAppointment,
											String.valueOf(bookedAppointments.getSecond().getCode()),
											String.valueOf(bookedAppointments.getSecond().getDate()),
											String.valueOf(bookedAppointments.getSecond().getPatient().getId()),
											String.valueOf(vaccineCenterNumber),
											bookedAppointments.getSecond().getVaccine(),
											String.valueOf(bookedAppointments.getSecond().isBooked()),
											String.valueOf(bookedAppointments.getSecond().isVaccineGiven()),
											String.valueOf(bookedAppointments.getSecond().isPatientDataChecked()),
											Arrays.toString(bookedAppointments.getSecond().getStartTime()));

									Appointment.writeXMLAppointment(docAppointment);

									//End Save

								} else {
									System.out.println("Der Impfstoff ist nicht geeignet");
								}
							}
							case 2 -> { // View appointment, choice of PDF creation or cancelation
								do {
									System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
									System.out.println("0 - zurueck\n1 - Termin stornieren\n2 - Pdf erzeugen");
									int numberShow = sc2.nextInt();
									switch (numberShow) {
										case 0 -> menuhelper = 1;
										case 1 -> { // cancel appointment
											System.out.println("Geben Sie bitte Ihren Termincode ein");
											String appointmentCodeCancel = sc.nextLine();
											patient0.cancelAppointment(appointmentCodeCancel, calendar);
										}
										case 2 -> { // create pdf
											System.out.println("Geben Sie bitte Ihren Termincode ein");
											String appointmentCodePDF = sc.nextLine();
											Appointment bookedAppointment = patient0.getAppointmentFromCode(appointmentCodePDF, calendar);
											if (bookedAppointment != null && bookedAppointment.getPatient() != null) {
												new PdfCreator().createConfirmationPdf(bookedAppointment);
											} else if (bookedAppointment != null) {
												System.out.println("Fehler im Termincode.");
											}
										}
									}
								} while (menuhelper == 0);
								menuhelper = 0;
							}
						}
					} while (menuhelper == 0);
					menuhelper = 0;
				}
				case 2 -> { // reception
					System.out.println("In welchem Impfzentrum arbeiten Sie");
					System.out.println("1 - " + vaccinationSites[0].getName() + "\n" + "2 - " + vaccinationSites[1].getName() + "\n" + "3 - " + vaccinationSites[2].getName() + "\n" + "4 - " + vaccinationSites[3].getName() + "\n" + "5 - " + vaccinationSites[4].getName() + "\n" + "6 - " + vaccinationSites[5].getName());
					int numberReceptionStaff = sc.nextInt();
					new Reception(null, null, null);
					Reception receptionSelection = switch (numberReceptionStaff) {
						case 1 -> receptionStaff[0];
						case 2 -> receptionStaff[1];
						case 3 -> receptionStaff[2];
						case 4 -> receptionStaff[3];
						case 5 -> receptionStaff[4];
						case 6 -> receptionStaff[5];
						default -> new Reception(null, null, null);
					};
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Termin aufrufen\n2 - Terminuebersicht anzeigen");
						BufferedReader dinreception = new BufferedReader(new InputStreamReader(System.in));
						int numberreception = Integer.parseInt(dinreception.readLine());
						switch (numberreception) {
							case 0 -> menuhelper = 1;
							case 1 -> { // show appointment
								System.out.println("Geben Sie bitte Ihren Termincode ein");
								String appointmentCodePDF = sc2.nextLine();
								Appointment bookedAppointment = patient0.getAppointmentFromCode(appointmentCodePDF, calendar);
								if (bookedAppointment != null && bookedAppointment.getPatient() != null) {
									// TO DO: Hier mÃ¼ssen die Patienten Daten auf der Konsole ausgegebe werden.
									Patient bookedPatient = bookedAppointment.getPatient();
									System.out.println("Zu Prüfende Patientendaten");
									System.out.println("Name: "+bookedPatient.getFirstName()+" "+bookedPatient.getLastName());
									System.out.println("Alter: "+bookedPatient.getAge());
									System.out.println("Wohnort: "+ bookedPatient.getAddress().getCity()+", "+bookedPatient.getAddress().getPostalCode());
									System.out.println("Strasse: "+ bookedPatient.getAddress().getStreetName()+" "+ bookedPatient.getAddress().getStreetNo());
									System.out.println("Telefonnummer: " + bookedPatient.getContact().getTelephoneNo() + "\nMobilfunknummer: "+ bookedPatient.getContact().getMobileNo()+ "\nE-Mail: "+ bookedPatient.getContact().getEmail());
									new PdfCreator().createConfirmationPdf(bookedAppointment);
									System.out.println("Stimmen die Patientendaten ueberein?\n1 - ja\n2 - nein");
									int numberConfirmationPatient = sc2.nextInt();
									if (numberConfirmationPatient == 1) {
										receptionSelection.confirmPatientData(appointmentCodePDF, calendar);
									} else {
										menuhelper = 1;
									}
								} else if (bookedAppointment != null) {
									System.out.println("Fehler im Termincode.");
								}
							}
							case 2 -> // appointment list pdf
									receptionSelection.createAppointmentList(numberReceptionStaff - 1, calendar);
						}
					} while (menuhelper == 0);
					menuhelper = 0;
				}
				case 3 -> { // doctor
					System.out.println("In welchem Impfzentrum arbeiten Sie");
					System.out.println("1 - " + vaccinationSites[0].getName() + "\n" + "2 - " + vaccinationSites[1].getName() + "\n" + "3 - " + vaccinationSites[2].getName() + "\n" + "4 - " + vaccinationSites[3].getName() + "\n" + "5 - " + vaccinationSites[4].getName() + "\n" + "6 - " + vaccinationSites[5].getName());
					int numberDoctorStaff = sc.nextInt();
					new Doctor(null, null, null);
					Doctor doctorSelection = switch (numberDoctorStaff) {
						case 1 -> doctors[0];
						case 2 -> doctors[1];
						case 3 -> doctors[2];
						case 4 -> doctors[3];
						case 5 -> doctors[4];
						case 6 -> doctors[5];
						default -> new Doctor(null, null, null);
					};
					do {
						System.out.println("Bitte Funktion durch Eingabe der passenden Zahl waehlen");
						System.out.println("0 - zurueck\n1 - Patient impfen");
						BufferedReader dindoctor = new BufferedReader(new InputStreamReader(System.in));
						int numberdoctor = Integer.parseInt(dindoctor.readLine());
						switch (numberdoctor) {
							case 0 -> menuhelper = 1;
							case 1 -> { // set patient vaccine status
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
							}
						}
					} while (menuhelper == 0);
					menuhelper = 0;
				}
			}
        } while (menuhelper == 0);
    }
    
    public static Patient setPatientDataInput() {
    	Scanner sc = new Scanner(System.in);
    	Scanner sc2 = new Scanner(System.in);
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
    	boolean allergies = numberAllergies == 1;
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
    	System.out.println("Geben Sie ihre Handynummer ein");
    	String mobileNo = sc.nextLine();
    	System.out.println("Geben Sie ihre E-Mail ein");
    	String email = sc.nextLine();
    	
    	Address Addr = new Address(streetName, streetNo, postalCode, city);
    	Contact Cont = new Contact(telephoneNo, mobileNo, email);
    	return new Patient(firstName, lastName, Addr, age, Cont, allergies);
    	
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
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand().equals("Pfizer-BioNTech")) {return 0;}
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand().equals("Moderna")) {return 1;}
    		if (vaccinationSites[vaccineCenterNumber].getFirstVaccine().getBrand().equals("AstraZeneca")) {return 2;}
    	}
    	else {
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand().equals("Pfizer-BioNTech")) {return 0;}
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand().equals("Moderna")) {return 1;}
    		if (vaccinationSites[vaccineCenterNumber].getSecondVaccine().getBrand().equals("AstraZeneca")) {return 2;}
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
		return switch (numberVaccine) {
			case 1 -> 0;
			case 2 -> 1;
			case 3 -> 2;
			case 4 -> 3;
			case 5 -> 4;
			case 6 -> 5;
			default -> -1;
		};
	}
}




