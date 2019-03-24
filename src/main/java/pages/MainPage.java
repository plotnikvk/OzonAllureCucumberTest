package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class MainPage extends BasePageObject {

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='close-icon eDYbanner_close jsCloseBanner']")
    public WebElement closeBanner;

    @FindBy(xpath = "//a[@data-test-id='header-navigation-link']")
    public List<WebElement> menuItems;
}
