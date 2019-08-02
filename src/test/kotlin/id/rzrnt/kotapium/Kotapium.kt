package id.rzrnt.kotapium

import java.io.IOException
import java.net.URL
import java.util.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals

import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator

import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.remote.DesiredCapabilities


open class Kotapium {
    var driver: AppiumDriver<MobileElement>? = null
    
    @Before
    @Throws(IOException::class)
    fun setUp() {
        val caps = DesiredCapabilities()
        caps.setCapability("platformName", "Android")
        caps.setCapability("platformVersion", "6")
        caps.setCapability("deviceName", "86989034")
        caps.setCapability("automationName", "espresso")
        caps.setCapability("udid", "86989034")
        caps.setCapability("app", "/Users/rezirusnadiputra/Downloads/TheApp-v1.5.0.apk")
        driver = AndroidDriver(URL("http://localhost:4677/wd/hub"), caps)
    }

    @After
    fun tearDown() {
       driver?.quit()
    }
}

