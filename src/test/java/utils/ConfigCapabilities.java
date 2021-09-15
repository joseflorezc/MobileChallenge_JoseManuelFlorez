package utils;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import screens.BaseScreen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import static org.apache.logging.log4j.LogManager.getLogger;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String JSON_FILE_PATH = "src/test/resources/Capabilities.json";

    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private final static Logger LOGGER = getLogger(BaseScreen.class.getName());

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
    }
    private static void DeviceSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getJsonDataProperty(PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    private static String getJsonDataProperty(String property) {
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(new FileReader(JSON_FILE_PATH), JsonObject.class);
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "";
    }

    public DesiredCapabilities GetCapabilities(){
        if(capabilities.toJson().isEmpty()) {
            ConfigCapabilities.DeviceSetUp(capabilities);
            ConfigCapabilities.ApplicationSetUp(capabilities);
        }
        return capabilities;
    }
}
