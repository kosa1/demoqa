package tests;

import org.testng.annotations.*;
import pageObjects.DatepickerPage;
import pageObjects.DemoqaHomePage;

public class DatepickerTest extends TestBase {

    DatepickerPage datePickerPage;
    DemoqaHomePage homePage;

    @Test
    public void datePickertest(){
        homePage = new DemoqaHomePage(driver);
        datePickerPage = homePage.datepickerClick();
        datePickerPage.getDatePickerInput().click();
        // setting 10.03.2017
        datePickerPage.setDate("13", "June", "2017");

    }

}
