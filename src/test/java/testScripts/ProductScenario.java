package testScripts;

import org.testng.annotations.Test;

import configfile.ExcelReader;
import configfile.PropertiesfileReader;
import pages.HomePage;
import pages.LoginPage;
import pages.Productspage;
import utility.ScreenShots;

import org.testng.annotations.BeforeMethod;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class ProductScenario {
	WebDriver driver;
	
	@BeforeMethod
	public void launchbrowser() {
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
  @Test
  public void productadding() throws InterruptedException {
	  
	  //reading properties file
	  Properties pro=PropertiesfileReader.properties_Reader();
	  
	  //reading Excel file for logins
	  String username=ExcelReader.config_excelreader(0, 0, 1);
	  String password=ExcelReader.config_excelreader(0, 1, 1);
	  String bookname=ExcelReader.config_excelreader(0, 2, 1);
	  String bookname2=ExcelReader.config_excelreader(0, 3, 1);
	  
	  
	  //getting url from prop file
	  driver.get(pro.getProperty("url"));
	  
	  HomePage home=new HomePage(driver);
	  home.myAccountClick();
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.login(username, password);
	  lp.shopClick();
	  
	  Productspage product=new Productspage(driver);
	  product.Sorting(1);
	  
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
	  product.SelectProduct(bookname);
	  
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
	  product.SelectProduct(bookname2);
	  
	  product.CartButtonClick();
	  
	 int rowcount=driver.findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart']/tbody/tr")).size();
	  for(int i=1;i<rowcount;i++)
	  {
	  String productname=driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart']/tbody/tr["+i+"]/td[3]")).getText();
	  
	  System.out.println(productname);
	 
	  if(productname==bookname){
		 System.out.println("Product matched is "+productname);
	 }else if(productname==bookname2){
		 System.out.println("Product matched is "+productname);
	 }else{
		 System.out.println("Product did not match "+productname);
		 driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart']/tbody/tr["+i+"]/td[1]")).click();
	 }
	  }
	  
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
