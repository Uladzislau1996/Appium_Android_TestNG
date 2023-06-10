package apk.generalstore.PageObjects;

import apk.generalstore.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketScreen extends AndroidActions {

    AndroidDriver driver;

    public BasketScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productSum;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement displayedSum;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement terms;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement closePopupButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement complete;

    @Step("Get product sum from 2 items")
    public double getProductSum() {

        int count = productSum.size();
        double totalSum = 0;

        for (int i = 0; i < count; i++) {
            String amount = productSum.get(i).getText();
            double price = getPrice(amount);
            totalSum = totalSum + price;
        }
        return totalSum;
    }

    @Step("Get displayed total sum")
    public double getDisplayedSum() {
        double totalDisplayedSum = getPrice(displayedSum.getText());
        return totalDisplayedSum;
    }

    @Step("Submit order and go to website")
    public void submitOrder() {
        checkBox.click();
        complete.click();

    }

    @Step("Submit terms")
    public void submitTerms() {
        longPress(terms);
        closePopupButton.click();
    }

}
