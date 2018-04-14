package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggablePage extends PageObject  {

    @FindBy(partialLinkText =  "Default functionality")
    private WebElement defaultFunctionality;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(linkText = "Constrain movement")
    private  WebElement constrainMovement;

    @FindBy(id = "draggabl")
    private  WebElement verticallyElement;

    @FindBy(id="draggabl2")
    private  WebElement horizontallyElement;

    @FindBy(id="ui-id-3")
    private WebElement cursorStyle;

    @FindBy(id="drag")
    private WebElement dragMouse;

    @FindBy(id="drag2")
    private WebElement dragMouse2;

    @FindBy(id="ui-id-5")
    private WebElement draggabbleAndSortable;

    @FindBy(id = "draggablebox")
    private WebElement draggablebox;

    @FindBy(id="sortablebox")
    private WebElement draggableUl;

    public DraggablePage(WebDriver driver) {
        super(driver);
      //  this.driver = driver;
    }

    public DraggablePage moveElement(int x, int y){
        Actions act = new Actions(driver);
                act.dragAndDropBy(draggableElement,x,y).build().perform();
        return this;
    }

    public DraggablePage constrainMovementClick(){
        constrainMovement.click();
        return this;
    }
    public DraggablePage constrainMovementVertically(int y){
        Actions act = new Actions(driver);
        act.dragAndDropBy(verticallyElement,0,y).build().perform();
        // alternative
       // act.clickAndHold(verticallyElement).moveByOffset(0,y).release().perform();
        return this;
    }

    public DraggablePage constrainMovementHorizontally(int x){
        Actions act = new Actions(driver);
        act.dragAndDropBy(horizontallyElement,x,0).build().perform();
        return this;
    }

    public DraggablePage cursorStyleDrag(int x, int y){
        Actions act = new Actions(driver);
        act.clickAndHold(dragMouse).moveByOffset(x,y).release().perform();
        return this;
    }
    public DraggablePage cursorStyleDrag2(int x, int y) throws InterruptedException {
        //Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.clickAndHold(dragMouse2).moveByOffset(x,y).release().perform();
        System.out.println(dragMouse2.getText());
        return this;
    }
    public DraggablePage cursorStyleClick() {
        cursorStyle.click();
        return this;
    }

    public DraggablePage draggabbleAndSortableClick(){
        draggabbleAndSortable.click();
        return this;
    }

    public List<WebElement> getListOfDraggableElements(){
        List<WebElement> draggableElementsList = draggableUl.findElements(By.tagName("li"));
        return draggableElementsList;
    }

    public void dragBoxBeforeItem(int numberOfItem){
        WebElement item = getListOfDraggableElements().get(numberOfItem-1);
        Actions act  = new Actions(driver);
        act.dragAndDrop(draggablebox, item).perform();
    }

}
