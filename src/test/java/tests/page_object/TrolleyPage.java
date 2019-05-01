package tests.page_object;

import com.mavenit.selenium.Sept.driver.DriverHelper;
import org.openqa.selenium.By;

public class TrolleyPage extends DriverHelper {

    public String getProdcutInBasket() {
        return driver.findElement(By.cssSelector(".description>strong>a")).getText();
    }

    public void collect(String postcode) {
        driver.findElement(By.cssSelector("")).sendKeys(postcode);
    }

    public void chooseStore() {
        driver.findElement(By.cssSelector("")).click();
    }
}
