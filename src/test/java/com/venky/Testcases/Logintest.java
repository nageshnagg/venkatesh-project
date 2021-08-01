package com.venky.Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.venky.Base.Testbase;

public class Logintest extends Testbase{
	
	
	@Test
	public void LoginAsBankmanger() throws InterruptedException {
		
		
		driver.findElement(By.xpath(or.getProperty("bankbtn"))).click();
		Thread.sleep(3000);
		log.debug("Excuted login@@@@@@@@@@");
	}

}
