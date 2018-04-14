package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class DroppablePage extends PageObject {

    /* ----------------------DEFAULT FUNCTIONALITY-------------------------------*/
    @FindBy(id="ui-id-1")
    public WebElement defaultFunctionalityTab;

    @FindBy(id="draggableview")
    public WebElement dragView;

    @FindBy(id="droppableview")
    public WebElement dropView;
    /* --------------------------------------------------------------------------*/
    @FindBy(id="ui-id-2")
    public WebElement acceptTab;

    @FindBy(id="draggable-nonvalid")
    public WebElement draggableBox;

    @FindBy(id="draggableaccept")
    public WebElement draggableBox2;

    @FindBy(id="droppableaccept")
    public WebElement dropAccept;
    /* --------------------------------------------------------------------------*/

    @FindBy(id="ui-id-3")
    public WebElement preventPropagationTab;

    @FindBy(id="ui-id-4")
    public WebElement revertPositionTab;

    @FindBy(id="ui-id-5")
    public WebElement shoppingCartDemoTab;

    @FindBy(xpath = "//*[@id=\"ui-id-7\"]/ul/li[1]")
    public WebElement lolcatShirt;

    @FindBy(id="ui-id-8")
    public WebElement bagsTab;

    @FindBy(xpath = "//*[@id=\"ui-id-9\"]/ul/li[3]")
    public WebElement alligatorLeather;

    @FindBy(xpath = "//*[@id=\"ui-id-11\"]/ul/li[2]")
    public WebElement ipod;

    @FindBy(xpath = "//*[@id=\"cart\"]/div/ol")
    public WebElement shoppingCart;

    @FindBy(id="ui-id-10")
    public WebElement gadgetsTab;

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage acceptTabClick(){
        acceptTab.click();
        return this;
    }

    public DroppablePage dragAndDropElement(){
        Actions act = new Actions(driver);
        act.dragAndDrop(dragView, dropView).build().perform();
        return this;
    }

    public void acceptDragAndDrop(){
        Actions act = new Actions(driver);
        act.dragAndDrop(draggableBox,dropAccept).build().perform();
        act.dragAndDrop(draggableBox2,dropAccept).build().perform();
    }

    public DroppablePage shoppingCartTabClick(){
        shoppingCartDemoTab.click();
        return this;
    }

    public void gadgetsTabClick(){
        gadgetsTab.click();
    }

    public void addProductsToCard(){
        Actions act = new Actions(driver);
        act.dragAndDrop(lolcatShirt,shoppingCart).build().perform();
        bagsTab.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        act.dragAndDrop(alligatorLeather,shoppingCart).build().perform();
    }
}
