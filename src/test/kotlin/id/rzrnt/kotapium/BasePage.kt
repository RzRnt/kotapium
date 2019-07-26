package id.rzrnt.kotapium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator

import org.openqa.selenium.support.PageFactory

abstract class BasePage(val driver: AppiumDriver<*>) {
  init {
    PageFactory.initElements(AppiumFieldDecorator(driver), this)
  }
}