import java.util.List;                               //VIDEO NUMBER 56

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;              

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver1.findElement(By.id("autosuggest")).sendKeys("ind"); //Order will change based on the input
		Thread.sleep(3000L);
		
		// Grab all the options(British Indian territory, India, Indonesia) which comes after entering the input(ind) using Xpath or CSS
		//Return type of FindelementS is list of web elements, Catching that web element into one variable 
		List<WebElement> options= driver1.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //Extracting all the options using FindelementS
		
		//Iterating over each and every option and seeing if it is matching our input(ind) using FOR LOOP
		//Enhanced for loop - In option there are n number of elements, getting the 1 option each time, every time the loop iterates it will pick 1 option
		//That option will store in the variable(OPTION), the return type of that option is Web element
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click(); 
				break;
			}
			  
		}
		
		

	}

}
