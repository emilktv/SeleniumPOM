import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSuccessPage extends PageInitialisation{
    public LoginSuccessPage(WebDriver driver) { super(driver);}
    @FindBy(linkText = "Flights")
    WebElement flightsLink;
    @FindBy(linkText = "Home")
    WebElement homeLink;
    public void clickFlightsLink(){flightsLink.click();}
    public void clickHomeLink(){homeLink.click();}
}
