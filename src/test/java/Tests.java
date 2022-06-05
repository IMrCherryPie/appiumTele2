import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Tests {

    DesiredCapabilities caps = new DesiredCapabilities();
    AndroidDriver<AndroidElement> driver = null;

    @Test
    public void testTele2App() {

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\Mr.CherryPie\\Downloads\\news-classifier-java-master\\appiumTele2\\src\\test\\resources\\tele2-4-18-0-rustore.apk");

        try {
//            load app
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            Thread.sleep(100);

            MobileElement element = driver.findElementById("ru.tele2.mytele2:id/phoneText");

            element.click();

            element.sendKeys("9999999998");

            Thread.sleep(100);

            element = driver.findElementById("ru.tele2.mytele2:id/otherWays");
            element.click();

            Thread.sleep(100);

            element = driver.findElementById("ru.tele2.mytele2:id/passwordEditText");
            element.click();
            element.sendKeys("123456");

            Thread.sleep(100);

            System.out.println("running to catch");

            driver.findElementById("ru.tele2.mytele2:id/enterButton").click();
            Thread.sleep(10);
            System.out.println("Catching toast");
            String toastMessage = driver.findElementById("ru.tele2.mytele2:id/tvMessage").getText();
            System.out.println(toastMessage);

            Thread.sleep(200);

        } catch (MalformedURLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}