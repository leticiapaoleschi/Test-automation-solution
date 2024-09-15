package uiTests.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class InteractionsPage extends BasePage {
    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    By interection = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]");
    By sortableButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[1]");
    By sortableItems = By.cssSelector(".list-group-item.list-group-item-action");


    public void clickOnInteractionPage(){
        click(interection);
    }
    public void clickSortable(){
        click(sortableButton);
    }

    public void sortItemsInDescendingOrder() {
        List<WebElement> items = driver.findElements(sortableItems).stream()
                .filter(item -> !item.getText().isEmpty())
                .collect(Collectors.toList());
        Actions actions = new Actions(driver);

        System.out.println("Number of items found: " + items.size());

        for (WebElement item : items) {
            System.out.println("Item text: " + item.getText());
        }

        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - 1 - i; j++) {
                WebElement source = items.get(j);
                WebElement target = items.get(j + 1);
                System.out.println("Dragging item " + source.getText() + " to position of item " + target.getText());
                actions.clickAndHold(source)
                        .moveToElement(target)
                        .release()
                        .perform();
            }
        }
    }
}
