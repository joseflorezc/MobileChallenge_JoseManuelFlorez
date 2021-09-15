package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.apache.logging.log4j.LogManager.getLogger;

public class PopUps extends BaseScreen {

    private final static Logger LOGGER = getLogger(PopUps.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Solo si la aplicación está en uso\")")
    private MobileElement whileAppInUseButton;

    public PopUps(AndroidDriver driver) {
        super(driver);
    }

    public void lettingApplicationUseLocationWhileInUse(){
        LOGGER.info("Clicking on button");
       wait.until(ExpectedConditions.visibilityOf(whileAppInUseButton)).click();
    }







}
