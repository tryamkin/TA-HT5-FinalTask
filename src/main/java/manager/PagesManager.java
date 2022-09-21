package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PagesManager {
    WebDriver driver;

    public PagesManager(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage gethomePage(){ return new HomePage(driver); }
    public RegisterPage getregisterPage (){ return new RegisterPage(driver);}
    public LoginPage getloginPage (){ return new LoginPage(driver);}
    public SearchPage getsearchPage (){ return new SearchPage(driver);}
    public WatchlistPage getwatchlistPage (){ return new WatchlistPage(driver);}

}
