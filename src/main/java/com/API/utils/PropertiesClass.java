package com.API.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	public static Properties fileConfig(String path) throws IOException {

		File file = new File(path);
		FileReader reader = new FileReader(file);
		Properties props = new Properties();
		props.load(reader);

		return props;

	}

}
