package com.venky.Rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Testproperties {

	public static void main(String[] args) throws IOException {
		
		
   // System.out.println(  System.getProperty("user.dir"));
		
		Properties config=new Properties();
		Properties or=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		System.out.println(config.getProperty("browser"));
		fis=new FileInputStream( System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
     	or.load(fis);
		System.out.println(or.getProperty("bankbtn"));
	}

}
