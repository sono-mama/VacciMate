package vaccimate.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XML_WirteContact {

	private final static String DATNAM = "XML_Contact.xml";

	private final static File FILE = new File(DATNAM);

	 Document createDocContact(String rootElementContact) {
		Document docContact = new Document();
		Element rootContact = new Element(rootElementContact);
		docContact.setRootElement(rootContact);
		return docContact;
	}
	
	//Methode zum Erstellen eines Contacts im DOC-Object (Memory)
	void writeDocContact(Document docContact, String telnr, String mobnr, String emailadr) {
		
		Element Contact = new Element ("Contact");
		
		Element telephoneNo = new Element("telephoneNo");
        telephoneNo.setText(telnr);
        Contact.addContent(telephoneNo);
        
        Element mobileNo = new Element("mobileNo");
        mobileNo.setText(mobnr);
        Contact.addContent(mobileNo);
        
        Element email = new Element("email");
        email.setText(emailadr);
        Contact.addContent(email);
        
        docContact.getRootElement().addContent(Contact);
    }
	
	//Methode zum Schreiben der Datei
	void writeXMLContact(Document doc) {
        Format format = Format.getPrettyFormat();
        format.setIndent("    ");
        try (FileOutputStream fos = new FileOutputStream(FILE)) {
            XMLOutputter op = new XMLOutputter(format);
            op.output(doc, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
