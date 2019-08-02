package id.rzrnt.kotapium
import id.rzrnt.kotapium.LocatorStrategy
import id.rzrnt.kotapium.Locator

public class AppPageLocator {
    var MENU_LOCATOR = Locator(
        LocatorStrategy.XPATH,
         "//com.facebook.react.views.view.ReactViewGroup[@content-desc='%s']"
    )

    var BACK_LOCATOR = Locator(
        LocatorStrategy.CLASS,
        "android.support.v7.widget.AppCompatImageButton"
    )
}