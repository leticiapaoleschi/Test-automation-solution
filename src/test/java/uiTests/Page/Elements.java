package uiTests.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Elements extends BasePage {
    public Elements(WebDriver driver) {
        super(driver);
    }

    By elemntsButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div");
    By webTables = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[1]/div/ul/li[4]");
    By addButton = By.id("addNewRecordButton");
    By firstName = By.xpath("//*[@id=\"firstName\"]");
    By lastName = By.xpath("//*[@id=\"lastName\"]");
    By email = By.xpath("//*[@id=\"userEmail\"]");
    By age = By.xpath("//*[@id=\"age\"]");
    By salary = By.xpath("//*[@id=\"salary\"]");
    By departament = By.xpath("//*[@id=\"department\"]");
    By submitButton = By.xpath("//*[@id=\"submit\"]");
    By editButton = By.xpath("//*[@id=\"edit-record-4\"]");
    By deletButton = By.xpath("//*[@id=\"delete-record-4\"]");

    public void clickOnElemnts(){
        click(elemntsButton);
    }

    public void clickOnWebTables(){
        click(webTables);
    }

    public void clickOnAddButton(){
        click(addButton);
    }

    public void enterFirstName(String firstNameValue) {
        sendKeys(firstName, firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        sendKeys(lastName, lastNameValue);
    }

    public void enterEmail(String emailValue) {
        sendKeys(email, emailValue);
    }

    public void enterAge(String ageValue) {
        sendKeys(age, ageValue);
    }

    public void enterSalary(String salaryValue){
        sendKeys(salary, salaryValue);
    }
    public void enterDepartament(String departamentValue){
        sendKeys(departament, departamentValue);
    }

    public void clickOnSubmit(){
        click(submitButton);
    }

    public void clickOnEditButton(){
        click(editButton);
    }

    public void editForm(String nameValue){
        sendKeys(firstName, nameValue);
    }

    public void deleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement deleteBtn = wait.until(ExpectedConditions.presenceOfElementLocated(deletButton));


        Actions actions = new Actions(driver);
        actions.moveToElement(deleteBtn).perform();


        deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deletButton));

        deleteBtn.click();
    }

}
