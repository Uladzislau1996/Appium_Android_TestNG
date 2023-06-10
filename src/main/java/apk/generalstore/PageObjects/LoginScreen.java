package apk.generalstore.PageObjects;

import apk.generalstore.AndroidActions.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends AndroidActions {

    AndroidDriver driver;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement female;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement male;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement country;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Argentina']")
    private WebElement  Argentina;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement submit;

    @Step("Enter the name")
    public void setNameField(String text) {
        nameField.sendKeys(text);
    }

    @Step("Set gender")
    public void setGender(String gender) {
        if (gender.contains("male"))
            male.click();
        else
            female.click();
    }

    @Step("Set country")
    public void setCountry(String countryName) {
        country.click();
        scrollToText(countryName);
        Argentina.click();
    }

    @Step("Submit information")
    public CatalogueScreen submitForm() {
        submit.click();
        return new CatalogueScreen(driver);
    }

}
