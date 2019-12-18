package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Create by plotnikvk
 */

public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("nux")) {
            System.setProperty("webdriver.chrome.driver.linux", properties.getProperty("webdriver.chrome.driver.linux"));
        } else if (os.contains("nix")) {
            System.setProperty("webdriver.chrome.driver.linux", properties.getProperty("webdriver.chrome.driver.linux"));
        } else if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver.windows", properties.getProperty("webdriver.chrome.driver.windows"));
        }
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
