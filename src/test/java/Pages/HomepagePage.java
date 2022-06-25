package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement elementsButton;

    public HomepagePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getElementsButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5"));

    }

    //------------------------------------

    //Nazivi metoda u page klasama treba da budu opisane akcije koje radimo kako bi neko mogao da procita naredne linije i razume sta se radi
  public void clickOnElementsButton () {
        getElementsButton().click();
  }

}
