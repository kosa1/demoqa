package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends PageObject {

    @FindBy(id = "slider-range-max")
    public WebElement sliderBar;

    @FindBy(xpath = "//*[@id=\"slider-range-max\"]/span")
    public WebElement sliderHandle;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void setSliderHandle(String value){

      Actions act = new Actions(driver);
      // get the width of slider
      Dimension sliderSize = sliderBar.getSize();
      int sliderWidth = sliderSize.getWidth();

      if(value.equals("2")){

      }
      else if(value.equals("1")){
          act.dragAndDropBy(sliderHandle,-50,0).build().perform();
      }
      else{

          int x = Integer.parseInt(value);
          act.dragAndDropBy(sliderHandle,(x-2)*70,0).build().perform();
      }

      //act.dragAndDropBy(sliderHandle,50,0).build().perform();


    }
}
