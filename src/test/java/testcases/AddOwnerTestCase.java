package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.FindOwnerPage;
import pageobjects.FindPetPage;
import pageobjects.HomePage;
import ui.AbstractAutoUITest;

public class AddOwnerTestCase extends AbstractAutoUITest {
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @BeforeClass
    public void launchWebApplication() {
        logger.info("launch The application");
        getPage(HomePage.class).
                launch_Pet_Clinic_Application();

    }

    @Test
    public void add_Owner() {
        logger.info("Add Owner");
        getPage(FindOwnerPage.class)
                .click_On_Find_Owners()
                .click_On_Add_Owner()
                .fill_Owner_form()
                .click_On_Add_Owner_Btn();
    }
}
