package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	static WebDriver driver = null;
	
		public static void initializeBrowser(String browserName) {
		
		
		if(browserName.equals("chrome")) {
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOption);
		
		}else if(browserName.equals("firefox")) {
			
		driver = new FirefoxDriver();
		
		}else if(browserName.equals("edge")) {
			
		driver = new EdgeDriver();
		
		}else if(browserName.equals("safari")) {
			
		driver = new SafariDriver();
		
	}

}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
}