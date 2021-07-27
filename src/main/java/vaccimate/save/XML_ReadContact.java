package vaccimate.save;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

class XML_ReadContact {

	Document doc = null;
	String telephoneNo = "";
	String mobileNo = "";
	String email = "";

	//Methode zum Lesen eines Contacts
	String[] readOneContact(String filename, int id) {
		try {
			File contactFile = new File(filename);
			// Das Dokument erstellen
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(contactFile);
			XMLOutputter fmt = new XMLOutputter();

			// komplettes Dokument ausgeben
			// debug only
			// fmt.output(doc, System.out);

			// Wurzelelement ausgeben
			Element element = doc.getRootElement();
			// System.out.println("\nWurzelelement: " + element);

			// Wurzelelementnamen ausgeben
			// System.out.println("Wurzelelementname: " + element.getName());

			// Eine Liste aller direkten Kindelemente eines Elementes erstellen
			// ein Kind ist hier <contact>
			List allContacts = (List) element.getChildren();

			// das "id-te" Elemnent
			List oneContact = (List) ((Element) allContacts.get(id)).getChildren();
			// System.out.println(oneContact);

			// die Datenzeile
			int j = 0;
			while (j < oneContact.size()) {
				System.out.print(((Element) oneContact.get(j)).getName() + ": ");
				System.out.println(((Element) oneContact.get(j)).getValue());
				j++;
			}
			
			// die Telefonnummer des Contacts
			telephoneNo = ((Element) oneContact.get(0)).getValue();
			// System.out.println(telephoneNo);
			mobileNo = ((Element) oneContact.get(1)).getValue();
			email = ((Element) oneContact.get(2)).getValue();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arr = { telephoneNo, mobileNo, email }; // initializing array
		return arr;

	}

	
	//Methode zum Lesen aller Contacts
		void readAllContacts(String filename) {
			try {
				File contactFile = new File(filename);
				// Das Dokument erstellen
				SAXBuilder builder = new SAXBuilder();
				doc = builder.build(contactFile);
				XMLOutputter fmt = new XMLOutputter();

				// komplettes Dokument ausgeben
				// debug only
				// fmt.output(doc, System.out);

				// Wurzelelement ausgeben
				Element element = doc.getRootElement();
				// System.out.println("\nWurzelelement: " + element);

				// Wurzelelementnamen ausgeben
				// System.out.println("Wurzelelementname: " + element.getName());

				// Eine Liste aller direkten Kindelemente eines Elementes erstellen
				// ein Kind ist hier <contact>
				List allContacts = (List) element.getChildren();

				
				// alle Kontakte
				int i = 0;
				while (i < allContacts.size()) {
				    //ein Kontakt
					List oneContact = (List) ((Element) allContacts.get(i)).getChildren();
				    //System.out.println(oneContact);
				    
					int j = 0;
					while (j < oneContact.size()) {
						System.out.print(((Element) oneContact.get(j)).getName() + ": ");
						System.out.println(((Element) oneContact.get(j)).getValue());
						j++;
					}
					
					i++;
					//Rückgabe noch offen
					// die Telefonnummer des Contacts
					//telephoneNo = ((Element) oneContact.get(0)).getValue();
					// System.out.println(telephoneNo);
					//mobileNo = ((Element) oneContact.get(1)).getValue();
					//email = ((Element) oneContact.get(2)).getValue();
				}
				

			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Rückgabe noch offen
			//String[] arr = { telephoneNo, mobileNo, email }; // initializing array
			//return arr;

		}
	
		
	//Methode Lesen der Datei und erstellen doc-Object
	Document readContactDocument(String filename) {
		try {
			File contactFile = new File(filename);
			// Das Dokument erstellen
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(contactFile);
			XMLOutputter fmt = new XMLOutputter();

			// komplettes Dokument ausgeben
			// debug only
			// fmt.output(doc, System.out);


		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;

	}
	
	
}