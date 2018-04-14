package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageObjects.DemoqaHomePage;
import utilities.Browser;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    RemoteWebDriver driver;
    String baseUrl;


    public TestBase(){

        baseUrl = "http://demoqa.com/";
    }

    @BeforeClass
    @Parameters({ "browser" })
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        System.out.println("initializing the webdriver");
        driver = Browser.getDriver(browser);
        // It means that if the element is not located on the web page within that time frame, it will throw an exception.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finishing test");
        driver.quit();
    }
}
