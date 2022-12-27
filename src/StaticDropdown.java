import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Dropdown with Select Tag(STATIC DROPDOWNS)
		// Creating an object for class SELECT(DROPDOWN is object)
		// We have to tell where exactly the SELECT dropdown is present - Like an
		// address

		Thread.sleep(2000L);

		WebElement Staticdropdown = driver1.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		// We got the web element in a variable insert it in SELECT()
		Select dropdown = new Select(Staticdropdown);
		dropdown.selectByIndex(3); // Selecting an option using index, SELECT class have methods to select an
									// option

		// To know which option has been selected in the script(Console)
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Selecting the option based on the visible text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Selecting the option based on the visible text
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

	}

}
