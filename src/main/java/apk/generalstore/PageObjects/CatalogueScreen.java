package apk.generalstore.PageObjects;

import apk.generalstore.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogueScreen extends AndroidActions {

    AndroidDriver driver;

    public CatalogueScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.TextView)[@text='ADD TO CART']")
    private List<WebElement> item;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement basket;

    @Step("Click on item")
    public void clickItems(int index) {
        item.get(index).click();
    }

    @Step("Go to basket")
    public BasketScreen goToBasket() throws InterruptedException {
        basket.click();
        Thread.sleep(2000);
        return new BasketScreen(driver);
    }
}
