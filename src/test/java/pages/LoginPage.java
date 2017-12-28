package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	
	@FindBy(id="username") WebElement usernameField;
	@FindBy(id="password") WebElement passwordfield;
	@FindBy(name="login") WebElement loginButton;
	@FindBy(xpath="//li[@id='menu-item-40']/a") WebElement shop;
	
	public void login(String username, String Password){
		usernameField.sendKeys(username);
		passwordfield.sendKeys(Password);
		loginButton.click();
	}
	public void shopClick(){
		shop.click();
		
	}

	
}
