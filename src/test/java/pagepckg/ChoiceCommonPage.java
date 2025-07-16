package pagepckg;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChoiceCommonPage 
{
	
	 WebDriver driver;
	
	 @FindBy(xpath="//*[@id=\"header\"]/div[1]/div/div/div[1]/a/img")
	 WebElement logo;
	 
	 
	 @FindBy(xpath="//*[@id=\"pos_query_top\"]")
	 WebElement search;
	
	 
	 @FindBy(xpath="//*[@id=\"pt_menu5\"]/div[1]/a/span")
	 WebElement cakes;
	 
	 @FindBy(xpath="//*[@id=\"block15\"]/div[1]/div/a[5]/span")
	 WebElement regCakes;
	 
	 
	 @FindBy(xpath="//*[@id=\"pt_menu7\"]/div[1]/a/span")
	 WebElement flower;
	
	 @FindBy(xpath="//*[@id=\"block17\"]/div[1]/div/a[2]/span")
	 WebElement flowerBasket;
	
	 @FindBy(xpath="//*[@id=\"pt_menu6\"]/div[1]/a/span")
	 WebElement sweets;
	
	 @FindBy(xpath="//*[@id=\"block16\"]/div[1]/div/a[4]")
	 WebElement gheeSweets;
	 
	 
	 @FindBy(tagName ="a")
	 List<WebElement> li;
	   
      public ChoiceCommonPage(WebDriver driver) 
      {
	      this.driver=driver; 
	      PageFactory.initElements(driver,this);
      }  
   
      public void titlePrint() throws InterruptedException
      {
      	String actualTitle=driver.getTitle();
      	System.out.println("Title of the Page  : "+actualTitle);
        Thread.sleep(3000);
  
      }
      public void logoVerification()
  	  {
  	      if(logo.isDisplayed())
  		   {
  			   System.out.println("Logo is present");
  		   }
  		   else
  		   {
  			   System.out.println("Logo is not present");
  		   }			   	
  	  }
      
      
      public void productSearch() throws InterruptedException
	   {
		   
		   search.clear();
		   search.click(); 
		   search.sendKeys("Orchid");
		   search.sendKeys(Keys.ENTER);
		   JavascriptExecutor js=(JavascriptExecutor)driver;
	       js.executeScript("window.scrollBy(0,500);");
	       System.out.println("Searched  Orchid ");
		   Thread.sleep(3000);
		   driver.navigate().back();
		   logo.click();   
	   }  
      
      public void cakesMenu() throws InterruptedException 
  	  {
  	    Actions act=new Actions(driver);
  	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  	    act.moveToElement(cakes).perform();   
        regCakes.click(); 
        JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,500);");
     	System.out.println("Regular Cakes displayed");
     	Thread.sleep(3000);
     	driver.navigate().back();
      }
    
      
      public void flowerScreenshot() throws InterruptedException, IOException
	   {
		  
    	  Actions act=new Actions(driver);
  	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  	      act.moveToElement(flower).perform();   
          flowerBasket.click(); 
		  JavascriptExecutor js=(JavascriptExecutor)driver;
	  	  js.executeScript("window.scrollBy(0,800);");
	  	  Thread.sleep(3000);
	      File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	   	  FileHandler.copy(screenShot,new File("./Flowers/flowerbasket.png"));	
	   	  Thread.sleep(2000);
	   	  driver.navigate().back();
	   	
	   }
      
      public void wordSearch() throws InterruptedException
	    {
		    
    	   Actions act=new Actions(driver);
  	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  	       act.moveToElement(sweets).perform();   
           gheeSweets.click();
           JavascriptExecutor js=(JavascriptExecutor)driver;
 	  	   js.executeScript("window.scrollBy(0,500);");
	       String pagesrc=driver.getPageSource();  
	       String SG="Gulab Jamun";
	       if(pagesrc.contains(SG))
	       {
	           System.out.println("Test is present");	
	       }
	       else
	       {
	       	   System.out.println("Test is not present");
	       }
	       Thread.sleep(3000);
	       driver.navigate().back();
	    }
	
      public void linkverifyMethod()
	   {
		 
	     for(WebElement e:li)
			{	
			String link=e.getAttribute("href");
			verify(link);
			}
       }


	private void verify(String link)
	{
		try
	    {
	    URI ob=new URI(link);
		HttpURLConnection con=(HttpURLConnection)ob.toURL().openConnection();
		if(con.getResponseCode()==200)
		{
			System.out.println(" Successful link response code is 200 ----------"+link);
		}
		else if(con.getResponseCode()==404)
		{
			System.out.println(" Broken link response code is 404 ----------"+link);
		}
		else
		{
			System.out.println("Other links ----------"+link);
    	}	
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }	
	}
}
