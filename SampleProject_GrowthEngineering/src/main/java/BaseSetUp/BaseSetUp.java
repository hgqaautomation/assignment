package BaseSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSetUp {
	
	public static WebDriver driver;
	
	
	public void browserSetUp()
	{

		try {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\" + "Browser Exes/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://www.growthengineering.co.uk/");
			driver.manage().window().maximize();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
