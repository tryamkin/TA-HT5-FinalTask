package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement enterEmail;
    @FindBy(xpath = "//input[@id='pass']")
    private WebElement enterPass;
    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement confirmEmailButton;
    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signIn;
    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement confirmPassButton;
    @FindBy(xpath = "//p[@id='errormsg']")
    private WebElement errorMessage;



    public void enterEmailForm(String email){
         enterEmail.sendKeys(email);
    }
    public void setConfirmEmailButtononfirmEmail() {
        confirmEmailButton.click();
    }

    public void enterPassForm(String pass) throws InterruptedException {
        enterPass.sendKeys(pass);
      try {
          confirmPassButton.click();
      } catch (Exception e) {
          e.printStackTrace();
      }
        Thread.sleep(9000);
    }

    public String setErrorMessage()  {

        return  errorMessage.getText();
    }

}
