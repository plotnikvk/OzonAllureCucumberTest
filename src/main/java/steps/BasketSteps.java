package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasketPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketSteps {

    BasketPage basketPage = new BasketPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);

    @Step("проверено, что в корзине есть добавленный товар")
    public boolean productIsPresent() {
        int i = basketPage.addedProductList.size();
        if (i != 0)
            return true;
        else
            return false;
    }

    @Step("нажали кнопку удалить все")
    public void removeAll() {
        wait.until(ExpectedConditions.visibilityOfAllElements(basketPage.info));
        while (productIsPresent()) {
            Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(basketPage.clearAllButton)).click();
            BaseSteps.getDriver().navigate().refresh();
            try {
                BaseSteps.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                wait.until(ExpectedConditions.visibilityOfAllElements(basketPage.info));
            } catch (Exception e ){
                e.printStackTrace();
            } finally {
                BaseSteps.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        }
    }
    @Step("проверили что корзина пуста")
    public void basketIsEmpty(String text){
        wait.until(ExpectedConditions.textToBePresentInElement(basketPage.emptyBasket,text));
        Assert.assertEquals("В поле рассчитано значение %s. Ожидалось - %s", basketPage.emptyBasket.getText(),
                    text);
    }
}
