package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchResultPage;

/**
 * Create by plotnikvk
 */

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
    }

    @Step("добавлены в корзину нечетные элементы из списка")
    public void addToBasketProduct(){
        int length = searchResultPage.listOfProducts.size();
        for (int i = 0; i < length; i++) {
            if(((i+1)%2)==0){
               continue;
            }
            new SearchResultPage().listOfProducts.get(i).click();
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
