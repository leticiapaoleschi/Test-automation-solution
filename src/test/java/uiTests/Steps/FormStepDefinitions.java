package uiTests.Steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormStepDefinitions {
    WebDriver driver = new ChromeDriver();

    @Given("que estou na página do formulário")
    public void que_estou_na_pagina_do_formulario() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

}
