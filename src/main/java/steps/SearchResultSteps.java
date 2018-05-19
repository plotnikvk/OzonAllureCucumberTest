package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.SearchResultPage;

public class SearchResultSteps {

SearchResultPage searchResultPage = new SearchResultPage();

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
        for (WebElement item:searchResultPage.listOfProducts) {
            int i = 1;
            if(i%2==0){
                i++;
               continue;
            }
            item.click();
            searchResultPage.buttonAddToBasket.click();
            BaseSteps.getDriver().navigate().back();
            i++;
        }
    }
}
