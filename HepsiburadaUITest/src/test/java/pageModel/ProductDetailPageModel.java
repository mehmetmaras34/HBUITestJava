package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ProductDetailPageModel extends BaseModel {
    List<WebElement> webElements;

    By txtSearch = By.className("desktopOldAutosuggestTheme-input");
    By listProductTitles = By.className("product-title");
    By tabProductReviews = By.id("productReviewsTab");
    By listYesAnswer = By.xpath("//div[@class='hermes-ReviewCard-module-1lb7d']/div[1]");
    By listThanksResponse = By.xpath("//span[text()='Teşekkür Ederiz.']");
    By unratedProducts = By.xpath("//li[5]/label/div");

    public ProductDetailPageModel(WebDriver webDriver) {
        super(webDriver);

    }

    public void setProduct(String productName) {
        sendKeyElement(txtSearch, productName + Keys.ENTER);
    }

    public List<WebElement> listProductTitle() {
        return getText(listProductTitles);
    }

    public void clickProductReviews() {
        clickElement(tabProductReviews);
    }

    public List<WebElement> ListProductReviewsYes() {
        return getText(listYesAnswer);
    }

    public List<WebElement> ListProductReviewsThanks() {
        return getText(listThanksResponse);
    }

    public void clickUnratedProducts() {
        clickElement(unratedProducts);
    }
}
