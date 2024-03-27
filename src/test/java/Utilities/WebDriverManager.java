package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private static WebDriver driver;
     private static void initializeDriver(){
         driver = new ChromeDriver();
         driver.manage().window().maximize();
     }

     public static WebDriver getDriver(){
         if(driver == null){
             initializeDriver();
         }
         return driver;
     }
     public static void quitDriver(){
         if (driver != null){
             driver.quit();
             driver = null;
         }
     }
}
