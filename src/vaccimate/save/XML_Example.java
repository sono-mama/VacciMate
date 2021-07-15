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
			XML_Read read = new XML_Read();
			doc = read.readContactDocument(ContactFilename);
		}
		
		XML_Contact contact = new XML_Contact();
		
		//kein Inhalt in doc, da Datei nicht vorhanden, also Init XML - Root
		if (doc == null) {
			doc = contact.createDocContact("Contacts");
		}
        
		//add new Contacts
        contact.writeDocContact(doc, "123", "456", "@gmx.de");
        contact.writeDocContact(doc, "321", "654", "@web.de");
        
        //Schreiben der XML-Datei auf Platte
        contact.writeXMLContact(doc);
        
        //XML_Address address = new XML_Address();
        //Document doc2 = address.createDocAddress("Addresses");
        //address.writeDocAddress(doc2);
        //address.writeXMLAddress(doc2);
        
        //Ausgaben
        //der 1. Kontakt
        XML_Read read = new XML_Read();
        String[] oneContact = read.readOneContact(ContactFilename,0);
        System.out.println(oneContact[0]);
        
        //Alle Kontakte
        read.readAllContacts(ContactFilename);
        
	}

}
