import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import service.DriverSetup;

import java.util.logging.Logger;

public class ClickAddContactButtonTest extends DriverSetup {

    public Logger logger = Logger.getGlobal();

    @BeforeClass
    public static void setUp() throws Exception {
        prepareAndroidNative();
    }

    @Test
    public void clickButtonTest() throws InterruptedException {
        String appPackageName = "com.example.android.contactmanager:id/";
        By addButton = By.id(appPackageName + "addContactButton");
        driver.findElement(addButton).click();

        Thread.sleep(2000);

        String pageTitle = driver.findElement(By.id("android:id/title")).getText();

        logger.info(String.format("The Add Contact button is clicked, page title is: %s", pageTitle));

        Assert.assertEquals("Unexpected page is opened", "Add Contact", pageTitle);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}