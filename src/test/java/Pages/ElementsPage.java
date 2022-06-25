package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ElementsPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement textBoxButton;
    WebElement checkBoxButton;
    WebElement webTablesButton;

    public ElementsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTextBoxButton() {
        return driver.findElement(By.id("item-0"));
    }

    public WebElement getCheckBoxButton() {
        return driver.findElement(By.id("item-1"));
    }

    public WebElement getWebTablesButton() {
        return driver.findElement(By.id("item-3"));
    }

    //---------------------

    public void clickOnTextboxButton () throws InterruptedException {
        getTextBoxButton().click();

    }

    public void clickOnCheckBoxButton () {
        getCheckBoxButton().click();
    }

    public void clickOnWebTablesButton () {
        getWebTablesButton().click();
    }


}
