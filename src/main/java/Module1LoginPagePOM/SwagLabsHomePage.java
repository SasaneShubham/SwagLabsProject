package Module1LoginPagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsHomePage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='app_logo']")private WebElement actLogoText;
	
	@FindBy(xpath="(//button[@type='button'])[1]")private WebElement clickMenuBtn;
	
	
	public SwagLabsHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public String checkLogoText() {
		
		String text = actLogoText.getText();
		return text ;
		
	}
	
	public void clickMenuButton() {
		clickMenuBtn.click();
	}
}
