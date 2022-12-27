import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="Chandan";
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText()); //To grab the text in alert
		driver.switchTo().alert().accept(); //"Accept" to click on Ok(POSITIVE SELECTION)
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText()); //To grab the text in alert
		driver.switchTo().alert().dismiss(); //"Dismiss" method to click on Cancel(NEGETIVE SELECTION)
		
		

	}

}
