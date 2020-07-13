package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;


import commons.CommonsMethods;

public class ScreenshotListener extends TestListenerAdapter {
	WebDriver driver=null; 

	public static String filePath;
	public static String methodName;
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
       
    }

    public void takeScreenShot(String methodName) {
        //get the driver
    	 driver=CommonsMethods.getDriver();
    	 Calendar calendar = Calendar.getInstance();
         SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
                FileUtils.copyFile(scrFile, new File(filePath+methodName+"_"+formater.format(calendar.getTime())+".png"));
                System.out.println("***Placed screen shot in "+filePath+" ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    @Override
    public void onStart(ITestContext testContext) { 
    	XmlSuite test = testContext.getCurrentXmlTest().getSuite();
    	filePath = "test-output\\"+test.getName()+"\\screenshotsFaliures\\";
    	System.out.println(test.getName());
    }
    
   public void onFinish(ITestContext context) { }
   
   public void onTestStart(ITestResult result) {  
	    methodName=result.getName().toString().trim();
   }

   public void onTestSuccess(ITestResult result) {   }

   public void onTestSkipped(ITestResult result) {   }

   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }


}
