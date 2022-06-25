package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement homeCheckBox;
    WebElement successNotification;
    WebElement homeExpandButton;
    WebElement checkBoxes;

    public CheckBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getSuccessNotification() {
        return driver.findElement(By.id("result"));
    }

    public List <WebElement> getCheckBoxes() {
        return driver.findElements(By.className("rct-title"));
    }



    public WebElement getHomeExpandButton() {
        return driver.findElement(By.cssSelector(".rct-collapse.rct-collapse-btn"));
    }


    //------------------------

    public WebElement homeCheckBox () {
        int index = 0;
        for (int i = 0; i < getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals("Home")) {index = i;}
        }
        return getCheckBoxes().get(index);
    }

    public WebElement desktopCheckBox () {
        int index = 0;
        for (int i = 0; i < getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals("Desktop")) {index = i;}
        }

        return getCheckBoxes().get(index);
    }


    public WebElement documentsCheckBox () {
        int index = 0;
        for (int i = 0; i < getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals("Documents")) {index = i;}
        }

        return getCheckBoxes().get(index);
    }

    public WebElement downloadsCheckBox () {
        int index = 0;
        for (int i = 0; i < getCheckBoxes().size(); i++) {
            if (getCheckBoxes().get(i).getText().equals("Downloads")) {index = i;}
        }

        return getCheckBoxes().get(index);
    }

    public void clickOnHomeCheckBox () {
        homeCheckBox().click();
    }

    public void clickOnHomeExpandButton () {
        getHomeExpandButton().click();
    }

    public void clickOnDesktopCheckBox () {
        desktopCheckBox().click();

    }


    public void clickOnDocumentsCheckBox () {
        documentsCheckBox().click();

    }

    public void clickOnDownloadsCheckBox () {
        downloadsCheckBox().click();
    }

}
