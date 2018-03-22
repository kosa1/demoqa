package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.PageObject;

public class NavigationMenu extends PageObject {

    private  WebDriver driver = null;

    @FindBy(id = "menu-item-38")
    private WebElement homeTab;

    @FindBy(id = "menu-item-158")
    private WebElement aboutUsTab;

    @FindBy(id = "menu-item-155")
    private WebElement servicesTab;

    @FindBy(id = "menu-item-66")
    private WebElement demoTab;

    @FindBy(id = "menu-item-65")
    private WebElement blogTab;

    @FindBy(id = "menu-item-64")
    private WebElement contactTab;




    public NavigationMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }
}
