import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.opera.driver", "C:\\Users\\Андрей\\operadriver_win64\\operadriver_win64\\operadriver.exe");
        driver = new OperaDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://football.ua");
        //mainPage = new MainPage(driver);
        RegistrationForm registrationForm = PageFactory.initElements(driver, RegistrationForm.class);


    }
    @Test
    public void signIn() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("ВХОД НА САЙТ", heading);
    }
    @Test
    public void registrationError(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        mainPage.clickRegistrationButton();
        RegistrationForm registrationForm = PageFactory.initElements(driver, RegistrationForm.class);
        registrationForm.register("email", "login", "password", "password");
       String error = registrationForm.getErrorText();
       Assert.assertNotEquals("Этот логин уже занят", error);
       Assert.assertEquals("Неправильный Email",error);
        System.out.println(error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
