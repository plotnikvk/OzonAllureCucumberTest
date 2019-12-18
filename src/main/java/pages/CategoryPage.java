package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class CategoryPage extends BasePageObject {

    public CategoryPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);

    @FindBy(xpath = "//div[contains(@class,'container')]//a[contains(@href,'/category/') and not(contains(@class,'banner')) and not(contains(@class,'x7'))]")
    public List<WebElement> categoryItem;

    @FindBy(xpath = "//div")
    public WebElement parent;

    public void selectCategoryLink(String itemName) {
        try {
            WebElement categoryLink = parent.findElement(By.xpath("//strong[contains(text(),'" + itemName + "')]/ancestor::a"));
            categoryLink.click();
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
