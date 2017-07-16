package project.automation.chapter_1.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import project.automation.chapter_1.BasePart;

public class MainLenovoTest extends BasePart {

    @Test
    public void openSites(){
        actions.openSite();
    }
}
