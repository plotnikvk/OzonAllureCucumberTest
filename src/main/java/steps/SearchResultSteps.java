package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchResultPage;

import java.util.List;

public class SearchResultSteps {

SearchResultPage searchResultPage = new SearchResultPage();
WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);


    @Step("выбран бренд товара - {brand}")
    public void selectBrandOfItem(String brand){
     searchResultPage.selectCollectionItem(brand,searchResultPage.brands);
    }

    @Step("заполнена цена от – {price}")
    public void isCompletedPriceFrom(String price){
        searchResultPage.fillField(searchResultPage.priceWindowFrom,price);
        searchResultPage.priceWindowFrom.sendKeys(Keys.TAB);
        searchResultPage.applyButton.click();
    }

    @Step("добавлены в корзину нечетные элементы из списка")
    public void addToBasketProduct(){
        int length = searchResultPage.listOfProducts.size();
        for (int i = 0; i < length; i++) {
            if(((i+1)%2)==0){
               continue;
            }
            BaseSteps.getDriver().findElements(By.xpath("//a[@class='eOneTile_tileLink jsUpdateLink']/ancestor:" +
                    ":div[@class='bOneTile inline jsUpdateLink mRuble ']")).get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.buttonAddToBasket));
            searchResultPage.buttonAddToBasket.click();
            BaseSteps.getDriver().navigate().back();
        }
    }

    @Step("перешли в корзину")
    public void goToBasket(){
        searchResultPage.basket.click();
    }
}
