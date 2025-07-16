package pagepckg;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChoiceCartPage 
{

	WebDriver driver;
    
	 @FindBy(xpath="//*[@id=\"pt_menu5\"]/div[1]/a/span")
	 WebElement cakes;
	 
	 @FindBy(xpath="//*[@id=\"block15\"]/div[1]/div/a[3]/span")
	 WebElement kidsCakes;
	 
	 @FindBy(xpath="//*[@id=\"js-product-list\"]/div[1]/div[1]/article/div[2]/ul/li[1]/div/form/button/i")
	 WebElement item1;
	 
	 
	 @FindBy(xpath="//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/a")
	 WebElement view;
	 
	 @FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div/div[2]/div/a")
	 WebElement check;
	 
	 @FindBy(xpath="//*[@id=\"customer-form\"]/footer/button")
	 WebElement cont;
	
	 @FindBy(xpath="//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")
	 WebElement contin;
	 
	 @FindBy(xpath="//*[@id=\"delivery_message\"]")
	 WebElement bdaymsg;
	 
	 @FindBy(xpath="//*[@id=\"js-delivery\"]/button")
	 WebElement continu;
	 
	 @FindBy(xpath="//*[@id=\"payment-confirmation\"]/div[1]/button")
	 WebElement submitButton;
	 
	 
	 @FindBy(xpath="//*[@id=\"user_info_top\"]/div/a")
	 WebElement signoutButton;
	 
	
      public ChoiceCartPage(WebDriver driver) 
      {
	      this.driver=driver; 
	      PageFactory.initElements(driver,this);
      }  
   
      public void selectItem()
      {
	      
	      Actions actions = new Actions(driver);
      	  actions.moveToElement(cakes).perform();
   	      kidsCakes.click();	   
      }
  	
      public void addItem() throws InterruptedException
      {
	      JavascriptExecutor js=(JavascriptExecutor)driver;
  	      js.executeScript("window.scrollBy(0,500);");
  	      item1.click();
  	      Thread.sleep(3000);
  	      view.click();  
		   
      }
      public void checkOut() throws InterruptedException 
      {
	   
	      check.click();
	      Thread.sleep(3000);   
      }
     public void continButton()
     {
	     contin.click();
	   
     }
    
     public void datePickest()
 	{
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		datePickMethod("July 2025","30");
 	}
 	private void datePickMethod(String expmonth, String expdate)
 	{
 		while(true)
 		{
 			
 			String month=driver.findElement(By.xpath("//*[@id=\"ddw_calendar\"]/div/div/div")).getText();
 			System.out.println("Month  "+month);
 			if(month.equals(expmonth))
 			{
 				break;
 			}
 			else
 			{
 				driver.findElement(By.xpath("//*[@id=\"ddw_calendar\"]/div/div/a[2]/span")).click();
 			}
 		}
 		
 		List<WebElement> date=driver.findElements(By.xpath("//*[@id=\"ddw_calendar\"]/div/table/tbody/tr/td/a"));
 		
 		for(WebElement d:date)
 		{
 			String datetext=d.getText();
 			if(datetext.equals(expdate))
 			{
 				d.click();
 				break;
 			}
 		}	
 	}		
          
 	public void selectTimeSlot(String slotValue) 
 	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
      
        String tim = "//*[@id=\"ddw_timeslots\"]/div[1]/input";

        WebElement slotRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tim)));

        if (!slotRadio.isSelected())
        {
            slotRadio.click();
        }
    }      
 
 	public void setMessage() throws InterruptedException
 	{
 		
 		bdaymsg.clear();
 		bdaymsg.sendKeys("Happy Birthday");
 		Thread.sleep(3000);
 		continu.click();
 		
 	}
 	
 	public void selectPaymentMethod(String paymentOptionId) throws TimeoutException 
 	{
 	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

 	    String labelXpath = "//label[@for='" + paymentOptionId + "']";
		WebElement paymentLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(labelXpath)));
		paymentLabel.click();

		System.out.println("Selected payment option: " + paymentOptionId);
 	}
 	public void paymentConfirmation() throws InterruptedException
 	{
 		submitButton.click();		
 		
 	}
 	
 	public void signOut()
 	{
 		
 		signoutButton.click();
 	}
  
 }

