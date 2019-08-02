package id.rzrnt.kotapium
import io.github.cdimascio.dotenv.dotenv

public class Config {
    val env = dotenv();
    val PLATFORM_NAME = env["PLATFORM_NAME"]
    val PLATFORM_VERSION = env["PLATFORM_VERSION"] 
    val DEVICE_NAME = env["DEVICE_NAME"] 
    val UDID = env["UDID"] 
    val AUTOMATION_NAME = env["AUTOMATION_NAME"] 
    val APP = env["APP"] 
    val APPIUM_URL = env["APPIUM_URL"]
    val TIMEOUT: Long = 15
}