import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationForm {
    private WebDriver driver;
    public RegistrationForm(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"password1\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"password2\"]")
    private WebElement confirmField;
    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    private WebElement enableCaptcha;
    @FindBy(xpath = "//*[@id=\\\"agreement\\\"]\"")
    private WebElement agreement;
    @FindBy(xpath = "//*[@id=\"register\"]/div[3]/button")
    private WebElement registration;
    @FindBy(xpath = "//*[@id=\"registercontent\"]/p")
    private WebElement errorRegistration;


    public RegistrationForm typeEmailField(String email){
        emailField.sendKeys(email);
        return this;
    }
    public RegistrationForm typeLoginField(String login){
        loginField.sendKeys(login);
        return this;
    }
    public RegistrationForm typeConfirmField(String password2){
        confirmField.sendKeys(password2);
        return this;
    }

    public RegistrationForm typePasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public RegistrationForm clickEnableCaptcha(){
        enableCaptcha.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new RegistrationForm(driver);
    }
    public RegistrationForm clickAgreement(){
        agreement.click();
        return new RegistrationForm(driver);
    }
    public RegistrationForm clickRegistration(){
        registration.click();
        return new RegistrationForm(driver);
    }
    public String getErrorText(){
        if(errorRegistration.equals("Неправильный Email") ||  errorRegistration.equals("Неправильно указан повтор пароля.") || errorRegistration.equals("Короткий или пустой пароль") ||errorRegistration.equals("Подтвердите соглашение о конфиденциальности"))
        {
            System.out.println("Test was failed");
        } else {
            System.out.println("Test wasn't failed");
        }
        return errorRegistration.getText();
    }

    public RegistrationForm register(String email, String login, String password, String password2){
        this.typeEmailField(email);
        this.typeLoginField(login);
        this.typePasswordField(password);
        this.typeConfirmField(password2);
        //this.clickAgreement();
        //this.clickEnableCaptcha();
        this.clickRegistration();


        return new RegistrationForm(driver);
    }


}
