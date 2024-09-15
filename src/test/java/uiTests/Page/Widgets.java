package uiTests.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Widgets extends BasePage{
    public Widgets(WebDriver driver) {
        super(driver);
    }

    By widgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div");
    By progressBar = By.xpath("//div[@class='element-list collapse show']//ul[@class='menu-list']/li[@id='item-4']");
    By startButton = By.id("startStopButton");
    By resetButton = By.id("resetButton");
    By progressBarStatus = By.xpath("//*[@id=\"progressBar\"]/div");;

    public void openFramePage(){
        click(widgets);
    }
    public void clickOnSubmenu() {
        WebElement element = findElement(progressBar);

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        click(progressBar);
    }

    public void startProgressBar () {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
        click(startButton);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(webDriver -> {
            String progressValue = findElement(progressBarStatus).getAttribute("aria-valuenow");
            if (progressValue != null && !progressValue.isEmpty()) {
                int progress = Integer.parseInt(progressValue);
                System.out.println("Progresso atual: " + progress + "%");
                return progress > 20 && progress < 25;
            }
            return false;
        });

        click(startButton);

        String progressValue = findElement(progressBarStatus).getAttribute("aria-valuenow");
        if (progressValue != null && !progressValue.isEmpty()) {
            int progress = Integer.parseInt(progressValue);
            assert progress > 20 && progress < 25 : "O progresso não está entre 20% e 25%, valor atual: " + progress;
        } else {
            throw new AssertionError("O valor do progresso é nulo ou vazio");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao aguardar o tempo de pausa", e);
        }
    }

    public void startButtonProgressBar() {
        click(startButton);
    }

    public void resetProgressBar() {
        click(resetButton);
    }
}