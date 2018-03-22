package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utilities.Utilities.addRandomData;

public class RegisteryPage extends PageObject {

    protected WebDriver driver = null;

    @FindBy(id = "name_3_firstname")
    private WebElement firstName;

    @FindBy(id = "name_3_lastname")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
    private WebElement singleOption;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[2]")
    private WebElement marriedOption;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[3]")
    private WebElement divorcedOption;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div[1]/input[1]")
    private  WebElement danceOption;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div/input[2]")
    private WebElement readingOption;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div/input[3]")
    private WebElement cricketOption;

    @FindBy(id = "dropdown_7")
    private  WebElement countrySelect;

    @FindBy(id = "mm_date_8")
    private  WebElement monthSelect;

    @FindBy(id = "dd_date_8")
    private  WebElement daySelect;

    @FindBy(id = "yy_date_8")
    private  WebElement yearSelect;

    @FindBy(id="phone_9")
    private WebElement phoneNumber;

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id = "email_1")
    private WebElement emailAddress;

    @FindBy(id="profile_pic_10")
    private WebElement profilePictureFile;

    @FindBy(id = "description")
    private WebElement aboutYourself;

    @FindBy(id = "password_2")
    private WebElement password;

    @FindBy(id = "confirm_password_password_2")
    private WebElement passwordConfirm;

    @FindBy(name = "pie_submit")
    private  WebElement submit;


    public RegisteryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisteryPage setFirstName(String firstName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        return this;
    }

    public RegisteryPage setLastName(String lastName) {
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        return this;
    }

    public RegisteryPage setSingleOption(String singleOption) {
        this.singleOption.click();
        return this;
    }

    public RegisteryPage setMarriedOption(String marriedOption) {
        this.marriedOption.click();
        return this;
    }

    public RegisteryPage setDivorcedOption(String divorcedOption) {
        this.divorcedOption.click();
        return this;
    }

    public RegisteryPage setDanceOption(String danceOption) {
        this.danceOption.click();
        return this;

    }

    public RegisteryPage setReadingOption(String readingOption) {
        this.readingOption.click();
        return this;
    }

    public RegisteryPage setCricketOption(String cricketOption) {
        this.cricketOption.click();
        return this;
    }

    public RegisteryPage setCountrySelect(String countrySelect) {
        Select cs = new Select(this.countrySelect);
        cs.selectByValue(countrySelect);
        return this;
    }

    public RegisteryPage setMonthSelect(String monthSelect) {
        Select ms = new Select(this.monthSelect);
        ms.selectByValue(monthSelect);
        return this;
    }

    public RegisteryPage setDaySelect(String daySelect) {
        Select ds = new Select(this.daySelect);
        ds.selectByValue(daySelect);
        return this;
    }

    public RegisteryPage setYearSelect(String yearSelect) {
        Select ys = new Select(this.yearSelect);
        ys.selectByValue(yearSelect);
        return this;
    }

    public RegisteryPage setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
        return this;
    }

    public RegisteryPage setUserName(String userName) {
        userName = addRandomData(userName);
        this.userName.sendKeys(userName);
        return this;
    }

    public RegisteryPage setEmailAddress(String emailAddress) {
        emailAddress = addRandomData(emailAddress);
        this.emailAddress.sendKeys(emailAddress);
        return this;
    }

    public RegisteryPage setProfilePictureFile(String profilePictureFile) {
        this.profilePictureFile.sendKeys(profilePictureFile);
        return this;
    }

    public RegisteryPage setAboutYourself(String aboutYourself) {
        this.aboutYourself.sendKeys(aboutYourself);
        return this;
    }

    public RegisteryPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public RegisteryPage setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm.sendKeys(passwordConfirm);
        return this;
    }
    public void setSubmit() {
        this.submit.click();

    }
    public void setForm(String firstName, String lastName, String maritalStatus) {
        setFirstName(firstName);
        setLastName(lastName);
        setMartalStatus(maritalStatus);
    }

    public void setLastName(WebElement lastName) {
        this.lastName = lastName;
    }

    public RegisteryPage setMartalStatus(String option) {
        if(option.equals("Single")){
            setSingleOption(option);
            return this;
        }
        else if (option.equals("Married")){
            setMarriedOption(option);
            return this;
        }
        else if (option.equals("Divorced")){
            setDivorcedOption(option);
            return this;
        }
        return null;
    }

    public RegisteryPage setHobby(String option)
    {
        if(option.equals("Dance")){
            setDanceOption(option);
            return this;

        }
        else if (option.equals("Reading")){
            setReadingOption(option);
            return this;

        }
        else if (option.equals("Cricket")){
            setCricketOption(option);
            return this;

        }
        return null;
    }


}
