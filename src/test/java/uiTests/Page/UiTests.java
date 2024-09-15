package uiTests.Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UiTests {
private WebDriver driver;
private Hooks hooks;
private FormPage formPage;
private InteractionsPage interactionPage;
private AlertsFramePage alertsFramePage;
private Widgets widgets;
private Elements elements;

@Before
public void setup() {
    hooks = new Hooks();
    hooks.setup();
    driver = hooks.getDriver();
    // Inicializa a instância de FormPage
    formPage = new FormPage(driver);
    interactionPage = new InteractionsPage(driver);
    alertsFramePage = new AlertsFramePage(driver);
    widgets = new Widgets(driver);
    elements = new Elements(driver);
}

@Test
public void sendForms() {
    driver.get("https://demoqa.com/");

    // Espera até que a página esteja completamente carregada
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    formPage.clickForms();


    // Espera até que a página esteja completamente carregada
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    formPage.clickPracticeForm();
    formPage.enterFirstName("John");
    formPage.enterLastName("Doe");
    formPage.enterEmail("john.doe@example.com");
    formPage.enterNumber("1234567890");
    formPage.enterDateOfBirth("01 Jan 2000");
    formPage.enterCurrentAddress("123 Main St");
    formPage.selectGender("Female");
    formPage.enterSubjects("Computer Science");
    formPage.state("NCR");
    formPage.city("dELHI");
    formPage.clickPicture("testeupload.txt");
    formPage.chooseHobby("Sports");
    formPage.chooseHobby("Reading");
    formPage.chooseHobby("Music");
    formPage.submit();

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        throw new RuntimeException("Erro ao aguardar o tempo de pausa", e);
    }

    formPage.closePopUp();

}
@Test
public void interactionPage(){
    driver.get("https://demoqa.com/");
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );
    interactionPage.clickOnInteractionPage();

    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    interactionPage.clickSortable();
    interactionPage.sortItemsInDescendingOrder();
}

@Test
public void AlertFramePage(){
    driver.get("https://demoqa.com/");
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    alertsFramePage.openFramePage();

    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    alertsFramePage.clickOnSubmenu();
    alertsFramePage.validatePageTitle("This is a sample page");

}

@Test
public void widgetsProgressBar(){
    driver.get("https://demoqa.com/");
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );
    widgets.openFramePage();

    new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );

    widgets.clickOnSubmenu();
    widgets.startProgressBar();
    widgets.startButtonProgressBar();
    widgets.resetProgressBar();
}

    @Test
    public void elements() {
        driver.get("https://demoqa.com/");

        // Espera até que a página esteja completamente carregada
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );

        elements.clickOnElemnts();


        // Espera até que a página esteja completamente carregada
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );

        elements.clickOnWebTables();
        elements.clickOnAddButton();
        elements.enterFirstName("John");
        elements.enterLastName("Lolo");
        elements.enterEmail("john.doe@example.com");
        elements.enterAge("40");
        elements.enterSalary("2000");
        elements.enterDepartament("QA");
        elements.clickOnSubmit();

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );

        elements.clickOnEditButton();
        elements.editForm("Leticia");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao aguardar o tempo de pausa", e);
        }

        elements.clickOnSubmit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao aguardar o tempo de pausa", e);
        }

        elements.deleteButton();

    }


    @After
    public void teardown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hooks.afterScenario();
    }
}