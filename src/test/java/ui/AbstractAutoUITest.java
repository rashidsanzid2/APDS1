package ui;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import utility.DriverInitilization;
import utility.EnvProperty;

import java.lang.reflect.Field;

public class AbstractAutoUITest {
    private ITestContext context;
    private EnvProperty envProperty;
    private DriverInitilization driverInitilization;

    @BeforeClass( alwaysRun = true)
    public void init(ITestContext context) {
        this.context = context;
        this.driverInitilization = (DriverInitilization) context.getAttribute( DriverInitilization.class.getName());
        this.envProperty = (EnvProperty) context.getSuite().getAttribute( EnvProperty.class.getName());

    }

    public <T extends AbstractPage<T>> T getPage(Class<T> pageClass) {

        return get(pageClass,driverInitilization.getDriver());
    }
    public <T extends AbstractPage<T>> T get(Class<T> pageClass, WebDriver driverValue) {


        try {
            T page=pageClass.newInstance();

            Field fieldDriver = AbstractPage.class.getDeclaredField("driver");
            fieldDriver.setAccessible(true);
            fieldDriver.set(page, driverValue);

            Field fieldEnvProperty= AbstractPage.class.getDeclaredField("envProperty");
            fieldEnvProperty.setAccessible(true);
            fieldEnvProperty.set(page, this.envProperty);

            return page;
        } catch (InstantiationException | IllegalAccessException  | NoSuchFieldException | SecurityException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
