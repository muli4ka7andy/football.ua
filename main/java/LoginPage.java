import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"loginemail\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"loginpassword\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"loginblock\"]/div[2]/button")
    private WebElement signIn;
    @FindBy(xpath = "//*[@id=\"ui-id-2\"]")
    private WebElement heading;
    @FindBy(xpath = "//*[@id=\"logincontent\"]/p")
    private WebElement error;

    public LoginPage typeEmail(String email){
        emailField.sendKeys(email);
        return this;
    };
    public LoginPage typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    };
    public LoginPage incorrectLogin(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        signIn.submit();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return heading.getText();
    }
    public String getErrorText(){
        return error.getText();
    }
}
