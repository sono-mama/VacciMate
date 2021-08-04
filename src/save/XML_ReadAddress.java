package src.save;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class XML_ReadAddress {

	Document doc = null;
	String streetName = "";
	String streetNo = "";
	String postalCode = "";
	String city = "";

	String[] readOneAddress(String filename, int id) {
		try {
			File addressFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(addressFile);
			XMLOutputter fmt = new XMLOutputter();
	
			Element element = doc.getRootElement();
			
			List allAddresses = (List) element.getChildren();

			List oneAddress = (List) ((Element) allAddresses.get(id)).getChildren();
			
			int j = 0;
			while (j < oneAddress.size()) {
				System.out.print(((Element) oneAddress.get(j)).getName() + ": ");
				System.out.println(((Element) oneAddress.get(j)).getValue());
				j++;
			}
			
			streetName = ((Element) oneAddress.get(0)).getValue();
			streetNo = ((Element) oneAddress.get(1)).getValue();
			postalCode = ((Element) oneAddress.get(2)).getValue();
			city = ((Element) oneAddress.get(3)).getValue();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arr = { streetName, streetNo, postalCode, city }; 
		return arr;

	}

		void readAllAddresses(String filename) {
			try {
				File addressFile = new File(filename);
				SAXBuilder builder = new SAXBuilder();
				doc = builder.build(addressFile);
				XMLOutputter fmt = new XMLOutputter();

				Element element = doc.getRootElement();
	
				List allAddresses = (List) element.getChildren();

				int i = 0;
				while (i < allAddresses.size()) {
			
					List oneAddress = (List) ((Element) allAddresses.get(i)).getChildren();
			
					int j = 0;
					while (j < oneAddress.size()) {
						System.out.print(((Element) oneAddress.get(j)).getName() + ": ");
						System.out.println(((Element) oneAddress.get(j)).getValue());
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
	
	public Document readAddressDocument(String filename) {
		try {
			File AddressFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(AddressFile);
			XMLOutputter fmt = new XMLOutputter();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;

	}
	
}