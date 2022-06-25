package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

//Uvod: Tokom testiranja koristim IntelliJ Idea u kome kreiram Maven projekat iz razloga sto mi je lakse da ubacujem biblioteke preko pom fajla
//Prilikom testiranja koristim POM jer je laksi za odrzavanje, lakse se prati rad i elementi se definisu na samo jednom mestu
//Koristim i JUnit kako ne bih morao da ponavljam neke blokove koda i koristim Before, After i Test anotacije
//Mogu i da koristim TestNG ali sam izabrao JUnit
//Da izbegnem hardkodiranje koristim DataDrivenTesting kako lakse mogu da menjam/dodajem testne podatke ili uporedjujem dobijeni rezultat sa ocekivanim rezultatom
//Testiranje vrsim na Chrome browseru jer prema izvoru Chrome koristi trenutno 67% korisnika na svetu preko Desktopa
//Izvor: https://gs.statcounter.com/browser-market-share/desktop/worldwide
//Ako bude potrebe da se testira i na drugim browserima samo treba zameniti driver i ubaciti u directory. Na primer gecko driver za Firefox.

public class BaseTest {

    //U ovom ispod delu deklarisem driver, webdriverwait ako bude potrebe i sve stranice koje cu da testiram
    public WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String homepageURL;
    public HomepagePage homepagePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public WebTablesPage webTablesPage;


    //Da koristim TestNG ovde bih ubacio BeforeClass, taj deo koda se izvrsava samo jednom pre pocetka testiranja
//Before se izvrsava pre svakog testa i unutar te metode ubacujem sta ocekujem da se uradi pre svakog testa
    @BeforeClass
    public void setUp () throws IOException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    excelReader = new ExcelReader("C:\\Users\\aleksandar.vuksanovi\\OneDrive - Smart kolektiv\\Documents\\Aleksandar\\Aleksandar\\IT Bootcamp\\Kurs\\Selenium\\Projekat\\Test Data.xlsx");
    //Putanja koju prosledjujem za citanje excel fajla je jedinstvena za moj racunar i mora se promeniti putanja ako se testiranje vrsi na drugom racunaru
    homepageURL = excelReader.getStringData("URLs", 0, 0);
    homepagePage = new HomepagePage(driver,wdwait);
    elementsPage = new ElementsPage(driver, wdwait);
    textBoxPage = new TextBoxPage(driver, wdwait);
    checkBoxPage = new CheckBoxPage(driver, wdwait);
    webTablesPage = new WebTablesPage(driver, wdwait);
}

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void visibilityWait (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }


    @AfterClass
    public void tearDown () {
        //driver.close();
        //driver.quit();
    }



}
