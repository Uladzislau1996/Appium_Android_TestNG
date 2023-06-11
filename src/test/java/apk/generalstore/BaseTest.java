package apk.generalstore;

import apk.generalstore.PageObjects.LoginScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public LoginScreen login;

    @BeforeMethod
    public void configureAppium() throws MalformedURLException {
        //code to start appium server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();
        //Set capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 2 Android");
        options.setApp("/Users/test/Documents/GitHub/Appium_Android_Test_Project/src/main/resources/General-Store.apk");
        //Init Android driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //return LoginScreen object
        login = new LoginScreen(driver);
    }

    //stop driver and server
    @AfterMethod
    public void tearDown() {
        driver.quit();
        service.stop();
    }

}
