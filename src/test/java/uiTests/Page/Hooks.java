package uiTests.Page;

import io.cucumber.java.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import java.util.concurrent.TimeUnit;


public class Hooks {
    private WebDriver driver;
    protected static String baseUrl = System.getProperty("baseUrl","https://demoqa.com/");
    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Letícia//IdeaProjects//challengeQA//src//test//resources//chromedriver.exe");
        driver = new chromeDriver();
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().Wait(10, TimeUnit.SECONDS);
    }
    public WebDriver getDriver() {
        return driver;
    }
    @After
    public void afterScenario(){
        if (driver != null) {
            driver.close();
        }
    }
}
