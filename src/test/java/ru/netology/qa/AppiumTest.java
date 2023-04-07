package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScrAppium;

public class AppiumTest {

    private AndroidDriver driver;

    MainScrAppium mainScrAppium;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel 6");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        mainScrAppium = new MainScrAppium(driver);

    }

    public void testChangeTextEmpty() {
        mainScrAppium.userInput.sendKeys("     ");
        mainScrAppium.buttonChange.click();
        Assertions.assertEquals("Привет, UiAutomator!", mainScrAppium.textToBeChanged.getText());
    }

    @Test
    public void activityTest() {
        mainScrAppium.userInput.sendKeys("Netology");
        mainScrAppium.buttonActivity.click();
        Assertions.assertEquals("Netology", mainScrAppium.activityText.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}