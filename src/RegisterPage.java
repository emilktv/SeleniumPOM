import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageInitialisation{
    public RegisterPage(WebDriver driver) { super(driver); }
    @FindBy(id="email")
    WebElement emailInputBox;
    @FindBy(name ="password")
    WebElement passwordInputBox;
    @FindBy(name = "confirmPassword")
    WebElement confirmPasswordInputBox;
    @FindBy(name = "submit")
    WebElement submitButton;
    public void inputEmail(String email){emailInputBox.sendKeys(email);}
    public void inputPassword(String password){passwordInputBox.sendKeys(password);}
    public void inputConfirmPassword(String password){confirmPasswordInputBox.sendKeys(password);}
    public void clickSubmitButton(){submitButton.click();}
}
