package tests;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageModel.ProductDetailPageModel;

import java.util.List;

public class ProductDetailPageTest extends BaseTest {
    String productName = "Iphone";
    String evaluationEmptyMessage = "Seçilen üründe değerlendirme bulunmamaktadır!";
    List<WebElement> webElementsProductTitle;
    List<WebElement> webElementsListYes;
    List<WebElement> webElementsListThanks;

    @Test
    public void evalutionTest() throws InternalException {
        ProductDetailPageModel productDetailPageModel = new ProductDetailPageModel(webDriver);
        productDetailPageModel.setProduct(productName);
        webElementsProductTitle = productDetailPageModel.listProductTitle();
        webElementsProductTitle.get(0).click();
        productDetailPageModel.clickProductReviews();
        webElementsListYes = productDetailPageModel.ListProductReviewsYes();
        productDetailPageModel.scrollDown();
        if (!webElementsListYes.isEmpty()) {
            webElementsListYes.get(0).click();
            webElementsListThanks = productDetailPageModel.ListProductReviewsThanks();
            Assert.assertEquals(webElementsListThanks.get(0).getText(), "Teşekkür Ederiz.", "Doğru mesaj ile karşılaşılmadı!");
        } else {
            System.out.println(evaluationEmptyMessage);
        }
    }

    @Test
    public void evalutionEmptyMessageTest() throws InternalException {
        ProductDetailPageModel productDetailPageModel = new ProductDetailPageModel(webDriver);
        productDetailPageModel.setProduct(productName);
        productDetailPageModel.clickUnratedProducts();
        webElementsProductTitle = productDetailPageModel.listProductTitle();
        webElementsProductTitle.get(0).click();
        productDetailPageModel.clickProductReviews();
        webElementsListYes = productDetailPageModel.ListProductReviewsYes();
        productDetailPageModel.scrollDown();
        if (!webElementsListYes.isEmpty()) {
            webElementsListYes.get(0).click();
            webElementsListThanks = productDetailPageModel.ListProductReviewsThanks();
            Assert.assertEquals(webElementsListThanks.get(0).getText(), "Teşekkür Ederiz.", "Doğru mesaj ile karşılaşılmadı!");
        } else {
            System.out.println(evaluationEmptyMessage);
        }
    }
}
