import java.util.Arrays;
import java.util.List;                                    //Same code as Products.java but using Methods
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {                                    

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //IMPLICIT WAIT
		WebDriverWait w= new WebDriverWait(driver,5); //EXPLICIT WAIT declaration
		
		String[] items = {"Cucumber","Beetroot","Cauliflower","Orange"}; 
		Additems(driver,items); //Adding Driver and Array
		
		//Create Object of the Class
		//Synchronization s=new Synchronization();    //To access any method we need to create the object of the class
		//s.Additems(driver, items);         //If we use static in method then no need of these 2 steps
		
		driver.findElement(By.cssSelector("img[alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click(); //Here the text "PROCEED TO CHECKOUT", we can use text
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class=\"promoCode\"]"))); //EXPLICIT WAIT
		driver.findElement(By.cssSelector("input[class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button[class=\"promoBtn\"]")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // visibilityOfElementLocated - Commonly used explicit method
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		

}
public static void Additems(WebDriver driver,String[] items) //Adding Driver and Array
{
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); 
	int j=0;
	
	for(int i=0;i<products.size();i++)  
	{
		String[] name = products.get(i).getText().split("-"); 
		String formattednames = name[0].trim(); 
		List itemslist = Arrays.asList(items); 
		
		if(itemslist.contains(formattednames))
		{
			j++;
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			
			if(j++ == items.length)
			{
				break; 
			}
		}
		
		}
	}
}
	

