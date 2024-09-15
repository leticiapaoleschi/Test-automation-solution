package uiTests.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsFramePage extends BasePage{
    public AlertsFramePage(WebDriver driver) {
        super(driver);
    }

    By alertFramePageButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div");
    By submenu = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[1]");
    By newWindow = By.xpath("//*[@id=\"tabButton\"]");
    public void openFramePage(){
        click(alertFramePageButton);
    }
    public void clickOnSubmenu() {
        click(submenu);
    }

    public void validatePageTitle(String expectedTitle) {

        click(newWindow);
        System.out.println("Botão clicado para abrir nova aba.");

        String originalWindow = driver.getWindowHandle();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Nova aba aberta.");


        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Alternado para a nova aba.");
                break;
            }
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        System.out.println("Corpo da página carregado.");

        String bodyText = driver.findElement(By.tagName("body")).getText();
        if (bodyText.contains(expectedTitle)) {
            System.out.println("Página aberta com sucesso e texto do corpo verificado!");
        } else {
            System.out.println("Falha ao verificar o texto do corpo da página. Texto atual: " + bodyText);
        }
        driver.close();
        driver.switchTo().window(originalWindow);
        System.out.println("Nova aba fechada e retornado para a aba original.");
    }

}
