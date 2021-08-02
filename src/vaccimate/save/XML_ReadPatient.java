package vaccimate.save;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class XML_ReadPatient {

	Document doc = null;
	String firstName = "";
	String lastName = "";
	String id = "";
	String age = "";
	String allergies = "";

	String[] readOnePatient(String filename, int pid) {
		try {
			File patientFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(patientFile);
			XMLOutputter fmt = new XMLOutputter();
	
			Element element = doc.getRootElement();
			
			List allPatients = (List) element.getChildren();

			List onePatient = (List) ((Element) allPatients.get(pid)).getChildren();
			
			int j = 0;
			while (j < onePatient.size()) {
				System.out.print(((Element) onePatient.get(j)).getName() + ": ");
				System.out.println(((Element) onePatient.get(j)).getValue());
				j++;
			}
			
			firstName = ((Element) onePatient.get(0)).getValue();
			lastName = ((Element) onePatient.get(1)).getValue();
			id = ((Element) onePatient.get(2)).getValue();
			age = ((Element) onePatient.get(3)).getValue();
			allergies = ((Element) onePatient.get(4)).getValue();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arr = { firstName, lastName, id, age, allergies }; 
		return arr;

	}

		void readAllPatients(String filename) {
			try {
				File patientFile = new File(filename);
				SAXBuilder builder = new SAXBuilder();
				doc = builder.build(patientFile);
				XMLOutputter fmt = new XMLOutputter();

				Element element = doc.getRootElement();
	
				List allPatients = (List) element.getChildren();

				int i = 0;
				while (i < allPatients.size()) {
			
					List onePatient = (List) ((Element) allPatients.get(i)).getChildren();
			
					int j = 0;
					while (j < onePatient.size()) {
						System.out.print(((Element) onePatient.get(j)).getName() + ": ");
						System.out.println(((Element) onePatient.get(j)).getValue());
						j++;
					}
					
					i++;
				}
				
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	public Document readPatientDocument(String filename) {
		try {
			File PatientFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(PatientFile);
			XMLOutputter fmt = new XMLOutputter();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;

	}
	
}