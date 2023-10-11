
package org.ict.cuscript;

import java.io.IOException;

import org.ict.cupages.Admin;
import org.ict.cupages.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Iterator;
import java.util.Set;

public class TestClassAdmin  extends TestBasecu{
	Admin adm;
	Register reg;
@Test(priority=1)
	
	public void verifyAdminInvalidusername() throws IOException, Throwable  {
		reg=new Register(driver);
		 driver.get("http://143.244.139.123:3001/login");
			String Username="adm";
			String Passwrd="admin123";
		    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Username);
		    String expectedU=Username;
		    WebElement username1=driver.findElement(By.xpath("//input[@type='email']"));
			  String actualUsername=username1.getAttribute("value");
				Assert.assertEquals(actualUsername, expectedU);
			driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(Passwrd);
			 String expectedP=Passwrd;
			  WebElement exp=driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
			  String actualPass=exp.getAttribute("value");
				Assert.assertEquals(actualPass, expectedP);
			
			 
		    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button")).click();

		
	}
@Test(priority=2)

public void verifyAdminInvalidpass() throws IOException, Throwable  {
	reg=new Register(driver);
	 driver.get("http://143.244.139.123:3001/login");
		String Username="admin@org.in";
		String Passwrd="adm123";
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Username);
	    String expectedU=Username;
	    WebElement username1=driver.findElement(By.xpath("//input[@type='email']"));
		  String actualUsername=username1.getAttribute("value");
			Assert.	assertEquals(actualUsername, expectedU);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(Passwrd);
		 String expectedP="admin123";
		  WebElement exp=driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
		  String actualPass=exp.getAttribute("value");
			Assert.assertNotEquals(actualPass, expectedP);
			reg.Loginclick();
		//driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button")).click();

}
/*@Test(priority=3)

public void verifyAdminNullEntry() throws IOException, Throwable  {
	reg=new Register(driver);
	 driver.get("http://143.244.139.123:3001/login");
		String Username="";
		String Passwrd="";
	    driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]")).sendKeys(Passwrd);
	    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button")).click();
}*/
@Test(priority=4)
	
	public void verifyAdminLogin() throws IOException, Throwable  {
		reg=new Register(driver);
		 driver.get("http://143.244.139.123:3001/login");
			String Username="admin@org.in";
			String Passwrd="admin123";
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

@Test(priority=5)

public void verifyCreateForm() throws IOException, Throwable  {
	adm=new Admin(driver);
	 driver.get("http://143.244.139.123:3001/dashboard/requirement-list");
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//button[@class='btn']")).click();
     driver.get("http://143.244.139.123:3001/dashboard/requirement-list/rform");
     driver.findElement(By.xpath("//*[@id=\"requirementName\"]")).sendKeys("ID61");
     driver.findElement(By.xpath("//*[@id=\"trainingArea\"]")).sendKeys("FSD");
     driver.findElement(By.xpath("//*[@id=\"institution\"]")).sendKeys("institution1");
     driver.findElement(By.xpath("//*[@id=\"category\"]")).sendKeys("Govt");
     driver.findElement(By.xpath("//*[@id=\"trainingHours\"]")).sendKeys("51");
     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-requirementform/form/div[6]/input")).sendKeys("C:\\\\my_java\\\\Internship\\\\apple.png");
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	 
    // driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-requirementform/form/button")).click();
     WebElement l=driver.findElement(By.xpath("//button[@type='submit']"));
     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
     Thread.sleep(800);
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     }
@Test(priority=6)

public void verifyAllCurri() throws IOException, Throwable  {
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
         driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-curriculum-list/div/div/div/div[1]/div/a")).click();
       //  Thread.sleep(2000);
     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[2]/div[1]/button[1]")).click();
     driver.findElement(By.xpath("//*[@id=\"Requirement\"]")).sendKeys("2");
     driver.findElement(By.xpath("//*[@id=\"Area\"]")).sendKeys(" Area");
     driver.findElement(By.xpath("//*[@id=\"Institution\"]")).sendKeys(" Institution");
     driver.findElement(By.xpath("//*[@id=\"Category\"]")).sendKeys(" Category");
     driver.findElement(By.xpath("//*[@id=\"Hours\"]")).sendKeys("2");
     driver.findElement(By.xpath("//*[@id=\"s_no\"]")).sendKeys("22");
     driver.findElement(By.xpath(" //*[@id=\"facultyname\"]")).sendKeys("Nair");
     Thread.sleep(1000);
     driver.findElement(By.xpath(" /html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[2]/div[1]/button[2]\r\n"
     		+ "     ")).click();
	 Thread.sleep(1000);
    driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[2]/div[2]/button")).click();
    // Thread.sleep(1000);
}  
@Test(priority=7)

public void verifyDeleteCurri() throws IOException, Throwable  {
	driver.get("http://143.244.139.123:3001/dashboard/curriculum-list");
	   Thread.sleep(2000);
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//*[@id=\"menu\"]/li[2]/a")).click();
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-curriculum-list/div/div/div/div[1]/div/button")).click();
      Thread.sleep(2000);
}
@Test(priority=9)

public void verifyApprovedCurri() throws IOException, Throwable  {
	driver.get("http://143.244.139.123:3001/dashboard/approve");
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
   //  driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/div/ul/li[2]/ul/li[1]/a")).click();
     Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-approve/div/div/ul/li[1]/a")).click();
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[2]/button[1]\r\n"
      		+ " ")).click();
      
      String ParentWindow=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1=s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!ParentWindow.equals(child_window))
			{
				driver.switchTo().window(child_window);
			}
		}
	      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[3]/div/div/div[3]/button[1]")).click();
	     driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys(" abcdefg");
	     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[3]/div/div/div[3]/button[2]")).click();
	
	     driver.switchTo().window(ParentWindow);
      //  driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-approve/div/div/ul/li")).click();
      
}
@Test(priority=10)

public void verifyPendingCurri() throws IOException, Throwable  {
	driver.get("http://143.244.139.123:3001/dashboard/pending");
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/div/ul/li[2]/ul/li[2]/a")).click();
     Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-pending/div/div/ul/li")).click();
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[5]/div/div/h2/button")).click();
      driver.findElement(By.xpath("//*[@id=\"input\"]")).sendKeys("hai");
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[5]/div/div/div/div/form/button")).click();
   
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[2]/app-view/div[2]/div[2]/div[2]/button")).click();
   
}
@Test(priority=11)

public void verifySignout() throws IOException, Throwable  {
	
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
     driver.findElement(By.xpath("/html/body/app-root/app-dashboard/div/div/div[1]/div/div[3]/a")).click();

}
}