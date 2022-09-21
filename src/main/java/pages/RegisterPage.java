package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstname']")private WebElement userName;
    @FindBy(xpath = "//input[@id='lastname']")private WebElement lastName;
    @FindBy(xpath = "//input[@id='Email']")private WebElement eMail;
    @FindBy(xpath = "//input[@id='password']")private WebElement password;
    @FindBy(xpath = "//button[@id='gdpr-banner-accept']")private WebElement accepCoockiesCButton;
    @FindBy(xpath = "//*[@class='btn btn--primary btn--large btn--fluid']")private WebElement submitButton;
    @FindBy(xpath = "//*[contains(text(),'An account already exists')]")private WebElement existmessage;

    public void getUserName(String name) {
        userName.sendKeys(name);
    }

    public void getLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void geteMail(String email) {
        eMail.sendKeys(email);
    }

    public void getPassword(String pass) throws InterruptedException {
        password.sendKeys(pass);
        Thread.sleep(2000);
        accepCoockiesCButton.click();
        password.sendKeys(Keys.ENTER);
    }

    public void getSubmitButton()  {
       waitForPageLoadComplete(10);
      try {
          submitButton.click();
      }catch (Exception e){
          e.getMessage();
      }

    }

    public String  setExistmessage(){
      return  existmessage.getText();
    }

}
