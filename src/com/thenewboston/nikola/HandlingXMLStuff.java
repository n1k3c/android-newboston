package com.thenewboston.nikola;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandlingXMLStuff extends DefaultHandler{

	XMLDataCollected info = new XMLDataCollected();
	
	public String getInformation(){
		return info.dataToString();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (localName.equals("city")) {
			String city = attributes.getValue("name");
			info.setCity(city);
		} else if (localName.equals("temperature")) {
			String t = attributes.getValue("value");
			// Converting String to Int
			int temp = Integer.parseInt(t);
			info.setTemp(temp);
		}
	}

}
