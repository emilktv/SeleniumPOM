import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageInitialisation{
    public LoginPage(WebDriver driver) { super(driver); }
    @FindBy(name = "userName")
    WebElement emailInputBox;
    @FindBy(name = "password")
    WebElement passwordInputBox;
    @FindBy(name="submit")
    WebElement submitButton;
    public void inputEmail(String email){emailInputBox.sendKeys(email);}
    public void inputPassword(String password){passwordInputBox.sendKeys(password);}
    public void clickSubmitButton(){submitButton.click();}
}
