package utils;


import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.net.URL;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Hooks {

    protected AndroidDriver driver;
    private final static Logger LOGGER = getLogger(Hooks.class.getName());


    @BeforeMethod
    public void setup() {
        try {
            LOGGER.info("Starting setup");
            ConfigCapabilities configCapabilities = new ConfigCapabilities();
            DesiredCapabilities caps = configCapabilities.GetCapabilities();

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, caps);
            




        } catch (Exception e) {
            System.out.println("The Cause is: " + e.getCause());
            System.out.println("The Message is: " + e.getMessage());
            e.printStackTrace();
        }


    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }


}