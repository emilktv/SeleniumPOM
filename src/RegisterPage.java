import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageInitialisation{
    public RegisterPage(WebDriver driver) { super(driver); }
    @FindBy(xpath="//input[@id='email']")
    WebElement emailInputBox;
    @FindBy(xpath ="//input[@name='password']")
    WebElement passwordInputBox;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPasswordInputBox;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;
    public void inputEmail(String email){emailInputBox.sendKeys(email);}
    public void inputPassword(String password){passwordInputBox.sendKeys(password);}
    public void inputConfirmPassword(String password){confirmPasswordInputBox.sendKeys(password);}
    public void clickSubmitButton(){submitButton.click();}
}
