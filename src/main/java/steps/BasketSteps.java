package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasketPage;

import java.util.ArrayList;
import java.util.List;

public class BasketSteps {

    BasketPage basketPage = new BasketPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),10);

    @Step("проверено, что в корзине есть добавленный товар")
    public boolean productIsPresent(){
        int i = basketPage.addedProductList.size();
        if(i !=0 )
            return true;
        else
            return false;
    }

    @Step ("нажали кнопку удалить все")
    public void removeAll(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@ class='bCartPage \tmBlockActions \t']")));
        basketPage.removeAllButton.click();
        wait.until(ExpectedConditions.visibilityOf(basketPage.closeRemoveWindow));
        basketPage.closeRemoveWindow.click();
    }
    @Step("проверили что корзина пуста")
    public void basketIsEmpty(String text){
        Assert.assertTrue(String.format("В поле рассчитано значение %s. Ожидалось - %s", basketPage.emptyBasket.getText(),
                text), wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualResult =  basketPage.emptyBasket.getText();
            return actualResult.equalsIgnoreCase(text);}));
    }
}
