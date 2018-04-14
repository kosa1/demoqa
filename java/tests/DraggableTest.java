package tests;

import org.testng.annotations.*;
import pageObjects.DemoqaHomePage;
import pageObjects.DraggablePage;

public class DraggableTest extends TestBase {

    DraggablePage draggablePage;
    private DemoqaHomePage homePage;

    @Test(priority = 0)
    public void setUp(){
        draggablePage = new DraggablePage(driver);
        homePage = new DemoqaHomePage(driver);
        draggablePage = homePage.draggableClick();
    }

    @Test(priority = 1)
    @Parameters({"xValue", "yValue"})
    public void defaultFunctionality(@Optional("200") String xValue, @Optional("100") String yValue){
        draggablePage.moveElement(Integer.parseInt(xValue),Integer.parseInt(yValue));
    }

    @Test(priority = 2)
    public void constrainMovement() {
        draggablePage.constrainMovementClick()
               .constrainMovementVertically(50)
               .constrainMovementHorizontally(100);
    }
    @Test(priority = 3)
    public void cursorStyle() throws InterruptedException {
        draggablePage.cursorStyleClick()
                .cursorStyleDrag(100,200)
                .cursorStyleDrag2(80,160);
    }

    @Test(priority = 4)
    public void draggableAndSortable(){
        draggablePage.draggabbleAndSortableClick()
                .dragBoxBeforeItem(4);
    }
}
