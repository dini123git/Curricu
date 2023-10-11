package org.ict.cuscript;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestBasecu {
	WebDriver driver;
	 @BeforeTest
	 public void setUp() {
		 driver=new FirefoxDriver();
		// driver=new  EdgeDriver();
		 driver.get("http://143.244.139.123:3001/");
		 driver.manage().window().maximize();
	
	 }

}
