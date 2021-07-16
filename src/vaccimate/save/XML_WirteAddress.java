package vaccimate.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XML_WirteAddress {

	private final static String DATNAM = "XML_Address.xml";

	private final static File FILE = new File(DATNAM);

	 Document createDocAddress(String rootElementAddress) {
		Document docAddress = new Document();
		Element rootAddress = new Element(rootElementAddress);
		docAddress.setRootElement(rootAddress);
		return docAddress;
	}
	
	void writeDocAddress(Document docAddress, String strName, String strNo, String postCode, String ci) {
		
		Element Address = new Element ("Address");
		
		Element streetName = new Element("streetName");
		streetName.setText(strName);
        Address.addContent(streetName);
        
        Element streetNo = new Element("streetNo");
        streetNo.setText(strNo);
        Address.addContent(streetNo);
        
        Element postalCode = new Element("postalCode");
        postalCode.setText(postCode);
        Address.addContent(postalCode);
        
        Element city = new Element("city");
        city.setText(ci);
        Address.addContent(city);
        
        docAddress.getRootElement().addContent(Address);
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
