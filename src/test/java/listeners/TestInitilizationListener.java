package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import utility.DriverInitilization;
import utility.EnvProperty;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestInitilizationListener extends TestListenerAdapter {
    private static final String pattern = "%d{HH:mm:ss.SSS} %-5level %logger{0} - %msg%n";


    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        context.setAttribute( DriverInitilization.class.getName(), new DriverInitilization((EnvProperty)context.getSuite().getAttribute( EnvProperty.class.getName())));

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test is starting... " + result.getTestClass().getRealClass().getSimpleName() + " --> " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test has been Passed... " + result.getTestClass().getRealClass().getSimpleName() + " --> " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test is Skipped... " + result.getTestClass().getRealClass().getSimpleName() + " --> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss_SSS");
        System.err.println("Test Failed... " + result.getTestClass().getRealClass().getSimpleName() + " --> " + result.getName());
        DriverInitilization driverInitilization = (DriverInitilization) result.getTestContext().getAttribute(DriverInitilization.class.getName());
        if (driverInitilization.getDriver() != null) {
            TakesScreenshot screenShot = ((TakesScreenshot) driverInitilization.getDriver());
            File file = screenShot.getScreenshotAs(OutputType.FILE);
            Path content = Paths.get(String.valueOf(file));
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment(result.getMethod().getMethodName() + "_" + dateFormat.format(new Date(result.getEndMillis())), "image/png", is, ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        DriverInitilization driverInitilization=(DriverInitilization) testContext.getAttribute( DriverInitilization.class.getName());
       // driverInitilization.quitDriver();
    }


}
