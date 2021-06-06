package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseModel {
    WebDriver webDriver;

    public BaseModel(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickElement(By element) {
        webDriver.findElement(element).click();
    }

    public void sendKeyElement(By element, String value) {

        webDriver.findElement(element).sendKeys(value);
    }

    public List<WebElement> getText(By element) {
        return webDriver.findElements(element);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,1000)");
    }
}
