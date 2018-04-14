package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatepickerPage extends PageObject {

    @FindBy(id="datepicker1")
    public WebElement datePickerInput;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")
    public WebElement previousButton;

    public DatepickerPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDatePickerInput(){
        return datePickerInput;
    }

    public void setDate(String day, String month, String year){

        WebElement currMonth;
        WebElement currYear ;

        int x = 0;
        while (x < 1000){
            currMonth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"));
            currYear = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]"));
            // do testow
            System.out.println(currMonth.getText());
            System.out.println(currYear.getText());
            x++;
            if(month.equals(currMonth.getText()) && year.equals(currYear.getText())){
               // System.out.println("przed lista");
                List<WebElement> cuuDate = driver.findElements(By.className("ui-state-default"));
                System.out.println("wszedlem do ifa");
                // wypisanie listy do testow
                for (WebElement element: cuuDate) {
                    //System.out.println(element.getText());
                    if(element.getText().equals(day)){
                        element.click();
                        break;
                    }
                }
                break;
            }
            previousButton.click();
        }
    }
}
