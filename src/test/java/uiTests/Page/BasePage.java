package uiTests.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BasePage{
    WebDriver driver;
    private By locator;
    private int seconds;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Elemento não encontrado: " + e.getMessage());
            return null;
        }
    }

    public void clickWithIndex(By locator, int index) {
        List<WebElement> elements = driver.findElements(locator);

        if (index >= 0 && index < elements.size()) {
            elements.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Índice fora dos limites da lista de elementos.");
        }
    }


    public void sendKeys(By locator, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("An error occurred while sending keys: " + e.getMessage());
        }
    }


    public void click(By locator) {
        try {
            // Cria uma instância de WebDriverWait com um tempo de espera definido
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Espera até que o elemento esteja clicável
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

            // Após garantir que o elemento está pronto, realiza o clique
            element.click();
        } catch (Exception e) {
            // Captura e exibe o erro caso o clique falhe
            System.out.println("Erro ao clicar no elemento: " + locator.toString() + " - " + e.getMessage());
        }
    }

    public void selectInComboVisibleText(By locator, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 segundos de espera
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select = new Select(element);
            select.selectByVisibleText(value);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void clickById(String id) {
        try {
            WebElement element = driver.findElement(By.id(id));
            element.click();
        } catch (Exception e) {
            System.out.println("Erro ao clicar no elemento com ID: " + id + " - " + e.getMessage());
        }
    }

    public void sendKeysEnter(By locator, String value) {
        WebElement element = findElement(locator);
        element.sendKeys(value);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element.sendKeys(Keys.ENTER);
    }

    public static class StaticVariables {
        public static final List<String> HOBBIES = Arrays.asList("Reading", "Gaming", "Cooking");
    }


}
