import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageInitialisation{
    public LoginPage(WebDriver driver) { super(driver); }
    @FindBy(xpath = "//input[@name='userName']")
    WebElement emailInputBox;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInputBox;
    @FindBy(xpath="//input[@name='submit']")
    WebElement submitButton;
    public void inputEmail(String email){emailInputBox.sendKeys(email);}
    public void inputPassword(String password){passwordInputBox.sendKeys(password);}
    public void clickSubmitButton(){submitButton.click();}
}
