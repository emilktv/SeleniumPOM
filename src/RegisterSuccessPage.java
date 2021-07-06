import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterSuccessPage extends PageInitialisation{
    public RegisterSuccessPage(WebDriver driver) { super(driver); }
    @FindBy(partialLinkText = "sign-in")
    WebElement signInLink;
    public void clickSignInLink(){signInLink.click();}
}
