package screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import static org.apache.logging.log4j.LogManager.getLogger;

public class LoginScreen extends BaseScreen {

    private final static Logger LOGGER = getLogger(BaseScreen.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")")
    private MobileElement permissionOfLocationWhileAppInUseButton;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

}
