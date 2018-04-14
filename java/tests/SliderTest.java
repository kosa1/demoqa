package tests;


import org.testng.annotations.*;
import pageObjects.DemoqaHomePage;
import pageObjects.SliderPage;


public class SliderTest extends TestBase {

    SliderPage sliderPage;
    DemoqaHomePage homePage;

    @Test(dataProvider = "sliderValuesDataProvider")
    public void sliderTest(String index, String value){
        homePage = new DemoqaHomePage(driver);
        sliderPage = homePage.sliderClick();
        sliderPage.setSliderHandle(value);
    }

    @DataProvider
    public Object[][] sliderValuesDataProvider() throws Exception {
        return new Object[][]{
                {"1", "1"},
                {"2", "2"},
                {"3", "3"},
                {"4", "4"},
                {"5", "5"},
                {"6", "6"},
                {"7", "7"},
                {"8", "8"},
                {"9", "9"},
                {"10", "10"}
        };
    }
}
