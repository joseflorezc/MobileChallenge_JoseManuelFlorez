package screens;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class BaseScreen {

    private final static Logger LOGGER = getLogger(BaseScreen.class.getName());

    protected AndroidDriver driver;
    protected WebDriverWait wait;


    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        initElements();
    }

    private void initElements(){ PageFactory.initElements(new AppiumFieldDecorator(driver), this);}

    public void waitImplicit(){
        LOGGER.debug("Start waiting 1 second, implicit wait");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

//    public BaseScreen Click(AndroidElement androidElement){
//        androidElement.click();
//        return this;
//    }

}
