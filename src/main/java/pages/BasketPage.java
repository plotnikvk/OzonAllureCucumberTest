package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.nio.file.WatchEvent;
import java.util.List;

public class BasketPage extends BasePageObject {

    public BasketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class, 'RemoveAll')]")
    public WebElement removeAllButton;

    @FindBy(xpath = "//span[@class='eCartItem_nameValue']")
    public List<WebElement> addedProductList;

    @FindBy(xpath = "//div[@class = 'eRemovedCartItems_removeAll jsRemoveAll']")
    public WebElement closeRemoveWindow;

    @FindBy(xpath = "//span[@class='jsInnerContentpage_title']")
    public WebElement emptyBasket;
}
