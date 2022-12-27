import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Traversing from Sibling to Sibling
		System.out.println(driver1.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//Traversing from Child to Parent
		System.out.println(driver1.findElement(By.xpath("//header/div/button[1]/parent::div/button[3]")).getText());

	}

}
