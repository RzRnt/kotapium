
package id.rzrnt.kotapium

import id.rzrnt.kotapium.AppPage
import id.rzrnt.kotapium.Kotapium

import org.junit.Assert.*
import org.junit.Test

import java.lang.Math

class AppTest : Kotapium() {
  @Test
  fun menu() {
    var randomTestExecution = (Math.random() * 100 + 1).toInt()
    val menus = arrayOf("Echo Box", "Login Screen", "Clipboard Demo", "Webview Demo", "Verify Phone Number")
    val mainPage = AppPage(driver!!)
    for (t in 1..randomTestExecution) {
        menus.forEach{
            mainPage.tapMenu(it)
            mainPage.isMenuOpened(it)
            mainPage.tapBack()
        }
    }
  }
}