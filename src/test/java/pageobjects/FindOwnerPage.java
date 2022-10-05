package pageobjects;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOwnerPage extends AbcCommonAbstractPage<FindOwnerPage> {
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private String configUrl = "baseUrl";
    private By findOwners = By.xpath("//a[@title='find owners']");
    private By findOwner = By.xpath("//button[@type='submit']");
    private By addOwner = By.xpath("//a[text()='Add Owner']");
    private By firstName = By.xpath("//input[@name='firstName']");
    private By lastName = By.xpath("//input[@name='lastName']");
    private By address = By.xpath("//input[@name='address']");
    private By city = By.xpath("//input[@name='city']");
    private By telephone = By.xpath("//input[@name='telephone']");
    private By addOwnerBtn = By.xpath("//button[text()='Add Owner']");
    private By ownerName = By.xpath("(//a[text()='Molly Dyna'])[1]");
    private By addNewPet = By.xpath("//a[contains(text(),'New Pet')]");

    public FindOwnerPage click_On_add_new_pet() {
        logger.info("click_On_add_new_pet");
        return click(addNewPet);
    }

    public FindOwnerPage click_On_Find_Owners() {
        logger.info("click_On_findOwner");
        return click(findOwners);
    }

    public FindOwnerPage click_On_Find_Owner() {
        logger.info("click_On_findOwner");
        return click(findOwner);
    }

    public FindOwnerPage click_On_Add_Owner_Btn() {
        logger.info("click_On_addOwnerBtn");
        return click(addOwnerBtn);
    }

    public FindOwnerPage click_On_Add_Owner() {
        logger.info("click_On_Add_Owner");
        return click(addOwner);
    }

    public FindOwnerPage click_On_Owner() {
        logger.info("click_On_Add_Owner");
        return click(ownerName);
    }

    public FindOwnerPage enter_Last_Name(String lastNm) {
        logger.info("enter_Last_Name");
        return enter(lastName, lastNm);
    }

    public FindOwnerPage fill_Owner_form() {
        enter(firstName, "Molly")
                .enter(lastName, "dyna")
                .enter(address, "Main Street")
                .enter(city, "Thailand")
                .enter(telephone, "125455");
        return me();

    }

    public FindOwnerPage validate_visit() {
        logger.info("click_On_Add_Owner");
        return click(ownerName);
    }

}
