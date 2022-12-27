import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver1.findElement(By.id("divpaxinfo")).click(); //To Click Passengers dropdown
		
		System.out.println(driver1.findElement(By.id("divpaxinfo")).getText()); //To get the text of How many adults are selected
		
		Thread.sleep(2000L);
		//If we want to select multiple number of adults we have to use While/For loop
		int i=1;
		while(i<5) //To click 4 adults(1,2,3,4....)
		{
			driver1.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver1.findElement(By.id("btnclosepaxoption")).click(); //Clicking on Done button
		
		System.out.println(driver1.findElement(By.id("divpaxinfo")).getText()); //To get the text of How many adults are selected
		
	}

}
