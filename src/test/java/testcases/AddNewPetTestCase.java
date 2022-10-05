package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.FindOwnerPage;
import pageobjects.FindPetPage;
import pageobjects.HomePage;
import ui.AbstractAutoUITest;

public class AddNewPetTestCase extends AbstractAutoUITest {
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @BeforeClass
    public void launchWebApplication() {
        logger.info("launch The application");
        getPage(HomePage.class).
                launch_Pet_Clinic_Application();

    }

    @Test
    public void add_Pet() {
        logger.info("Adding Pet");
        getPage(FindOwnerPage.class)
                .click_On_Find_Owners()
                .enter_Last_Name("dyna")
                .click_On_Find_Owner()
                .click_On_Owner()
                .click_On_add_new_pet();
        getPage(FindPetPage.class)
                .enter_Pet_Name("Dog")
                .enter_birth_Date("24-05-1990")
                .click_On_Add_Pet();
    }
}
