package id.rzrnt.kotapium

import id.rzrnt.kotapium.LocatorStrategy
import id.rzrnt.kotapium.Locator
import id.rzrnt.kotapium.config


import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator

import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebElement
import org.openqa.selenium.By


import org.openqa.selenium.support.PageFactory

abstract class BasePage(val driver: AppiumDriver<*>) {
  init {
    PageFactory.initElements(AppiumFieldDecorator(driver), this)
  }

  public fun constructLocator(locator: Locator, formatString: String): Locator {
    return Locator(
      locator.locatorStrategy,
      locator.locatorValue.format(formatString)
    )
  }

  public fun waitUntilElementVisible(locator: Locator, timeout: Long = config().TIMEOUT): WebElement {
    return WebDriverWait(driver, timeout)
      .until(ExpectedConditions.presenceOfElementLocated(getLocator(locator)))
  }

  public fun tapElement(locator: Locator) {
    waitUntilElementVisible(locator).click()
  }

  public fun getLocator(locator: Locator): By {
    return when(locator.locatorStrategy) {
      LocatorStrategy.XPATH -> By.xpath(locator.locatorValue)
      LocatorStrategy.ID -> By.id(locator.locatorValue)
      LocatorStrategy.CLASS -> By.className(locator.locatorValue)
    }
  }
}