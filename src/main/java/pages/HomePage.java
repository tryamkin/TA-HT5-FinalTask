package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[normalize-space()='register']")
    private WebElement register;
    @FindBy (xpath = "//span[@id='gh-ug']//a[contains(text(),'Sign in')]")
    private WebElement loginelement;


    public void openPage (String url){
        driver.get(url);
    }

    public String registerPageName (){
        return driver.getTitle();
    }
    public String pageName(){
        String homepage =  driver.getTitle();
        System.out.println(driver.getTitle());
        String ebayName=homepage.substring(homepage.length() - 4);
        return ebayName;
    }

    public void registerClick(){
        register.click();
    }

    public void loginClick(){
        loginelement.click();
    }


}
