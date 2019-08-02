
package id.rzrnt.kotapium

import id.rzrnt.kotapium.AppPage
import id.rzrnt.kotapium.Kotapium
import id.rzrnt.kotapium.AppTestData

import org.junit.Assert.*
import org.junit.Test

import java.lang.Math

class AppTest : Kotapium() {
  @Test
  fun menu() {
    val appPage = AppPage(driver!!)
    appPage.verifyAllMenus(AppTestData().APP_MENUS)
  }
}