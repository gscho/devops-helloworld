package com.indellient.talent.devops.helloworld;

import static spark.Spark.get;
import static spark.Spark.port;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {

	public static Properties properties = new Properties();

	static {
		try (FileInputStream fis = new FileInputStream("./application.properties")) {
			properties.load(fis);
		} catch (IOException ioException) {

		}
	}

	public static void main(String[] args) {
		port(Integer.parseInt(properties.getProperty("port")));
		get("/hello", (req, res) -> properties.getProperty("message"));
	}
}