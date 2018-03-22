package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaHomePage extends PageObject {

    private WebDriver driver = null;

    @FindBy(id = "menu-item-374")
    private WebElement registrationBtn;

    @FindBy(id ="menu-item-140")
    private WebElement draggableBtn;

    @FindBy(id ="menu-item-141")
    private WebElement droppableBtn;

    @FindBy(id ="menu-item-143")
    private WebElement resizableBtn;

    @FindBy(id ="menu-item-142")
    private WebElement selectableBtn;

    @FindBy(id ="menu-item-151")
    private WebElement sortableBtn;

    public DemoqaHomePage(WebDriver driver) {
        // add veryfication about if critical elements on the page were loaded correctly.
        super(driver);
        this.driver = driver;
    }

    public RegisteryPage registerUser(){
        registrationBtn.click();
        return new RegisteryPage(driver);
    }
}
