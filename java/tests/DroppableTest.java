package tests;

import org.testng.annotations.*;
import pageObjects.DemoqaHomePage;
import pageObjects.DroppablePage;


public class DroppableTest extends TestBase {

    private DroppablePage droppablePage;
    private DemoqaHomePage  homePage;

    @Test(priority = 0)
    public void setUp(){
        droppablePage = new DroppablePage(driver);
        homePage = new DemoqaHomePage(driver);
        droppablePage = homePage.droppableClick();
    }

    @Test(priority = 1)
    public void defaultFunctionality(){
        droppablePage.dragAndDropElement();
    }

    @Test(priority = 2)
    public void accept(){
        droppablePage.acceptTabClick()
                .acceptDragAndDrop();
    }

    @Test(priority = 3)
    public void shoppingCartDemo(){
       // not working on firefox
        droppablePage.shoppingCartTabClick()
                .addProductsToCard();
    }
}
