package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.util.ArrayList;

import static utility.Constants.DRIVER_EXT;

public class DriverInitilization {

    EnvProperty envProperty;
    WebDriver driver;
    String parentWindow;

    public DriverInitilization(EnvProperty envProperty) {
        this.envProperty = envProperty;
    }

    public WebDriver getDriver() {
        if (this.driver == null) {
            this.driver = initilizingWebDriver();
            this.parentWindow = driver.getWindowHandle();
            //this.driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver initilizingWebDriver() {
        String browser = envProperty.getConfigPropertyValue("DEFAULT", "browser").toLowerCase();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browser);
        String path = System.getProperty("user.dir");
        String absolutePath = path.replace("\\", "\\\\");
        switch (browser) {

            case "internet explorer":
                desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                return new InternetExplorerDriver(desiredCapabilities);
            case "firefox":
                System.setProperty("webdriver.gecko.driver", absolutePath + "\\resources\\geckodriver.exe");
                return new FirefoxDriver(desiredCapabilities);
            case "chrome":
                System.setProperty("webdriver.chrome.silentOutput", "true");
                System.setProperty("webdriver.chrome.driver", getDriverPath("chromedriver"));
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized");
                co.addArguments("--incognito");
                co.addArguments("--enable-automation");
//                co.addArguments("--disable-infobars");
//                co.addArguments("--ignore-certifcate-errors");
//                co.addArguments("test-type");
//                co.addArguments("--disable-gpu");
//                co.addArguments("--disable-dev-shm-usage");
//                co.addArguments("--window-size=1920x1080");
//                co.addArguments("--disable-extensions");
//                co.addArguments("--no-sandbox");
//                co.addArguments("--disable-default-apps");
//                co.addArguments("--disable-background-networking");
//                co.addArguments("--disable-background-timer-throttling");
//                co.addArguments("--disable-breakpad");
//                co.addArguments("--disable-client-side-phishing-detection");
//                co.addArguments("--disable-features=site-per-process");
//                co.addArguments("--disable-hang-monitor");
//                co.addArguments("--disable-popup-blocking");
//                co.addArguments("--disable-prompt-on-repost");
//                co.addArguments("--disable-sync");
//                co.addArguments("--disable-translate");
//                co.addArguments("--metrics-recording-only");
//                co.addArguments("--no-first-run");
//                co.addArguments("--safebrowsing-disable-auto-update");
//                co.addArguments("--password-store=basic");
//                co.addArguments("--use-mock-keychain");
//                co.addArguments("--hide-scrollbars");
//                co.addArguments("--mute-audio");
//                co.addArguments("--whitelisted-ips");
                return new ChromeDriver(co);
            default:
        }
        Assert.fail("Unable to initilize WebDriver Instance");

        return null;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            parentWindow = null;
        }
    }
    public String getDriverPath(String drivername){
        String driver = drivername+DRIVER_EXT;
        return ("lib/drivers/windows/"+driver);
    }

//    public void getDriverUrl() {
//        try {
//            //envProperty = EnvProperty.getInstance(AppConstants.PAYMENT_INI);
//            properties = new Properties();
//            in = new FileInputStream("src/test/resources/env.properties");
//            properties.load(in);
//            Key = properties.getProperty("key");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        if ("local".equals(Key)) {
//            System.setProperty("webdriver.chrome.driver", absolutePath + "\\src\\test\\resources\\chromedriver.exe");
//        } else if ("jenkins".equals(Key)) {
//            System.setProperty("webdriver.chrome.driver", "/opt/selenium/drivers/chromedriver");
//        }
//    }
}
