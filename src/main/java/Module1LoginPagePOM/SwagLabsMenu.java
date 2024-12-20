package Module1LoginPagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsMenu {

	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement logout;
	
    public	SwagLabsMenu(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    
    public void logoutApp() {
    	logout.click();
    }
	
}
