package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import baseTest.ConstantData;

public class ReadDataPropertiesFile implements ConstantData {

	FileInputStream fis;
	Properties pobj;
	FileOutputStream fio;

	public String readData(String key) {
		try {
			fis = new FileInputStream(propertiespath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		pobj = new Properties();

		try {
			pobj.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String data = pobj.getProperty(key);
		return data;

	}

}
