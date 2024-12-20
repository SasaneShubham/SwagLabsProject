package Module1LoginPagePOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsLoginPage {

 @FindBy(xpath="//input[@id='user-name']")	private WebElement UN;
 @FindBy(xpath="//input[@id='password']")private WebElement PWD;
 @FindBy(xpath="//input[@type='submit']")private WebElement LoginBtn;
 @FindBy(xpath="//div[@class='error-message-container error']")private WebElement errorMsg;
 
 WebDriver driver;
 

	
	public SwagLabsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void inputUserID(String Username) {
		UN.sendKeys(Username);
	}

	public void inputPass(String Pass) {
		PWD.sendKeys(Pass);
	}
	
	public void clickLoginBtn() {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
	}
	public void validateErrorMsg(String expErrorMsg) {
		String actErrorMsg=errorMsg.getText();
		if(actErrorMsg.equals(actErrorMsg)) {
			System.out.println("Correct Error");
		}
		else {
			System.out.println("Incorrect Error");
		}
	}
}
