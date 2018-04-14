package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.DemoqaHomePage;
import pageObjects.RegisteryPage;
import utilities.Utilities;

public class RegistrationTest extends TestBase {

   // public RemoteWebDriver driver; // variable can not be static
    //String baseUrl = "http://demoqa.com/";
    String filePath = "C:\\Users\\Lukasz\\Desktop\\mavenTest\\testshop\\src\\test\\java\\testData\\testDataRegistration2.xlsx";
    String fileName = "testDataRegistration2.xlsx";
    String sheetName = "Registration2";
    String correctRegistration = "Thank you for your registration";
    RegisteryPage registeryPage;
    DemoqaHomePage homePage;

    @DataProvider
    public Object[][] registrationDataProvider() throws Exception {
        Object[][] regObjectArray;
        regObjectArray = Utilities.getTableArrayExcel(filePath,sheetName);
        return (regObjectArray);
    }

    @Test(dataProvider = "registrationDataProvider")
    public void registrationTest(String firstName, String lastName, String maritalStatus, String hobby, String country,
                                 String month, String day, String year,String phoneNumber, String username, String email,
                                 String profilePicture, String aboutYourself, String password)
    {

        registeryPage = new RegisteryPage(driver);
        homePage = new DemoqaHomePage(driver);
        registeryPage = homePage.registerUser();
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
        WebElement correctBox = registeryPage.getPositiveBox();
        Utilities.takeScrenshot(driver);
        Assert.assertEquals(correctBox.getText(),correctRegistration);
    }
}
