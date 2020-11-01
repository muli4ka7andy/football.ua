import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"reg-link\"]")
    private WebElement registrationButton;
    @FindBy(xpath = "//*[@id=\"enter-link\"]")
    private WebElement signInButton;

    public LoginPage clickSignIn(){
        signInButton.click();
        return new LoginPage(driver);
    }
    public RegistrationForm clickRegistrationButton(){
        registrationButton.click();
        return new RegistrationForm(driver);

    }
}
