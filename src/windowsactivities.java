import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowsactivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();
		//To run the window in maximised mode
		driver1.manage().window().maximize();
		driver1.get("https://www.google.co.in/");
		//To navigate to another Web page from current window
		driver1.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		//To navigate back to previous Web page
		driver1.navigate().back();
		driver1.navigate().forward();
		

	}

}
