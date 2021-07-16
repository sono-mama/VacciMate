package vaccimate.save;

import org.jdom2.Document;
import org.jdom2.Element;

import java.io.File;

public class XML_Example {

	public static void main(String[] args) {
		
		Document doc = null;
		String ContactFilename = "XML_Contact.xml";
		File f = new File(ContactFilename);
		if(f.exists() && !f.isDirectory()) { 
		    // Ja, existiert, also die gesamte Datei einlesen in doc
			XML_ReadContact read = new XML_ReadContact();
			doc = read.readContactDocument(ContactFilename);
		}
		
		XML_WirteContact contact = new XML_WirteContact();
		
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
        
        
        Document doc2 = null;
		String AddressFilename = "XML_Address.xml";
		File f2 = new File(AddressFilename);
		if(f2.exists() && !f2.isDirectory()) { 
			XML_ReadAddress read2 = new XML_ReadAddress();
			doc2 = read2.readAddressDocument(AddressFilename);
		}
		
		XML_WirteAddress address = new XML_WirteAddress();
		
		if (doc2 == null) {
			doc2 = address.createDocAddress("Address");
		}
        
        address.writeDocAddress(doc2,"Hohenzollernstraﬂe", "4", "14109", "Berlin");
        address.writeDocAddress(doc2,"Wrongroad", "16", "90141", "London");
        
        address.writeXMLContact(doc2);
        
        XML_ReadAddress read2 = new XML_ReadAddress();
        String[] oneAddress = read2.readOneAddress(AddressFilename,0);
        System.out.println(oneAddress[0]);
        
        read2.readAllAddresses(AddressFilename);
        
	}

}
