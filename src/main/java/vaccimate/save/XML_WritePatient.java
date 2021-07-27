package vaccimate.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XML_WritePatient {

	private final static String DATNAM = "XML_Patient.xml";

	private final static File FILE = new File(DATNAM);

	 Document createDocPatient(String rootElementPatient) {
		Document docPatient = new Document();
		Element rootPatient = new Element(rootElementPatient);
		docPatient.setRootElement(rootPatient);
		return docPatient;
	}
	
	void writeDocPatient(Document docPatient, String fName, String lName, String uid, String agep, String allergiesp) {
		
		Element Patient = new Element ("Patient");
		
		Element firstName = new Element("firstName");
		firstName.setText(fName);
		Patient.addContent(firstName);
        
        Element lastName = new Element("lastName");
        lastName.setText(lName);
        Patient.addContent(lastName);
        
        Element id = new Element("id");
        id.setText(uid);
        Patient.addContent(id);
        
        Element age = new Element("age");
        age.setText(agep);
        Patient.addContent(age);
        
        Element allergies = new Element("allergies");
        allergies.setText(allergiesp);
        Patient.addContent(allergies);
        
        docPatient.getRootElement().addContent(Patient);
    }
	
	//Methode zum Schreiben der Datei
	void writeXMLPatient(Document doc) {
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
