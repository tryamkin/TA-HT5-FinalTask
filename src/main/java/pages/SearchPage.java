package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;
    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;
    @FindBy(xpath = "//*[contains(text(),'Russian warship')]")
    private List<WebElement> searchResults;


    public void setSearchField(String search) {
        searchField.sendKeys(search);
        searchButton.click();
    }

    public List<WebElement> sarchResults() {
        return searchResults;
    }

    public int sieofSearchEl() {
        return searchResults.size();
    }

    public void SearchresultsItems() {

        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println(searchResults.get(i).getText());
        }
    }
}