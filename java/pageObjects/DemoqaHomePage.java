package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaHomePage extends PageObject {

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

    @FindBy(id = "menu-item-97")
    private  WebElement sliderBtn;

    @FindBy(id = "menu-item-146")
    private  WebElement datepickerBtn;

    public DemoqaHomePage(WebDriver driver) {
        // add veryfication about if critical elements on the page were loaded correctly.
        super(driver);
    }

    public RegisteryPage registerUser(){
        registrationBtn.click();
        return new RegisteryPage(driver);
    }
    public SliderPage sliderClick(){
        sliderBtn.click();
        return new SliderPage(driver);
    }
    public DroppablePage droppableClick(){
        droppableBtn.click();
        return new DroppablePage(driver);
    }
    public DraggablePage draggableClick(){
        draggableBtn.click();
        return new DraggablePage(driver);
    }
    public DatepickerPage datepickerClick(){
        datepickerBtn.click();
        return new DatepickerPage(driver);
    }

}
