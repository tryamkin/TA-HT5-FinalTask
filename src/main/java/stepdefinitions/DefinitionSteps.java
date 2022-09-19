package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.PagesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class DefinitionSteps {
    private static final long TIMEOUT=30;
    WebDriver driver;
    PagesManager pagesManager;
    HomePage homePage;

@Before
    public void setupTest(){
    WebDriverManager.chromedriver().setup();

    driver=new ChromeDriver();
    driver.manage().window().maximize();

    pagesManager = new PagesManager(driver);

}
@And("User open {string} site")

public void openPage(String url){
    homePage = pagesManager.gethomePage();
    homePage.implisityWait(TIMEOUT);
    homePage.openPage(url);


}

    @When("ok")
    public void ok() {
        System.out.println("ok");

    }

    @Then("ob")
    public void ob() {
        System.out.println("ob");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

}
