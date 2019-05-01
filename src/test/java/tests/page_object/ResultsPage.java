package tests.page_object;


import com.mavenit.selenium.Sept.driver.DriverHelper;
import com.mavenit.selenium.Sept.utils.UtilsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverHelper {

    public static String expectedProduct;

    @FindBy(css = ".font-condensed.search-title__term")
    private WebElement productTitleLbl;


    @FindBy(css = ".ac-facet__label")
    private List<WebElement> filtersBy;


    public String getProductTitle() {
        return productTitleLbl.getText();
    }

    public void selectFilterBy(String filterChoice) {
      //  List<WebElement> filterWebElements = driver.findElements(By.cssSelector(".ac-facet__label"));
        for (WebElement filterElement : filtersBy) {
            if (filterElement.getText().equalsIgnoreCase(filterChoice)) {
                new WebDriverWait(driver, 20)
                        .until(ExpectedConditions.elementToBeClickable(filterElement));
                filterElement.click();
                break;
            }
        }
//        new WebDriverWait(driver, 30)
//                .until(ExpectedConditions
//                        .invisibilityOf(driver.findElement(By.cssSelector(".icon--loading"))));
        sleep(5000);
    }

    public List<Double> getAllRatingOnProducts() {
        List<Double> collectedRatingList = new ArrayList<>();
        List<WebElement> filterWebelemts = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement filterWebelemt : filterWebelemts) {
            String ratingValueInString = filterWebelemt.getAttribute("data-star-rating");
            double ratingValueInDouble = Double.parseDouble(ratingValueInString);
            collectedRatingList.add(ratingValueInDouble);
        }
        return collectedRatingList;
    }

    public List<Double> getAllProductsPrices() {
        List<Double> collectedPriceList = new ArrayList<>();

        List<WebElement> filterWebelements = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        for (WebElement filterWebelement : filterWebelements) {
            double indiPrice = Double.parseDouble(filterWebelement.getText().replace("£", ""));
            collectedPriceList.add(indiPrice);
        }
        return collectedPriceList;
    }

    public void selectSortingOptions(String choice) {
        Select dropDownSelect = new Select(driver.findElement(By.cssSelector(".font-standard.form-control.sort-select")));
        dropDownSelect.selectByVisibleText(choice);
        sleep(5000);
    }

    public String selectAnyProduct() {
        List<WebElement> allProductsWebElement = driver.findElements(By.cssSelector(".ac-product-card__name"));
        int productCount = allProductsWebElement.size();

//        new WebDriverWait(driver, 30)
//                .until(ExpectedConditions
//                        .numberOfElementsToBeMoreThan(By.cssSelector(".ac-product-card__name"), 30));

        sleep(5000);
        System.out.println("total number of products count : " + productCount);
        int rdnNumber = new UtilsHelper().generateRandomNumber(productCount);

        WebElement indProduct = allProductsWebElement.get(rdnNumber);
        expectedProduct = indProduct.getText();
        indProduct.click();

        return expectedProduct;
    }
}
