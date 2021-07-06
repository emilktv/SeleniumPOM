import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageInitialisation {
    public HomePage(WebDriver driver){ super(driver);}
    @FindBy(linkText="REGISTER")
    WebElement registerLink;
    @FindBy(name = "userName")
    WebElement emailInputBox;
    @FindBy(name = "password")
    WebElement passwordInputBox;
    @FindBy(name = "submit")
    WebElement submitButton;
    public void clickRegisterLink(){ registerLink.click();}
    public void inputEmail(String email){ emailInputBox.sendKeys(email);}
    public void inputPassword(String password){passwordInputBox.sendKeys(password);}
    public void clickSubmitButton(){submitButton.click();}
}
