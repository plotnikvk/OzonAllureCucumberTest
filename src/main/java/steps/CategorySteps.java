package steps;

import io.qameta.allure.Step;
import pages.CategoryPage;

/**
 * Create by plotnikvk
 */

public class CategorySteps {

    CategoryPage categoryPage = new CategoryPage();

    @Step("выбрана категория товара - {item}")
    public void selectCategoryItem(String item){
        categoryPage.selectCollectionItem(item, categoryPage.categoryItem);
    }
}
