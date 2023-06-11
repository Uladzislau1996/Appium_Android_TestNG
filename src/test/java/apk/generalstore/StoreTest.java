package apk.generalstore;

import apk.generalstore.PageObjects.BasketScreen;
import apk.generalstore.PageObjects.CatalogueScreen;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest {

    @Description("Login and to buy 2 items")
    @Test
    public void makeOrderTest() throws InterruptedException {
        login.setNameField("TestQA");
        login.setGender("female");
        login.setCountry("Argentina");
        CatalogueScreen catalogue = login.submitForm();
        catalogue.clickItems(0);
        catalogue.clickItems(0);
        BasketScreen basketScreen = catalogue.goToBasket();
        double productSum = basketScreen.getProductSum();
        double totalSum = basketScreen.getDisplayedSum();
        Assert.assertEquals(productSum, totalSum, "Incorrect total sum");
        basketScreen.submitTerms();
        basketScreen.submitOrder();
    }
}
