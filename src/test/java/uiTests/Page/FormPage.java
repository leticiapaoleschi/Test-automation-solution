package uiTests.Page;
import org.openqa.selenium.*;
import java.nio.file.Paths;


public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        super(driver); // Passa o WebDriver para o construtor da BasePage
    }

    // Locators
    By email = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By dateOfBirth = By.id("dateOfBirthInput");
    By phoneNumber = By.id("userNumber");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By submitButton = By.id("submit");
    By subjects = By.id("subjectsInput");
    By hobbiesSports = By.xpath("//label[@for='hobbies-checkbox-1']");
    By hobbiesReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By hobbiesMusic = By.xpath("//label[@for='hobbies-checkbox-3']");
    By genderOption = By.xpath("//*[contains(@class,'custom-radio')]");
    By states = By.id("react-select-3-input");
    By cities = By.id("react-select-4-input");
    By picture = By.id("uploadPicture");
    By Forms = By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]");
    By praticeFormButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[2]/div/ul");
    By closeModal = By.id("closeLargeModal");

    public void clickForms() {
        click(Forms);
    }

    public void clickPracticeForm(){
        click(praticeFormButton);
    }

    public void enterFirstName(String firstNameValue) {
        sendKeys(firstName, firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        sendKeys(lastName, lastNameValue);
    }

    public void enterSubjects(String subjectsValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(subjects));
        sendKeys(subjects, subjectsValue);
        findElement(subjects).sendKeys(Keys.ENTER);
    }

    public void enterEmail(String emailValue) {
        sendKeys(email, emailValue);
    }


    public void enterNumber(String numberValue) {
        if (numberValue.length() == 10) {
            sendKeys(phoneNumber, numberValue);
        } else {
            System.out.println("error");
        }
    }

    public void enterDateOfBirth(String date) {
        sendKeys(dateOfBirth, date);
    }

    public void enterCurrentAddress(String addressValue) {
        sendKeys(currentAddress, addressValue);
    }

    public void selectGender(String gender) {
        int index;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(genderOption));
        switch (gender) {
            case "Male":
                index = 0;
                break;
            case "Female":
                index = 1;
                break;
            case "Other":
                index = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid gender option: " + gender);
        }
        clickWithIndex(genderOption, index);
    }


    public void submit() {
        // Scroll para o elemento
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(submitButton));
        // Clica no elemento
        click(submitButton);
    }
    public void state(String stateValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(states));
        sendKeys(states, stateValue);
        findElement(states).sendKeys(Keys.ENTER);
    }

    public void city(String cityValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement(cities));
        sendKeys(cities, cityValue);
        findElement(cities).sendKeys(Keys.ENTER);
    }

    public void chooseHobby(String hobby) {
        switch (hobby) {
            case "Sports":
                click(hobbiesSports);
                break;
            case "Reading":
                click(hobbiesReading);
                break;
            case "Music":
                click(hobbiesMusic);
                break;
            default:
                throw new IllegalArgumentException("Invalid gender option: " + hobby);
        }
    }


    public void clickPicture(String pictureValue) {

        String filePath = Paths.get("src", "test", "resources", pictureValue).toAbsolutePath().toString();

        sendKeys(picture, filePath);
    }

    public void closePopUp(){
        click(closeModal);
    }
}

