import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Invoking chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver3\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		//To wait for something which is not there in existing page
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//To solve syncing problem in No.4, 
		driver1.get("https://rahulshettyacademy.com/locatorspractice/");
		
		
		//1.Find the element on the page with ID locator(Username)
		driver1.findElement(By.id("inputUsername")).sendKeys("Chandan");//Sending some inputs to the field using.sendkeys)
		
		//2.Find the element on the page with NAME locator(Password)
		driver1.findElement(By.name("inputPassword")).sendKeys("123344");//Sending some inputs to the field using.sendkeys)		
		
		//3.Find the element on the page with CLASS NAME locator(SignIn)
		driver1.findElement(By.className("signInBtn")).click(); //Clicking SignIn using .click()
		
		//4. CSS(When we don't have CLASS NAME or ID in HTML)(Error message) - Tagname.classname ------------------
		System.out.println(driver1.findElement(By.cssSelector("p.error")).getText()); //Getting the text using .getText()
		
		//5. Link Text locator(Forgot password)
		driver1.findElement(By.linkText("Forgot your password?")).click();
		
		//Two pop ups(SignIn page and Forgot password page) are overlapping to avoid that we are delaying 2nd pop up using Thread(Java)
		Thread.sleep(1000);//Not recommended use EXPLICIT
		
		//6. XPATH - (For name field)- //Tagname[@attribute=’value’] ---------------------------------------------
		driver1.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Chandan");
		
		//4.1 CSS(Another way) - (For Email field)- Tagname[attribute=’value’] ------------------------------
		driver1.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("12345678");
		
		//To clear the entered values in EMail field Tagname[attribute=’value’] ----------------------------
		driver1.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		//When we don't have unique attributes we can use index - Eg: input[@type='text']index[2]
		//Generally there will be many attributes stating "TYPE" to specify one we wanted,we use index - index[1],index[2]---------------
		                               //Tagname[@attribute=’static value’][index]
        driver1.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("chn@1996"); 
        
        //In CSS we can't use index
                                           //Tagname[@attribute=’value’]:nth-child(index)
        //driver1.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear(); -------------------
        
        //When there are no attributes, no classname, no ID, etc.. we use Tag names X-path_Parent - child
                                       //parentTagname/childTagname -------------------------------------------
        driver1.findElement(By.xpath("//form/input[3]")).sendKeys("7411951102");
        
        //Reset login button
        driver1.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        
        //Grabbing error text - Using Parent-child Parenttagname childtagname
        System.out.println(driver1.findElement(By.cssSelector("form p")).getText());
        
        //Got-to-Login button - Using Parent-child -3 combinations
        driver1.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/Button[1]")).click();
        
       //Two pop ups(SignIn page and Forgot password page) are overlapping to avoid that we are delaying 2nd pop up using Thread(Java)
      	Thread.sleep(1000);
        
        //Signing in with proper credentials 
        //USERNAME - Using CSS
        driver1.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        
        //PASSWORD - We can identify the elements using the partial text also with help of star "*" - CSS
        driver1.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        
        //CHECKBOXES
        driver1.findElement(By.id("chkboxOne")).click();
        driver1.findElement(By.id("chkboxTwo")).click();
        
        //SignIn - We can identify the elements using the partial text - XPATH
        driver1.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
                
        
	}

}

