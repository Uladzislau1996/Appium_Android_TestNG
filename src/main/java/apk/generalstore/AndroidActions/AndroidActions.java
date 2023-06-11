package apk.generalstore.AndroidActions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions {

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void longPress(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
    }

    public void scrollToEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()" +
                ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                "textContains(\"" + text + "\").instance(0))"));
    }

    public Double getPrice(String itemPrice) {
        Double price = Double.parseDouble(itemPrice.substring(1));
        return price;
    }

    public void swipeAction(WebElement element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

}
