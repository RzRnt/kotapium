package id.rzrnt.kotapium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.pagefactory.*

import id.rzrnt.kotapium.AppPageLocator

open class AppPage(driver: AppiumDriver<*>) : BasePage(driver) {

  init {
    //verify app page is opened
  }

  public fun tapMenu(menuName: String) {
    waitUntilElementVisible(constructLocator(AppPageLocator().MENU_LOCATOR, menuName))
    return tapElement(constructLocator(AppPageLocator().MENU_LOCATOR, menuName))
  }

  public fun isMenuOpened(menu: String): Boolean {
    println("Menu " + menu +" is opened")
    return true
  }

  public fun tapBack() {
    waitUntilElementVisible(AppPageLocator().BACK_LOCATOR)
    return tapElement(AppPageLocator().BACK_LOCATOR)
  }

  public fun verifyAllMenus(menus: Array<String>) {
    menus.forEach{
      tapMenu(it)
      isMenuOpened(it)
      tapBack()
    }
  }
}