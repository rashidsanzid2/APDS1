package pageobjects;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbcCommonAbstractPage<HomePage> {
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private String configUrl = "baseUrl";
    private By findOwner = By.xpath("//a[@title='find owners']");
    private By addOwner = By.xpath("//a[text()='Add Owner']");

    public HomePage click_On_Find_Owner() {
        logger.info("click_On_findOwner");
        return click(findOwner);
    }

    public HomePage click_On_Add_Owner() {
        logger.info("click_On_findOwner");
        return click(addOwner);
    }

    public HomePage launch_Pet_Clinic_Application() {
        logger.info("user launch the url");
        loadUrl(configUrl);
        return me();
    }


}
