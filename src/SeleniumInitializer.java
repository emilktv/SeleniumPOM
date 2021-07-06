import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EventListener;
import java.util.concurrent.TimeUnit;

public class SeleniumInitializer {
    public static WebDriver driver;
    public static EventFiringWebDriver eventFiringWebDriver;
    public static EventCapture eventCapture;
    //Event Firing WebDriver setup method
    public void eventFiringWebDriverSetup(){
        eventFiringWebDriver=new EventFiringWebDriver(driver);
        eventCapture=new EventCapture();
        eventFiringWebDriver.register(eventCapture);
        eventFiringWebDriver.manage().window().maximize();
        eventFiringWebDriver.get("http://demo.guru99.com/test/newtours/index.php");
    }
    //Read JSON method. Input Values returned as a class
    public InputValues readJSON() throws IOException,ParseException{
        Object obj = new JSONParser().parse(new FileReader("./JSON/FlightTest.json"));
        JSONObject jsonObject=(JSONObject) obj;
        return new InputValues((String) jsonObject.get("browser"),(String) jsonObject.get("email"),(String) jsonObject.get("password"),(String) jsonObject.get("confirmPassword"),(String) jsonObject.get("passengerCount"),(String) jsonObject.get("dateDay"),(String) jsonObject.get("toPort"),(String) jsonObject.get("airlineIndexNumber"));
    }
    //Initialize WebDriver method
    public void initializeBrowser(String browser) throws MalformedURLException {

        if(browser.toLowerCase().equals("chrome")){
            ChromeOptions options=new ChromeOptions();
            options.setHeadless(true);
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        else if(browser.toLowerCase().equals("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
    }
    public static void main(String[] args) throws IOException,ParseException,MalformedURLException {
        SeleniumInitializer seleniumInitializer=new SeleniumInitializer();
        InputValues inputValues=new InputValues();
        //Read JSON file data
        inputValues=seleniumInitializer.readJSON();
        //Initialize Browser Driver
        seleniumInitializer.initializeBrowser(inputValues.browser);
        //Event Firing WebDriver setup
        seleniumInitializer.eventFiringWebDriverSetup();
        //Create Page Objects
        HomePage homePage=new HomePage(eventFiringWebDriver);
        RegisterPage registerPage=new RegisterPage(eventFiringWebDriver);
        RegisterSuccessPage registerSuccessPage=new RegisterSuccessPage(eventFiringWebDriver);
        LoginPage loginPage=new LoginPage(eventFiringWebDriver);
        LoginSuccessPage loginSuccessPage=new LoginSuccessPage(eventFiringWebDriver);
        FlightFinderPage flightFinderPage=new FlightFinderPage(eventFiringWebDriver);
        // Register/Login Process
        //Set Implicit Timeout
        eventFiringWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage.clickRegisterLink();
        registerPage.inputEmail(inputValues.email);
        registerPage.inputPassword(inputValues.password);
        registerPage.inputConfirmPassword(inputValues.confirmPassword);
        registerPage.clickSubmitButton();
        registerSuccessPage.clickSignInLink();
        loginPage.inputEmail(inputValues.email);
        loginPage.inputPassword(inputValues.password);
        loginPage.clickSubmitButton();
        // Find Flight process
        loginSuccessPage.clickHomeLink();
        homePage.inputEmail(inputValues.email);
        homePage.inputPassword(inputValues.password);
        homePage.clickSubmitButton();
        loginSuccessPage.clickFlightsLink();
        flightFinderPage.selectOneWay();
        flightFinderPage.selectPassengerCount(inputValues.passengerCount);
        flightFinderPage.selectToPort(inputValues.toPort);
        flightFinderPage.selectToDateDay(inputValues.dateDay);
        flightFinderPage.selectBusinessClassRadioButton();
        flightFinderPage.selectAirline(Integer.parseInt(inputValues.airlineIndexNumber));
        flightFinderPage.clickContinueButton();
        eventFiringWebDriver.close();
    }
}
