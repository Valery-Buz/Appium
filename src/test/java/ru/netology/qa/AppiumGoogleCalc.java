package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScr;

public class AppiumGoogleCalc {

    private AndroidDriver driver;
    MainScr mainScr;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "some name");
        desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 5000);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        mainScr = new MainScr(driver);
    }

    @Test
    public void sampleTest() {
        mainScr.digitFiveButton.click();
        mainScr.minusSignButton.click();
        mainScr.digitTwoButton.click();
        mainScr.equalsSignButton.click();
        mainScr.resultField.isDisplayed();
        Assertions.assertEquals("3", mainScr.resultField.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}