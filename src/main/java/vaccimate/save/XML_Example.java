package vaccimate.save;

import org.jdom2.Document;
import org.jdom2.Element;

import java.io.File;

public class XML_Example {
	
	//muss irgendwie in der main ausgeführt werden
	//public static void main(String[] args) {
		
	void TestXML() {
		Document doc = null;
		String ContactFilename = "XML_Contact.xml";
		File f = new File(ContactFilename);
		if(f.exists() && !f.isDirectory()) { 
		    // Ja, existiert, also die gesamte Datei einlesen in doc
			XML_ReadContact read = new XML_ReadContact();
			doc = read.readContactDocument(ContactFilename);
		}
		
		XML_WriteContact contact = new XML_WriteContact();
		
		//kein Inhalt in doc, da Datei nicht vorhanden, also Init XML - Root
		if (doc == null) {
			doc = contact.createDocContact("Contacts");
		}
        
		//add new Contacts
        contact.writeDocContact(doc, "123", "456", "@gmx.de");
        contact.writeDocContact(doc, "321", "654", "@web.de");
        
        //Schreiben der XML-Datei auf Platte
        contact.writeXMLContact(doc);
        
        //Ausgaben
        //der 1. Kontakt
        XML_ReadContact read = new XML_ReadContact();
        String[] oneContact = read.readOneContact(ContactFilename,0);
        System.out.println(oneContact[0]);
        
        //Alle Kontakte
        read.readAllContacts(ContactFilename);
        
        //Die XML files selber sind unter out ganz unten zu finden.
        
        Document doc2 = null;
		String AddressFilename = "XML_Address.xml";
		File f2 = new File(AddressFilename);
		if(f2.exists() && !f2.isDirectory()) { 
			XML_ReadAddress read2 = new XML_ReadAddress();
			doc2 = read2.readAddressDocument(AddressFilename);
		}
		
		XML_WriteAddress address = new XML_WriteAddress();
		
		if (doc2 == null) {
			doc2 = address.createDocAddress("Address");
		}
        
        address.writeDocAddress(doc2,"Hohenzollernstraße", "4", "14109", "Berlin");
        address.writeDocAddress(doc2,"Wrongroad", "16", "90141", "London");
        
        address.writeXMLAddress(doc2);
        
        XML_ReadAddress read2 = new XML_ReadAddress();
        String[] oneAddress = read2.readOneAddress(AddressFilename,0);
        System.out.println(oneAddress[0]);
        
        read2.readAllAddresses(AddressFilename);
        
        
        Document doc3 = null;
		String PatientFilename = "XML_Patient.xml";
		File f3 = new File(PatientFilename);
		if(f3.exists() && !f3.isDirectory()) { 
			XML_ReadPatient read3 = new XML_ReadPatient();
			doc3 = read3.readPatientDocument(PatientFilename);
		}
		
		XML_WritePatient patient = new XML_WritePatient();
		
		if (doc3 == null) {
			doc3 = patient.createDocPatient("Patient");
		}
        
		patient.writeDocPatient(doc3,"Arne", "Bornschein", "1", "18", "true");
		patient.writeDocPatient(doc3,"Joe", "Dawn", "2", "45", "false");
        
		patient.writeXMLPatient(doc3);
        
        XML_ReadPatient read3 = new XML_ReadPatient();
        String[] onePatient = read3.readOnePatient(PatientFilename,0);
        System.out.println(onePatient[0]);
        
        read3.readAllPatients(PatientFilename);
        
        
        Document doc4 = null;
		String AppointmentFilename = "XML_Appointment.xml";
		File f4 = new File(AppointmentFilename);
		if(f4.exists() && !f4.isDirectory()) { 
			XML_ReadAppointment read4 = new XML_ReadAppointment();
			doc4 = read4.readAppointmentDocument(AppointmentFilename);
		}
		
		XML_WriteAppointment Appointment = new XML_WriteAppointment();
		
		if (doc4 == null) {
			doc4 = Appointment.createDocAppointment("Appointment");
		}
        
		Appointment.writeDocAppointment(doc4,"1234", "1.2.2022", "1", "Tegel", "Moderna", "true", "false", "true", "12:45");
		Appointment.writeDocAppointment(doc4,"4321", "7.8.2021", "2", "Schöneberg", "Biotech", "false", "true", "false", "13:30");
        
		Appointment.writeXMLAppointment(doc4);
        
        XML_ReadAppointment read4 = new XML_ReadAppointment();
        String[] oneAppointment = read4.readOneAppointment(AppointmentFilename,0);
        System.out.println(oneAppointment[0]);
        
        read4.readAllAppointments(AppointmentFilename);
        
	}

}
