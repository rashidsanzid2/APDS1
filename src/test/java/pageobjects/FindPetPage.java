package pageobjects;


import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindPetPage extends AbcCommonAbstractPage<FindPetPage> {
    String name ;
    protected Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
    private String configUrl = "baseUrl";
    private By petName = By.xpath("//input[@name='name']");
    private By birthDate = By.id("birthDate");
    private By addPet = By.xpath("//button[text()='Add Pet']");
    private By addVisit = By.xpath("//dd[text()='" + name + "']/../..//following-sibling::td//a[contains(text(),'Add')]");

    public FindPetPage enter_Pet_Name(String petNm) {
        logger.info("enter_Pet_Name");
        return enter(petName, petNm);
    }

    public FindPetPage enter_Pet_Name_random() {
        logger.info("enter_Pet_Name");
        name = generate_random_string();
        return enter(petName, name);
    }

    public FindPetPage enter_birth_Date(String petNm) {
        logger.info("enter_Pet_Name");
        return enter(birthDate, petNm);
    }

    public FindPetPage click_On_Add_Pet() {
        logger.info("click_On_Add_Pet");
        return click(addPet);
    }

    public FindPetPage click_On_Add_Visit() {
        logger.info("click_On_Add_Visit");
        String xpathValue = "//dd[text()='" + name + "']/../..//following-sibling::td//a[contains(text(),'Add')]";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(xpathValue);
        scroll_to_element(By.xpath(xpathValue));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return click(By.xpath(xpathValue));
    }

}
