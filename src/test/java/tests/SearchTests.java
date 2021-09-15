package tests;

import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.PopUps;
import utils.Hooks;

public class SearchTests extends Hooks {


    @Test
    public void firstTest(){

        PopUps popUps = new PopUps(driver);
        popUps.lettingApplicationUseLocationWhileInUse();
        }
}
