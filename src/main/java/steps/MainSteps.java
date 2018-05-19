package steps;

import io.qameta.allure.Step;
import pages.MainPage;

/**
 * Create by plotnikvk
 */

public class MainSteps {

    MainPage mainPage = new MainPage();

   @Step("Закрыт баннер с рекламой")
   public void closeBannerMethod(){
       mainPage.closeBanner.click();
   }

   @Step("выбран пункт меню - {item}")
   public void selectMenuItem(String item){
       mainPage.selectCollectionItem(item, mainPage.menuItems);
   }
}
