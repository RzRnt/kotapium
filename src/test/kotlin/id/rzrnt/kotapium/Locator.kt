package id.rzrnt.kotapium
import id.rzrnt.kotapium.LocatorStrategy

public class Locator(_locatorStrategy: LocatorStrategy, _locatorValue: String) {
    var locatorStrategy: LocatorStrategy
    var locatorValue: String
    init {
        locatorStrategy = _locatorStrategy
        locatorValue  = _locatorValue
    }
}