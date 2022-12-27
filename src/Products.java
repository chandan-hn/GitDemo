import java.util.Arrays;
import java.util.List;                                    //SECTION 8(Amazon Interview Question)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Products {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Chrome Driver2\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		int j=0;  //Using "J" because we are only extracting 2 items, there is no need to execute all 30 items in iteration
		
		//To click on Multiple products using Arrays
		String[] items = {"Cucumber","Beetroot","Cauliflower","Orange"}; //Declaring Array
		
		//Generally return type of Find element is "Web element"
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); //As we are extracting multiple web elements we have to use "LIST"
		
		//We have iterate through those 30 products
		for(int i=0;i<products.size();i++)  //Iterate until the size of the product using ".size" method, in this case it iterates 30 times
		{
			//For every 1 iteration we have to get 1 index out of 30 and get the product name text
			//Format the name to get the actual vegetable name instead of Cucumber - 1kg, Beetroot - 1kg etc...using Split button
			String[] name = products.get(i).getText().split("-"); //store it in a string variable, Use Split method seperate the texts
			String formattednames = name[0].trim(); //Trim method will remove spaces
			
			//Check whether the name you extracted is present in Array or not
			//Converting the Array into ArrayList for easy search, Array list contains the method called contains
			//Why we are converting Array to Arraylist here and not in beginning is because ArrayList consumes more memory
			
			List itemslist = Arrays.asList(items); 
			
			//To go into desired product
			if(itemslist.contains(formattednames))
			{
				j++;
				//Clicking ADD TO CART button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //ADD CART button is Dynamic so we can't use "Text"
				//We can't use Break statement as we are fetching multiple Products
				
				if(j++ == items.length)
				{
					break; //We will come out of the loop as soon as we get 2 items
				}
			}
			
			
			
				
			
			
		}
		
		

	}

}
