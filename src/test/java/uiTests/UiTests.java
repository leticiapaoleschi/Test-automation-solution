package uiTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class UiTests {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void acessarSite() {
        driver.get("https://demoqa.com/");
        driver.findElement(By.linkText("Forms")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
