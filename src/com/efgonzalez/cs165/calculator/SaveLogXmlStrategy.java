package com.efgonzalez.cs165.calculator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class SaveLogXmlStrategy implements SaveLogStrategy {

	@Override
	public void save(ArrayList<String> log) {
		// Create new XML file
		File f = new File("Calculator Log [XML].xml");
		// Convert raw log to XML
		ArrayList<String> xml = convertToXml(log);
		try {
			// Write converted log to file
			FileUtils.writeLines(f, "unicode", xml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> convertToXml(ArrayList<String> a){
		// Create new array list to hold the XML version of the log 
		ArrayList<String> xml = new ArrayList<String>();
		// Add opening parent tag
		xml.add("<Calculator-Log>");
		// Iterate through raw log and convert
		for (int i = 0; i < a.size(); i++) {
			String temp = a.get(i);
			// Separate tag from value
			String parts[] = temp.split(":");
			// Convert tag spaces to dashes and remove leading spaces from value
			parts[0] = parts[0].replace(' ', '-');
			parts[1] = parts[1].trim();
			// Use sb to build XML tags
			StringBuilder sb = new StringBuilder();
			sb.append("\t<");
			sb.append(parts[0]);
			sb.append(">");
			sb.append(parts[1]);
			sb.append("</");
			sb.append(parts[0]);
			sb.append(">");
			// Load completed entry into XML log
			xml.add(sb.toString());
		}
		// Add closing parent tag
		xml.add("</Calculator-Log>");
		return xml;
	}

}
