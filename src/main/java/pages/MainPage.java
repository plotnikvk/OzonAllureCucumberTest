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

    @FindBy(xpath = "//ul//a[contains(@class,'link')]")
    public List<WebElement> menuItems;
}
