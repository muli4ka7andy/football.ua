import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

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
        mainPage = new MainPage(driver);

    }
    @Test
    public void signIn() {
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("ВХОД НА САЙТ", heading);
    }
    @Test
    public void registrationError(){
        RegistrationForm registrationForm = mainPage.clickRegistrationButton();
        RegistrationForm registrationForm1 = registrationForm.register("email", "login", "password", "password");
       String error = registrationForm.getErrorText();
       Assert.assertNotEquals("Этот логин уже занят", error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
