import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		//Invoking chrome browser
				System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver.exe");
				WebDriver driver1=new ChromeDriver();
				
				String name = "chandan"; //Because username is dynamic, text vary based on username
				
				driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				String password = getpassword(driver1);   //CALLING THE GET PASSWORD METHOD
				
				driver1.get("https://rahulshettyacademy.com/locatorspractice/");
				driver1.findElement(By.id("inputUsername")).sendKeys(name);//name - String dynamic
				driver1.findElement(By.name("inputPassword")).sendKeys(password);	
				driver1.findElement(By.className("signInBtn")).click(); 
				Thread.sleep(1000);
				System.out.println(driver1.findElement(By.tagName("p")).getText()); //Not recommended as we will have multiple Tag names in a page
				
				//Assertions for text related validations
                Assert.assertEquals(driver1.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
                
                //Assertions - If test is dynamic(Eg: "Welcome Chandan(UN)" or "Welcome Gowda(UN)")
               //Create a String variable "name" (Step15,19)
                Assert.assertEquals(driver1.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+","); 
                driver1.findElement(By.xpath("//button[text()='Log Out']")).click();
                //driver1.close();
                
	}
	
	//Creating the methods to grab temp pw -rahulshettyacademy   (REFER NOTES)
	//This method doesn't know who is driver1, so send "driver1 variable" as an input to "getpassword" method
	public static String getpassword(WebDriver driver1) throws InterruptedException
	{
		driver1.get("https://rahulshettyacademy.com/locatorspractice/");
		driver1.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver1.findElement(By.cssSelector("button.reset-pwd-btn")).click();//Reset login button
        String passwordText = driver1.findElement(By.cssSelector("form p")).getText();//Extracting text and pushing into variable(pwdtext)
        
        //We want only "rahulshettyacademy" from "Please use temporary password 'rahulshettyacademy' to Login"
        //So we will use "split" method
        //0th index - Please use temporary password (ARRAY) 
        //1st index - 'rahulshettyacademy' to Login
        String[] passwordArray = passwordText.split("'");
        String[] passwordArray2 = passwordArray[1].split("'");
        String password = passwordArray2[0];
        		return password;
	}
}
	
	

