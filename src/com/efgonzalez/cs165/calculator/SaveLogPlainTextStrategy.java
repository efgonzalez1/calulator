package com.efgonzalez.cs165.calculator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class SaveLogPlainTextStrategy implements SaveLogStrategy {

	@Override
	public void save(ArrayList<String> log) {
		// Create new plain text file
		File f = new File("Calculator Log [TXT].txt");
		try {
			// Write log to file
			FileUtils.writeLines(f, "unicode", log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
