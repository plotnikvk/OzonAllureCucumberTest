package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class BasketPage extends BasePageObject {

    public BasketPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Удалить всё']/..")
    public WebElement clearAllButton;

    @FindBy(xpath = "//div[@class='eCartControls_infoDate']")
    public List<WebElement> info;

    @FindBy(xpath = "//span[@class='eCartItem_nameValue']")
    public List<WebElement> addedProductList;

    @FindBy(xpath = "//span[@class='jsInnerContentpage_title']")
    public WebElement emptyBasket;
}
