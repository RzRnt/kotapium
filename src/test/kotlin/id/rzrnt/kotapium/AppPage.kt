package id.rzrnt.kotapium

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.*

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

class AppPage(driver: AppiumDriver<*>) : BasePage(driver) {

  fun tapMenu(menuName: String) {
    var wait: WebDriverWait = WebDriverWait(driver, 10);
    var menuElement: By = By.xpath(constructMenuLocator(menuName));
    var menuElementReady: ExpectedCondition<WebElement> = ExpectedConditions.presenceOfElementLocated(menuElement);
    return wait.until(menuElementReady).click();
}

  fun isMenuOpened(menu: String): Boolean {
    return true
  }

  fun tapBack() {
    var backLocator = "android.support.v7.widget.AppCompatImageButton"
    var wait: WebDriverWait = WebDriverWait(driver, 10);
    var backElement: By = By.className(backLocator);
    var backElementReady: ExpectedCondition<WebElement> = ExpectedConditions.presenceOfElementLocated(backElement);
    return wait.until(backElementReady).click();
  }

  fun constructMenuLocator(menu: String): String {
    var menuLocator = "//com.facebook.react.views.view.ReactViewGroup[@content-desc='%s']"
    return menuLocator.format(menu)
  }
}