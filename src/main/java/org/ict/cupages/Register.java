package org.ict.cupages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Register {
	WebDriver driver ;
	private WebElement username,phno,mail,passw,cpassw,reg1;

public Register(WebDriver driver) {
	
	this.driver=driver;
}
public void setUsername(String setUser) {
	username=driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[1]/input"));
	username.sendKeys(setUser);
}
public void setPhno(String setPh) {
	phno=driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[3]/input"));
	phno.sendKeys(setPh);
}
/*public void setPhno1(String setPh) {
	phno=driver.findElement(By.xpath("//input[@type='text' and @formcontrolname='phone']"));
	phno.sendKeys(String.valueOf(setPh));
}*/
public void setMail(String setMails) {
	mail=driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[2]/input"));
	mail.sendKeys(setMails);
}
public void setPass(String setPassw) {
	passw=driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[4]/input"));
	passw.sendKeys(setPassw);
}
public void setCpass(String setCpassw) {
	cpassw=driver.findElement(By.xpath("/html/body/app-root/app-signup/div/div/form/div[5]/input"));
	cpassw.sendKeys(setCpassw);
}
public void Registerclick() {
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);	
driver.findElement(By.cssSelector("//button[@type='submit']")).click();

}
public void loginUsername(String setUser) {
	username=driver.findElement(By.xpath("//input[@type='email']"));
	username.sendKeys(setUser);
}
public void loginPass(String setPassw) {
	passw=driver.findElement(By.xpath("//*[@id=\"exampleInputPassword1\"]"));
	passw.sendKeys(setPassw);
}
public void Loginclick() {
	 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
reg1=driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button"));
reg1.click();
}
}
