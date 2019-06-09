package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import steps.BaseSteps;
import java.util.List;

/**
 * Create by plotnikvk
 */

public class SearchResultPage extends BasePageObject {

    public SearchResultPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);

    public static List<String> names;

    @FindBy(xpath = "//div[@data-test-id='filter-block-brand']//span[@class='label-text']")
    public List<WebElement> brands;

    @FindBy(xpath = "//span[@data-test-id='filter-block-brand-show-all']")
    public WebElement openYetBrands;

    @FindBy(xpath = "//div[@data-test-id='filter-block-brand']")
    public WebElement brands2;

    @FindBy(xpath = "//div[contains(text(),'Цена')]/parent::div//input[@data-test-id='range-filter-from-input']")
    public WebElement priceWindowFrom;

    @FindBy(xpath = "//div[@class='bFiltersHor']//div[@class='bFlatButton mMicro mWhite']")
    public WebElement applyButton;

    @FindBy(xpath = "//a[@class='eOneTile_tileLink jsUpdateLink']/ancestor::div[@class='bOneTile inline jsUpdateLink mRuble ']")
    public List<WebElement> listOfProducts;

    @FindBy(xpath = "//div[@class='bSaleBlockButton jsButton']")
    public WebElement buttonAddToBasket;

    @FindBy(xpath = "//div[@class='eMyOzon_Item mCart jsPanelCart mActive']/a")
    public WebElement basket;

    @Override
    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        for (WebElement item : collection) {
            if (item.getText().contains(itemName)) {
                item.click();
                return;
            }
        }
        System.out.println("Нет Элементов");
        openYetBrands.click();
        System.out.println("После клика показать еще");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Перед заходом во второй метод");
        selectYetCollectionItem(itemName, brands2);
    }

    public void selectYetCollectionItem (String itemName, WebElement element) {
        System.out.println("Зашли во второй метод");
        WebElement span = element.findElement(By.xpath("//label/span[contains(text(),'"+ itemName +"')]"));
        WebElement checkbox = span.findElement(By.xpath("//preceding-sibling::input"));
        checkbox.click();
        System.out.println("Кликнули чекбокс");
        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        System.out.println(checkbox.isSelected());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
