package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

/**
 * Create by plotnikvk
 */

public class MainSteps {

    MainPage mainPage = new MainPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);

    @Step("Закрыт баннер с рекламой")
   public void closeBannerMethod(){
      try{
          wait.until(ExpectedConditions.visibilityOf(mainPage.closeBanner));
         if(mainPage.closeBanner.isDisplayed()){
              mainPage.closeBanner.click();
          }
      }catch (Exception e) {
            e.printStackTrace();
        }
   }

   @Step("выбран пункт меню - {item}")
   public void selectMenuItem(String item){
       mainPage.selectCollectionItem(item, mainPage.menuItems);
   }
}
