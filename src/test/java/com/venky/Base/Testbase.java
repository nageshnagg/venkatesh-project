package com.venky.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Testbase {

	/*
	 * webdriver------------d0ne properties..............done
	 * logs..................... add log4j jar,.log flie like
	 * aplication.log,selinium.logs,......log4j properties provides by
	 * apache,,,loglerclass calling extent reports..............
	 * db....................... excell...................
	 * mail,,,,,,,,,,,,,,,,,,,,,,, testng...................
	 * jenkins.....................
	 * 
	 * 
	 * 
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setup() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis);
				log.debug("config file is loaded");

				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Or.properties");
				or.load(fis);
				log.debug("or file is loaded");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("Mozilla")) {
				// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
				// System.setProperty("WebDriver.", null)
				driver = new ChromeDriver();
				log.debug("chome browser loaded");
			} else if (config.getProperty("browser").equals("Edge")) {
				// System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.get(config.getProperty("url"));
			log.debug("Navigation:" + config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}
	}

	@AfterSuite
	public void teardown() {

		if (driver != null)
			driver.quit();
		log.debug("login exceuton completed");
	}

}
