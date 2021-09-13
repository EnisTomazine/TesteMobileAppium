package mobileTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class Calc  {

    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testeSoma() {
        MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
        btn9.click();
        MobileElement btnAdicao = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnAdicao.click();
        MobileElement btn4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
        btn4.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_preview");
        assertEquals("13", lblResultado.getText());
    }

    @Test
    public void testeDivisao() {
        MobileElement btn8 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_8");
        btn8.click();
        MobileElement btnDivisao = (MobileElement) driver.findElementByAccessibilityId("divide");
        btnDivisao.click();
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnResultado = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnResultado.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("4", lblResultado.getText());
    }

    @Test
    public void testeMultiplicacao() {
        MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
        btn9.click();
        MobileElement btnMultiplicacao = (MobileElement) driver.findElementByAccessibilityId("multiply");
        btnMultiplicacao.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnResultado = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnResultado.click();
        MobileElement lblResultado = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals("27", lblResultado.getText());
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
