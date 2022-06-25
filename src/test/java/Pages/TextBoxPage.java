package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement fullName;
    WebElement email;
    WebElement currentAddress;
    WebElement permanentAddress;
    WebElement submitButton;
    WebElement submitedFullName;
    WebElement submitedEmail;
    WebElement submitedCurrentAddress;
    WebElement submitedPermanentAddress;

    public TextBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFullName() {
        return driver.findElement(By.xpath("//*[@id=\"userName\"]"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
    }

    public WebElement getPermanentAddress() {
        return driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getSubmitedFullName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getSubmitedEmail() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getSubmitedCurrentAddress() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]"));
    }

    public WebElement getSubmitedPermanentAddress() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]"));
    }

    //----------------

    public void enterFullName (String fullname) {
        getFullName().clear();
        getFullName().sendKeys(fullname);
    }

    public void enterEmail (String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void enterCurrentAddress (String currentAddress) {
        getCurrentAddress().sendKeys(currentAddress);

    }

    public void enterPermanentAddress (String permanentAddress) {
        getPermanentAddress().sendKeys(permanentAddress);

    }

    public void clickOnSubmitButton () {
        getSubmitButton().click();
    }

}
