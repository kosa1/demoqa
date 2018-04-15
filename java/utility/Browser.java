package utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    static String hubUrl = "http://localhost:4444/wd/hub";

    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), getBrowserCapabilities(browser));
    }

    private static DesiredCapabilities getBrowserCapabilities(String browserType) {

        if (browserType.equals("firefox")) {
            System.out.println("Opening firefox driver");
            return DesiredCapabilities.firefox();
        }
        else if (browserType.equals("chrome")) {
            System.out.println("Opening chrome driver");
            return DesiredCapabilities.chrome();
        }
        else if(browserType.equals("IE")){
            System.out.println("Opening IE driver");
            return DesiredCapabilities.internetExplorer();
        }
        else{
            System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
            return DesiredCapabilities.firefox();
        }
    }
}
