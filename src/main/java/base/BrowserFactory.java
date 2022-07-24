package base;

import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import reportgeneration.ExtentFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
   
    //Create WebDriver Object for a given Browser;
    public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
        WebDriver driver=null;

        if(browser.equalsIgnoreCase("Chrome")){

           WebDriverManager.chromedriver().setup();
            System.setProperty("WebDriver.chrome.silenceOutput", "true");
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver=new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
      

        }else if(browser.equalsIgnoreCase("edge")) {
           
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
        }

        return driver;
    }
}
