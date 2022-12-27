import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locatorspractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Invoking chrome browser
		System.setProperty("webdriver.gecko.driver", "C:\\Gecko Driver2/geckodriver.exe");

		WebDriver driver2 = new FirefoxDriver();
		//driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver2.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver2.findElement(By.xpath("//form/h1")).getText());
		driver2.findElement(By.id("visitUsTwo")).click();
		driver2.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Rahul shetty");
				
				
	}

}
