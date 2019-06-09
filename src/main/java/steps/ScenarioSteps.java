package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Create by plotnikvk
 */

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    CategorySteps categorySteps = new CategorySteps();
    SearchResultSteps searchResultSteps = new SearchResultSteps();
    BasketSteps basketSteps = new BasketSteps();

    @When("^выбран пункт меню - \"(.+)\"$")
    public void selectMenuItem(String item){
        mainSteps.selectMenuItem(item);
    }

    @When("^выбрана категория товара - \"(.+)\"$")
    public void selectCategoryItem(String item){
       categorySteps.selectCategoryItem(item);
    }

    @When("^выбран бренд товара - \"(.+)\"$")
    public void selectBrandItem(List<String> brandItem){
        for (String aBrandItem : brandItem) { searchResultSteps.selectBrandOfItem(aBrandItem); } }

    @When("^заполнена цена от – \"(.+)\"$")
    public void isCompletedPriceFrom(String price){
        searchResultSteps.isCompletedPriceFrom(price);
    }

    @When("^добавлены в корзину нечетные элементы из списка$")
    public void addToBasketProduct(){
        searchResultSteps.addToBasketProduct();
    }

    @Then("^перешли в корзину$")
    public void goToBasket(){
        searchResultSteps.goToBasket();
    }

    @Then("^проверено, что в корзине есть добавленный товар$")
    public void checkProduckt(){
        basketSteps.productIsPresent();
    }

    @Then("^нажали кнопку удалить все$")
    public void removeAllClick(){
        basketSteps.removeAll();
    }

    @Then("^проверили что - \"(.+)\"$")
    public void checkBasket(String text){
        basketSteps.basketIsEmpty(text);
    }
}
