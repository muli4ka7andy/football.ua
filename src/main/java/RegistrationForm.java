import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationForm {
    private WebDriver driver;
    public RegistrationForm(WebDriver driver){
        this.driver = driver;
    }
    private By emailField = By.xpath("//*[@id=\"login\"]");
    private By loginField = By.xpath("//*[@id=\"username\"]");
    private By passwordField = By.xpath("//*[@id=\"password1\"]");
    private By confirmField = By.xpath("//*[@id=\"password2\"]");
    private By enableCaptcha = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]");
    private By agreement = By.xpath("//*[@id=\"agreement\"]");
    private By registration = By.xpath("//*[@id=\"register\"]/div[3]/button");
    private By errorRegistration = By.xpath("//*[@id=\"registercontent\"]/p");


    public RegistrationForm typeEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public RegistrationForm typeLoginField(String login){
        driver.findElement(loginField).sendKeys(login);
        return this;
    }
    public RegistrationForm typeConfirmField(String password2){
        driver.findElement(confirmField).sendKeys(password2);
        return this;
    }

    public RegistrationForm typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public RegistrationForm clickEnableCaptcha(){
        driver.findElement(enableCaptcha).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new RegistrationForm(driver);
    }
    public RegistrationForm clickAgreement(){
        driver.findElement(agreement).click();
        return new RegistrationForm(driver);
    }
    public RegistrationForm clickRegistration(){
        driver.findElement(registration).click();
        return new RegistrationForm(driver);
    }
    public String getErrorText(){
        return driver.findElement(errorRegistration).getText();

    }

    public RegistrationForm register(String email, String login, String password, String password2){
        this.typeEmailField(email);
        this.typeLoginField(login);
        this.typePasswordField(password);
        this.typeConfirmField(password2);
        this.clickAgreement();
        //this.clickEnableCaptcha();
        this.clickRegistration();


        return new RegistrationForm(driver);
    }


}
