import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By registrationButton = By.xpath("//*[@id=\"reg-link\"]");
    private By signInButton = By.xpath("//*[@id=\"enter-link\"]");

    public LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public RegistrationForm clickRegistrationButton(){
        driver.findElement(registrationButton).click();
        return new RegistrationForm(driver);

    }
}
