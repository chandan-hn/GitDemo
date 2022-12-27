import org.openqa.selenium.By;                                 //ASSERTIONS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//System.out.println(driver1.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //To know whether the checkbox is being selected
		Assert.assertFalse(driver1.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //Above step using ASSERTIONS
		
		//To click on Family and Friends check box
		driver1.findElement(By.cssSelector("input[id*='friendsandfamily']")).click(); 
		
		//System.out.println(driver1.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //To know whether the checkbox is being selected
		Assert.assertTrue(driver1.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //Above step using ASSERTIONS
		
		//To get the count of all checkboxes in the page
		//Size method will give the size of the find element which is count of checkboxes 
		System.out.println(driver1.findElements(By.cssSelector("input[type='checkbox']")).size()); 
		
        driver1.findElement(By.id("divpaxinfo")).click(); //To Click Passengers dropdown
		//System.out.println(driver1.findElement(By.id("divpaxinfo")).getText()); //To get the text of How many adults are selected
        Assert.assertEquals(driver1.findElement(By.id("divpaxinfo")).getText(), "1 Adult"); //Above step using ASSERTIONS
		
		Thread.sleep(2000L);
		//If we want to select multiple number of adults we have to use While/For loop
		int i=1;
		while(i<5) //To click 4 adults(1,2,3,4....)
		{
			driver1.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver1.findElement(By.id("btnclosepaxoption")).click(); //Clicking on Done button
		//System.out.println(driver1.findElement(By.id("divpaxinfo")).getText()); //To get the text of How many adults are selected
		Assert.assertEquals(driver1.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); //Above step using ASSERTIONS
	}

}
