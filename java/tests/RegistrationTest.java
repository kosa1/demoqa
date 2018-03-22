package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DemoqaHomePage;
import pageObjects.RegisteryPage;
import utilities.Utilities;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    WebDriver driver = null;
    String baseUrl = "http://demoqa.com/";
    String filePath = "C:\\Users\\Lukasz\\Desktop\\mavenTest\\testshop\\src\\test\\java\\testData\\testDataRegistration2.xlsx";
    String fileName = "testDataRegistration2.xlsx";
    String sheetName = "Registration2";
    String correctRegistration = "Thank you for your registration";
    DemoqaHomePage homePage = null;

    @DataProvider
    public Object[][] registrationDataProvider() throws Exception {
        Object[][] regObjectArray;
        regObjectArray = Utilities.getTableArrayExcel(filePath,sheetName);
        return  (regObjectArray);
    }

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        // It means that if the element is not located on the web page within that time frame, it will throw an exception.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test(dataProvider = "registrationDataProvider")
    public void registrationTest(String firstName, String lastName, String maritalStatus, String hobby, String country,
                                 String month, String day, String year,String phoneNumber, String username, String email,
                                 String profilePicture, String aboutYourself, String password)
    {
        RegisteryPage registeryPage;
        homePage = new DemoqaHomePage(driver);
        registeryPage = homePage.registerUser();
        /* some test test test */
        registeryPage.setFirstName(firstName)
                .setLastName(lastName)
                .setMartalStatus(maritalStatus)
                .setHobby(hobby)
                .setCountrySelect(country)
                .setMonthSelect(month)
                .setDaySelect(day)
                .setYearSelect(year)
                .setPhoneNumber(phoneNumber)
                .setUserName(username)
                .setEmailAddress(email)
                .setProfilePictureFile(profilePicture)
                .setAboutYourself(aboutYourself)
                .setPassword(password)
                .setPasswordConfirm(password)
                .setSubmit();
        WebElement correctBox = driver.findElement(By.className("piereg_message"));
        //System.out.println("tekst to: "+correctBox.getText());
        Assert.assertEquals(correctBox.getText(),correctRegistration);
        Utilities.takeScrenshot(driver);

    }
    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
