package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Productspage {
	WebDriver driver;

	public Productspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='content']/form/select") WebElement sorting;
	@FindBy(xpath="//a[contains(@href,'/shop/?orderby=popularity&add-to-cart=170')]") WebElement jsbook;
	@FindBy(xpath="//a[contains(@href,'/shop/?orderby=popularity&add-to-cart=160')]") WebElement seleniumruby;
	@FindBy(xpath="//a[contains(@href,'/shop/?orderby=price-desc&add-to-cart=181')]") WebElement html5forms;
	@FindBy(xpath="//a[contains(@href,'/shop/?orderby=price-desc&add-to-cart=165')]") WebElement masterJS;
	@FindBy(xpath="//a[contains(@href,'/shop/?orderby=price-desc&add-to-cart=169')]") WebElement androidQS;
	
	@FindBy(xpath="//span[@class='cartcontents']") WebElement cart;
			
	public void Sorting(Integer index){
		Select dropdown=new Select(sorting);
		dropdown.selectByIndex(index);
	}
	public void SelectProduct(String bookname){
		switch(bookname){
			case "Functional Programming in JS":
				jsbook.click();
				break;
			case "Selenium Ruby":
				seleniumruby.click();
				break;
			case "HTML5 Forms":
				html5forms.click();
				break;
			case "Mastering JavaScript":
				masterJS.click();
				break;
			case "Android Quick Start Guide":
				androidQS.click();
				
		}
		
	}
	public void CartButtonClick(){
		cart.click();
	}
}
