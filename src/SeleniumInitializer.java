import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumInitializer {
    public static WebDriver driver;
    public static void main(String[] args) throws IOException, ParseException {
        //Read JSON file data
        Object obj = new JSONParser().parse(new FileReader("./JSON/FlightTest.json"));
        JSONObject jsonObject=(JSONObject) obj;
        String browser = (String) jsonObject.get("browser");
        String email = (String) jsonObject.get("email");
        String password= (String) jsonObject.get("password");
        String confirmPassword=(String) jsonObject.get("confirmPassword");
        String passengerCount = (String) jsonObject.get("passengerCount");
        String dateDay = (String) jsonObject.get("dateDay");
        String toPort = (String) jsonObject.get("toPort");
        String airlineIndexNumber=(String) jsonObject.get("airlineIndexNumber");
        //Initialize Browser Driver
        if(browser.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        //Create Page Objects
        HomePage homePage=new HomePage(driver);
        RegisterPage registerPage=new RegisterPage(driver);
        RegisterSuccessPage registerSuccessPage=new RegisterSuccessPage(driver);
        LoginPage loginPage=new LoginPage(driver);
        LoginSuccessPage loginSuccessPage=new LoginSuccessPage(driver);
        FlightFinderPage flightFinderPage=new FlightFinderPage(driver);
        // Register/Login Process
        driver.get("http://demo.guru99.com/test/newtours/index.php");
        homePage.clickRegisterLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.inputConfirmPassword(confirmPassword);
        registerPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registerSuccessPage.clickSignInLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.inputEmail(email);
        loginPage.inputPassword(password);
        loginPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Find Flight process
        loginSuccessPage.clickHomeLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.inputEmail(email);
        homePage.inputPassword(password);
        homePage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginSuccessPage.clickFlightsLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        flightFinderPage.selectOneWay();
        flightFinderPage.selectPassengerCount(passengerCount);
        flightFinderPage.selectToPort(toPort);
        flightFinderPage.selectToDateDay(dateDay);
        flightFinderPage.selectBusinessClassRadioButton();
        flightFinderPage.selectAirline(Integer.parseInt(airlineIndexNumber));
        flightFinderPage.clickContinueButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
    }
}
