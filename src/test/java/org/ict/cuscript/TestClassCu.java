package org.ict.cuscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.ict.cupages.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
public class TestClassCu extends TestBasecu{
	Register reg;
	
@Test(priority=1)
	
	public void verifyPageRedirection() throws IOException, Throwable  {
		reg=new Register(driver);
	    String url=driver.getCurrentUrl();
		String expectedUrl="http://143.244.139.123:3001/";
		Assert.assertEquals(url, expectedUrl);

	}

@Test(priority=2)

public void verifyValidSignup() throws IOException, Throwable  {
	 //driver= new EdgeDriver();
	 driver.get("http://143.244.139.123:3001/signup");
	 //driver.manage().window().maximize();

	reg=new Register(driver);
	String Username="dini";
	String Phno="1234567890";
	String mail="dini@gmail.com";
	String Passwrd="dini1234";
	String CPasswrd="dini1234";
	reg.setUsername(Username);
    WebElement username1 =driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[1]/input"));
	String expected=Username;
	String actualUsername=username1.getAttribute("value");
	Assert.assertEquals(actualUsername, expected);

	reg.setMail(mail);
	WebElement mail1 =driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[2]/input"));
	String expectedMail=mail;
	String actualMail=mail1.getAttribute("value");
	Assert.assertEquals(actualMail, expectedMail);
	
	reg.setPhno(Phno);	
	WebElement ph =driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[3]/input"));
    String expectedPh=Phno;
	String actualPh=ph.getAttribute("value");
	Assert.assertEquals(actualPh, expectedPh);
	
	reg.setPass(Passwrd);
	WebElement pass1 =driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[4]/input"));
	String expectedPass=Passwrd;
	String actualPass=pass1.getAttribute("value");
	Assert.assertEquals(actualPass, expectedPass);
	
	reg.setCpass(CPasswrd);
	WebElement CPassd1 =driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[5]/input"));
	String expectedCPass=CPasswrd;
	String actualCPass=CPassd1.getAttribute("value");
	Assert.assertEquals(actualCPass, expectedCPass);
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);	
	   WebElement l=driver.findElement(By.xpath("//button[@type='submit']"));
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	     Thread.sleep(800);
	     driver.findElement(By.xpath("//button[@type='submit']")).click();
	     Thread.sleep(1000);
	     
}

@Test(priority=3)

public void verifyValidLogin() throws IOException, Throwable  {
	 driver.get("http://143.244.139.123:3001/login");
	reg=new Register(driver);
	String Username="dini@gmail.com";
	String Passwrd="dini1234";
	reg.loginUsername(Username);
    WebElement username1 =driver.findElement(By.xpath("//input[@type='email']"));
	String expected=Username;
	String actualUsername=username1.getAttribute("value");
	Assert.assertEquals(actualUsername, expected);
	
	reg.loginPass(Passwrd);
	WebElement pass1 =driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
	String expectedPass=Passwrd;
	String actualPass=pass1.getAttribute("value");
	Assert.assertEquals(actualPass, expectedPass);
	reg.Loginclick();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div/div/div[6]/button[1]")).click();
}

@Test(priority=4)

public void verifyMycurriculum() throws IOException, Throwable  {
	//driver.get("http://143.244.139.123:3001/faculty-dashboard/my-curriculums");
    driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a/span")).click();
    Thread.sleep(1000);
    WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-my-curriculums/div/div/div/div[2]/div/a"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	Thread.sleep(800);
    driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-my-curriculums/div/div/div/div[2]/div/a")).click();
    driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-curriculum-view/div[2]/button[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"s_no\"]")).sendKeys("1");
   // driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);	
	   WebElement l2=driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-curriculum-view/div[2]/button[2]"));
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l2);
	     Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-curriculum-view/div[2]/button[2]")).click();
    
}

@Test(priority=5)

public void verifySearch() throws IOException, Throwable  {
	
	driver.get("http://143.244.139.123:3001/faculty-dashboard/Rformfaculty");
    driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-rform-faculty/div[1]/input")).sendKeys("ID1001");
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-rform-faculty/div[2]/div/div[1]/div/a/div/h6[1]\r\n"
    		+ "")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(" /html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-create-curriculums/div/div[1]/div[2]/app-requirements/div/div/div/div/a\r\n"
    		+ " 	")).click();
	driver.findElement(By.xpath("//*[@id=\"curriculum_id\"]")).sendKeys("111");
	driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("abcd efgh ijkl mnop");
	driver.findElement(By.xpath("//*[@id=\"inputGroupFile03\"]")).sendKeys("C:\\my_java\\Internship\\apple.png");
	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	   WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-create-curriculums/div/div[1]/div[2]/app-details/div/div/div/form/div[5]/button"));
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	     Thread.sleep(800);
	driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-create-curriculums/div/div[1]/div[2]/app-details/div/div/div/form/div[5]/button")).click();
	//driver.findElement(By.cssSelector("div.row.col-3.card.a:first-of-type")).click();
 	//driver.findElement(By.cssSelector("//div[@class='col-3']//*[@class='card']")).click();
	//driver.findElement(By.cssSelector("div.card > div:nth-child(1)")).click();
	//driver.findElement(By.xpath("//*[contains(@class,'card')]/a)[1]")).click();

//driver.findElement(By.xpath("/html/body/app-root/app-faculty-dashboard/div/div/div[2]/app-rform-faculty/div[2]/div/div/div/a")).click();
 }


@Test(priority=6)

public void verifySignout() throws IOException, Throwable  {
	
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	 WebElement l=driver.findElement(By.xpath("//i[@class='bi bi-box-arrow-left']"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("//i[@class='bi bi-box-arrow-left']")).click();

}

@Test(priority=7)

public void verifyMembership() throws IOException, Throwable  {
    
     driver.get("http://143.244.139.123:3001/");
     WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[1]"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[1]")).click();

}
@Test(priority=8)

public void verifyPartership() throws IOException, Throwable  {
    
     driver.get("http://143.244.139.123:3001/");
     WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[2]"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[2]")).click();
}
@Test(priority=9)

public void verifyProjects() throws IOException, Throwable  {
    
     driver.get("http://143.244.139.123:3001/");
     WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[3]"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[3]")).click();
}
@Test(priority=8)

public void verifyService() throws IOException, Throwable  {
    
     driver.get("http://143.244.139.123:3001/");
     WebElement l=driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[4]"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("/html/body/app-root/app-home/app-footer/div[1]/div/div[2]/div[3]/div/a[4]")).click();
}

}