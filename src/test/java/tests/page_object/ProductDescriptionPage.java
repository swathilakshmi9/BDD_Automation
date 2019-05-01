package tests.page_object;

import com.mavenit.selenium.Sept.driver.DriverHelper;
import org.openqa.selenium.By;

public class ProductDescriptionPage extends DriverHelper {

    public void addToTrolley() {
        driver.findElement(By.cssSelector(".add-to-trolley-main button")).click();
        sleep(2000);
    }

    public void goToTrolley() {
        driver.findElement(By.cssSelector(".button.button--full.xs-hidden.sm-block")).click();
        sleep(5000);
    }
}
