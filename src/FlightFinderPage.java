import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends PageInitialisation{
    public FlightFinderPage(WebDriver driver) { super(driver); }
    @FindBy(xpath = "//input[@value='oneway']")
    WebElement oneWayRadioButton;
    @FindBy(name = "passCount")
    WebElement passengerCount;
    @FindBy(name = "toPort")
    WebElement toPort;
    @FindBy(name = "toDay")
    WebElement toDateDay;
    @FindBy( xpath= "//input[@value='Business']")
    WebElement businessClassRadioButton;
    @FindBy(name= "airline")
    WebElement airline;
    @FindBy(name = "findFlights")
    WebElement continueButton;
    public void selectOneWay(){oneWayRadioButton.click();}
    public void selectPassengerCount(String count){
        Select passengerCountSelectBox=new Select(passengerCount);
        passengerCountSelectBox.selectByValue(count);}
    public void selectToPort(String portName){
        Select toPortSelectBox=new Select(toPort);
        toPortSelectBox.selectByValue(portName);}
    public void selectToDateDay(String dayNumber){
        Select toDateDaySelectBox=new Select(toDateDay);
        toDateDaySelectBox.selectByValue(dayNumber);}
    public void selectBusinessClassRadioButton(){businessClassRadioButton.click();}
    public void selectAirline(int airlineIndex){
        Select airlineSelectBox=new Select(airline);
        airlineSelectBox.selectByIndex(airlineIndex);}
    public void clickContinueButton(){continueButton.click();}

}
