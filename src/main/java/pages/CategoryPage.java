package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;
import java.util.WeakHashMap;

/**
 * Create by plotnikvk
 */

public class CategoryPage extends BasePageObject {

    public CategoryPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='eLeftMainMenu_Title']")
    public List<WebElement>categoryItem;

    @FindBy(xpath = "//a[@class='eLeftMainMenu_Link']")
    public List<WebElement>subCategoryItem;

    @Override
    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        for (WebElement item : collection ){
            if (item.getText().equalsIgnoreCase(itemName)){
                item.click();
                return;
            }
        }
         super.selectCollectionItem(itemName,subCategoryItem);
    }
}
