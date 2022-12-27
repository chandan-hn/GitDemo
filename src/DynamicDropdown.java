import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver1.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click(); //Clicking on FROM dropdown
		driver1.findElement(By.xpath("//a[@value='BLR']")).click(); //Selecting Bengaluru option in that dropdown
		Thread.sleep(2000L);
		//driver1.findElement(By.xpath("(//a[@value='HBX'])[2]")).click();//Selecting Hubli option in that||| Use () and [2]  for selecting Hubli in TO dropdown
		
		//Some Automation leads dont like Indexes, so another way is Parent-Child method
		driver1.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HBX']")).click();
		
		
		

	}

}
