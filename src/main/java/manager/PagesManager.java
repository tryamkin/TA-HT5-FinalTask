package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class PagesManager {
    WebDriver driver;

    public PagesManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage gethomePage(){
        return new HomePage(driver);
    }


}
