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
    val constructedLocatorValue = locator.locatorValue.format(formatString)
    val constructedLocator = Locator(
      locator.locatorStrategy,
      constructedLocatorValue
    )
    return constructedLocator
  }

  public fun waitUntilElementVisible(locator: Locator, timeout: Long = config().TIMEOUT): WebElement {
    var wait: WebDriverWait = WebDriverWait(driver, timeout)
    return wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locator)))
  }

  public fun tapElement(locator: Locator) {
    return waitUntilElementVisible(locator).click()
  }

  public fun getLocator(locator: Locator): By {
    var locatorType: LocatorStrategy = locator.locatorStrategy
    var locatorValue: String = locator.locatorValue
    var locatorBy: By = when(locatorType) {
      LocatorStrategy.XPATH -> By.xpath(locatorValue)
      LocatorStrategy.ID -> By.id(locatorValue)
      LocatorStrategy.CLASS -> By.className(locatorValue)
    }
    return locatorBy
  }
}