package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

/**
 * Create by plotnikvk
 */

public class MainSteps {

    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);

   @Step("выбран пункт меню - {item}")
   public void selectMenuItem(String item){
       mainPage.selectCollectionItem(item, mainPage.menuItems);
   }
}
