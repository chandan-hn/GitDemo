import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String name = "rahul";
		String password = getTempPw(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.findElement(By.cssSelector(".logout-btn")).click();
	
	}
	public static String getTempPw(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector(".forgot-pwd-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String tempText = driver.findElement(By.cssSelector(".infoMsg")).getText();
		
		String[] splitText1 = tempText.split("'");
		String[] splitText2 = splitText1[1].split("'");
		String tempPassword = splitText2[0];
		return tempPassword;
	}

}
