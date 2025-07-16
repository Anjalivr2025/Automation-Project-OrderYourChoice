package testpckg;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.testng.annotations.Test;
import pagepckg.ChoiceCartPage;
import pagepckg.ChoiceCommonPage;
import pagepckg.ChoiceLoginPage;
import utilitiespckg.ChoiceExcelUtils;

public class ChoiceTest extends ChoiceBaseclass
{

	@Test
	public void verifyChoice() throws InterruptedException, TimeoutException, IOException 
	{

		
		ChoiceLoginPage ob=new ChoiceLoginPage(driver);
		ob.myAccount();
	   
		String xl="C:\\Users\\Anjali\\OneDrive\\Desktop\\TestNG Excel\\ChoiceExcel.xlsx";
		String Sheet="Sheet1";
				
		int rowCount=ChoiceExcelUtils.getRowCount(xl, Sheet);
	
		for(int i=1;i<=rowCount;i++)
		{
			
			String UserName=ChoiceExcelUtils.getCellValues(xl, Sheet, i, 0);
			System.out.println("User name----------"+UserName);	
			
			String Pwd=ChoiceExcelUtils.getCellValues(xl, Sheet, i,1);
			System.out.println("Password----------"+Pwd);
		
			ob.setValues(UserName,Pwd);
			ob.login();	
			
			Thread.sleep(3000);
		}	
		
	    ob.homePage();
	      
	    ChoiceCommonPage ob1=new ChoiceCommonPage(driver);
		ob1.titlePrint();
		ob1.logoVerification();
		ob1.productSearch();
		ob1.cakesMenu();
		ob1.flowerScreenshot();
		ob1.wordSearch();
  	    ob1.linkverifyMethod();
	   
	    ChoiceCartPage ob2=new ChoiceCartPage(driver);
		ob2.selectItem();
		ob2.addItem();
		ob2.checkOut();
		ob2.continButton();
		ob2.datePickest();
		ob2.selectTimeSlot("10am - 2pm");
		ob2.setMessage();
	    ob2.selectPaymentMethod("payment-option-3");
	    ob2.paymentConfirmation();
	    ob2.signOut();
		
	}
}

