public class InputValues {
    String browser;
    String email;
    String password;
    String confirmPassword;
    String passengerCount;
    String dateDay;
    String toPort;
    String airlineIndexNumber;

    public InputValues() {
    }

    public InputValues(String browser, String email, String password, String confirmPassword, String passengerCount, String dateDay, String toPort, String airlineIndexNumber) {
        this.browser = browser;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.passengerCount = passengerCount;
        this.dateDay = dateDay;
        this.toPort = toPort;
        this.airlineIndexNumber = airlineIndexNumber;
    }
}
