package ru.netology.qa.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MainScr {

//    @AndroidFindBy(xpath = "//*[contains(@resource-id,'digit')]")
//    private List<MobileElement> digitButtons;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
    public MobileElement digitFiveButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
    public MobileElement minusSignButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    public MobileElement digitTwoButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    public MobileElement equalsSignButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement resultField;

    private AppiumDriver driver;

    public MainScr(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}


