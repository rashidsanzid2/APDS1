package pageobjects;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewVisitPage extends AbcCommonAbstractPage<NewVisitPage> {
    String name;
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private String configUrl = "baseUrl";
    private By description = By.xpath("//input[@id='description']");
    private By addVisit = By.xpath("//button[text()='Add Visit']");
    private By date = By.xpath("//input[@id='date']");

    public NewVisitPage enter_description(String desc) {
        logger.info("description");
        return enter(description, desc);
    }

    public NewVisitPage enter_appointment_date(String appointmentdate) {
        logger.info("date");
        return enter(date, appointmentdate);
    }

    public NewVisitPage click_On_Add_Visit() {
        logger.info("click_On_Add_Visit");
        return click(addVisit);
    }

}
