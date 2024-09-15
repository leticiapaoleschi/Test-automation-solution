package uiTests.Page;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.nio.file.Paths;


public class Hooks {
    private WebDriver driver;
    @Before
    public void setup() {
        String driverPath = Paths.get("src", "test", "resources", "chromedriver-win64", "chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}