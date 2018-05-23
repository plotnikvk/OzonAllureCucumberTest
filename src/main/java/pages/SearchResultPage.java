package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class SearchResultPage extends BasePageObject {

    public SearchResultPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public static List<String> names;

    @FindBy(xpath = "//span[@class='eFilterList_OptionLink']")
    public List<WebElement> brands;

    @FindBy(xpath = "//div[@class='eFilterList_Title open '][contains(text(),'Бренды')]/following-sibling::div//a")
    public List<WebElement>brands2;

    @FindBy(xpath = "//input[@class='eFromToInput_InputField mFrom']")
    public WebElement priceWindowFrom;

    @FindBy(xpath = "//div[@class='bFiltersHor']//div[@class='bFlatButton mMicro mWhite']")
    public WebElement applyButton;

    @FindBy(xpath = "//a[@class='eOneTile_tileLink jsUpdateLink']/ancestor::div[@class='bOneTile inline jsUpdateLink mRuble ']")
    public List<WebElement>listOfProducts;

    @FindBy(xpath = "//div[@class='bSaleBlockButton jsButton']")
    public WebElement buttonAddToBasket;

    @FindBy(xpath = "//div[@class='eMyOzon_Item mCart jsPanelCart mActive']/a")
    public WebElement basket;



    @Override
    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        for (WebElement item : collection ){
            if (item.getText().contains(itemName)){
                item.click();
                return;
            }
        }
         this.selectCollectionItem(itemName, brands2);
    }
}
