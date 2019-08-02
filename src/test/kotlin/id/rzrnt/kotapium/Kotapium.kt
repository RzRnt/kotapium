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

import id.rzrnt.kotapium.Config


open class Kotapium {
    var driver: AppiumDriver<MobileElement>? = null
    val config = Config()
    val caps = DesiredCapabilities()
    
    @Before
    @Throws(IOException::class)
    fun setUp() {
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, config.PLATFORM_NAME)
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.PLATFORM_VERSION)
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, config.DEVICE_NAME)
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.AUTOMATION_NAME)
        caps.setCapability(MobileCapabilityType.UDID, config.UDID)
        caps.setCapability(MobileCapabilityType.APP, config.APP)
        driver = AndroidDriver(URL(config.APPIUM_URL), caps)
    }

    @After
    fun tearDown() {
       driver?.quit()
    }
}

