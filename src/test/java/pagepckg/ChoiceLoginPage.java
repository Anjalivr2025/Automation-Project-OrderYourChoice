package pagepckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoiceLoginPage 
{

	
	 WebDriver driver;
    
	 @FindBy(xpath="//*[@id=\"user_info_top\"]/span")
	 WebElement myacc;
	 
	 @FindBy(xpath="//*[@id=\"user_info_top\"]/ul/li[1]/a")
	 WebElement acc;
    
    @FindBy(xpath="//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    WebElement email;
   
    @FindBy(xpath="//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    WebElement pass;
   
    @FindBy(xpath="//*[@id=\"login-form\"]/footer/button")
    WebElement sign;
   
    @FindBy(xpath="//*[@id=\"header\"]/div[1]/div/div/div[1]/a/img")
	 WebElement logo;
     
    public ChoiceLoginPage(WebDriver driver) 
    {
	      this.driver=driver; 
	      PageFactory.initElements(driver,this);
    }  
    
    public void myAccount()
    {
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(myacc).click().perform();
    	acc.click();	
    	
    }
    
    public void setValues(String UserName,String pwd) 
    {
	        email.clear();
	        email.sendKeys(UserName);
	        
	        pass.clear();
	        pass.sendKeys(pwd); 
	      
    }
    public void login()	
    {   
        sign.click();
        
    }
    
    public void homePage()
    {
    	
    	logo.click();
    }
     
}
