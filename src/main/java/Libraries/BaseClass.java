package Libraries;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver;
	public void initialiseBroswer() throws IOException {

		driver=new ChromeDriver();

		//driver.get("https://www.saucedemo.com/");
		driver.get(UtilityClass.getPFdata("URL"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}
}
