import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private By emailField = By.xpath("//*[@id=\"loginemail\"]");
    private By passwordField = By.xpath("//*[@id=\"loginpassword\"]");
    private By signIn = By.xpath("//*[@id=\"loginblock\"]/div[2]/button");
    private By heading = By.xpath("//*[@id=\"ui-id-2\"]");
    private By error = By.xpath("//*[@id=\"logincontent\"]/p");

    public LoginPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    };
    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    };
    public LoginPage incorrectLogin(String email, String password){
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signIn).submit();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }
}
