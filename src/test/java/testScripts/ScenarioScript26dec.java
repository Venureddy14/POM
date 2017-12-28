package testScripts;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configfile.ExcelReader;
import configfile.ExcelWriter;
import configfile.PropertiesfileReader;
import pages.HomePage;
import pages.LoginPage;
import pages.Productspage;
import utility.ScreenShots;

public class ScenarioScript26dec {
WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser() {
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  }
	
  @Test
  public void productaddingHightoLow() throws InterruptedException {
	  
	  //reading properties file
	  Properties pro=PropertiesfileReader.properties_Reader();
	  
	  //reading Excel file for logins
	  String username=ExcelReader.config_excelreader(0, 0, 1);
	  String password=ExcelReader.config_excelreader(0, 1, 1);
	  String bookname1=ExcelReader.config_excelreader(0, 2, 1);
	  String bookname2=ExcelReader.config_excelreader(0, 3, 1);
	  String bookname3=ExcelReader.config_excelreader(0, 4, 1);
	  
	  //getting url from prop file
	  driver.get(pro.getProperty("url"));
	  
	  HomePage home=new HomePage(driver);
	  home.myAccountClick();
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.login(username, password);
	  lp.shopClick();
	  
	  Productspage product=new Productspage(driver);
	  product.Sorting(5);
	  
//	  int maxproducts=driver.findElements(By.xpath("//ul[@class='products masonry-done']/li")).size();
//	  for(int i=1;i<maxproducts;i++){
//		String price=  driver.findElement(By.xpath("//ul[@class='products masonry-done']/li["+i+"]//span[@class='price']")).getText();
//	  System.out.println(price);
//	  }
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
	  product.SelectProduct(bookname1);
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
	  Thread.sleep(2000);
	  product.SelectProduct(bookname2);
	  Thread.sleep(2000);
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-600)");
	  product.SelectProduct(bookname3);
	  Thread.sleep(2000);
	  product.CartButtonClick();
	  int cartsize=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart']/tbody/tr[@class='cart_item']")).size();
	  for(int j=1;j<=cartsize;j++)
	  {
	  String amount=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart']//tr["+j+"]/td[@class='product-price']/span")).getText();
	 System.out.println("..... "+ amount);
	  ExcelWriter.WriteToExcel(0, j+1, 2, amount);
	  Thread.sleep(2000);
	  	  }
	  driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart']/tbody/tr[2]/td[1]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed();
	  Thread.sleep(5000);
	  
	  
  }
  
	  
	  
  
  @AfterMethod
  public void ScreenShot(ITestResult result){
	  
	  if(ITestResult.SUCCESS==result.getStatus())
	  {
			ScreenShots.getScreenShot(result.getName(), driver);
	  }
	  driver.close();
  }

}
