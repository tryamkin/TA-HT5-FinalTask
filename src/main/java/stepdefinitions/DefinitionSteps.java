package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.PagesManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DefinitionSteps {
    private static final long TIMEOUT=30;
    private static final String REGISTER_PAGE ="https://signup.ebay.com/pa/crte?ru=";
    WebDriver driver;
    PagesManager pagesManager;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    WatchlistPage watchlistPage;
    SearchPage searchPage;

@Before
    public void setupTest(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    pagesManager = new PagesManager(driver);
    homePage = pagesManager.gethomePage();
    registerPage = pagesManager.getregisterPage();
    loginPage = pagesManager.getloginPage();
    searchPage = pagesManager.getsearchPage();
    watchlistPage = pagesManager.getwatchlistPage();
}

    @After
    public void closeDriver(){

        driver.manage().deleteAllCookies();
        driver.quit() ;
    }



@And("User open {string} site")

public void openPage(String url){
    homePage.implisityWait(TIMEOUT);
    homePage.openPage(url);
   // homePage.waitForPageLoadComplete(10);

}

    @When("I see correct home page")
    public void iSeeCorrectHomePage() {
    homePage.pageName();
        }



    @Then("I sure what page {string} page")
    public void iSureWhatPageEqualsPage(String homepage) {
        homePage.waitForPageLoadComplete(10);
        Assert.assertEquals(homePage.pageName(),homepage);
    }

    @When("I want to be able to register")
    public void iWantToBeAbleToRegister() {
    homePage.registerClick();
    homePage.waitForPageLoadComplete(30);

    }

    @Then("I see registration {string} name")
    public void iSeeRegistrationFormName(String registerPage) {
        Assert.assertEquals(homePage.registerPageName(),registerPage);
    }


    @Given("User open registration form")
    public void userOpenRegistrationForm() throws InterruptedException {
    openPage(REGISTER_PAGE);

    }

    @When("I want to enter {string}, {string}, {string}, {string}")
    public void iWantToEnterFirstNameLastNameEMailPassword
            (String username,String lastname,String eMail,String password ) throws InterruptedException {
    registerPage.getUserName(username);
    registerPage.getLastName(lastname);
    registerPage.geteMail(eMail);
    registerPage.getPassword(password);
       // Thread.sleep(5000);
        registerPage.getSubmitButton();
    }


    @And("I want Create accaunt")
    public void iWantCreateAccaunt() {
        registerPage.getSubmitButton();
    }


    @Then("I see warning page what an {string} already exists")
    public void iSeeWarningPageWhatAnAccountAlreadyExists(String message) {
        Assert.assertEquals(registerPage.setExistmessage(),message);
    }

    @Given("User open {string}  site")
    public void userOpenPageSite(String url) {
    openPage(url);
    }

    @When("User open login form")
    public void userOpenLoginForm() {
    homePage.loginClick();

    }
    @And("Enter incorect {string}")
    public void enterIncorectEMail(String email) {
        loginPage.enterEmailForm(email);
        homePage.implisityWait(10);
        loginPage.setConfirmEmailButtononfirmEmail();
    }

    @Then("I see error message on the page")
    public void iSeeErrorMessageOnThePage() {
        System.out.println(loginPage.setErrorMessage());
        Assert.assertFalse(loginPage.setErrorMessage().contains("login"));
    }

    @Then("I see error {string} on the page")
    public void iSeeErrorOnThePage(String arg0) {
        System.out.println(loginPage.setErrorMessage());
        System.out.println(arg0);
        Assert.assertEquals(loginPage.setErrorMessage(),arg0);
    }

    @Given("User open home {string} site")
    public void userOpenHomePageSite(String url) {
        homePage.openPage(url);
    }

    @When("User {string} product")
    public void userProduct(String arg0) {
    searchPage.setSearchField(arg0);
    }

    @When("User see {int} of products")
    public void userSeeListOfProducts(int size) {
    searchPage.sarchResults();
    searchPage.sieofSearchEl();
    searchPage.SearchresultsItems();
    Assert.assertTrue(searchPage.sieofSearchEl()>size);

    }


    @And("User enter credentials {string},{string}")
    public void userEnterCredentialsEMailPassword(String email, String pass) throws InterruptedException {
        loginPage.enterEmailForm(email);
        homePage.implisityWait(10);
        loginPage.setConfirmEmailButtononfirmEmail();
        loginPage.enterPassForm(pass);
    }

    @Then("User authorisation")
    public void userAuthorisation()  {
    Assert.assertEquals(homePage.pageName(),"eBay");
    }
}
