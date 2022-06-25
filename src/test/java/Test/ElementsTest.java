package Test;

import Base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp () {
        driver.manage().window().maximize();
        driver.navigate().to(homepageURL);
    }

    @Test (priority = 10)
    public void userCanAddValidDataToTextBox () throws InterruptedException {
    String fullName = excelReader.getStringData("Text Box Data", 1,0);
    String email = excelReader.getStringData("Text Box Data", 1, 1);
    String currentAddress = excelReader.getStringData("Text Box Data", 1, 2);
    String permanentAddress = excelReader.getStringData("Text Box Data", 1, 3);

    scrollIntoView(homepagePage.getElementsButton());
    homepagePage.clickOnElementsButton();
    elementsPage.clickOnTextboxButton();
    textBoxPage.enterFullName(fullName);
    textBoxPage.enterEmail(email);
    textBoxPage.enterCurrentAddress(currentAddress);
    textBoxPage.enterPermanentAddress(permanentAddress);
    scrollIntoView(textBoxPage.getSubmitButton());
    textBoxPage.clickOnSubmitButton();

    Assert.assertTrue(textBoxPage.getSubmitedFullName().isDisplayed());
    Assert.assertTrue(textBoxPage.getSubmitedEmail().isDisplayed());
    Assert.assertTrue(textBoxPage.getSubmitedCurrentAddress().isDisplayed());
    Assert.assertTrue(textBoxPage.getSubmitedPermanentAddress().isDisplayed());

    }

    @Test (priority = 20)
    public void userCannotAddInvalidEmailToTextBox () throws InterruptedException {
    String fullName = excelReader.getStringData("Text Box Data", 1,0);
    String invalidEmail = excelReader.getStringData("Text Box Data", 1, 4);
    String currentAddress = excelReader.getStringData("Text Box Data", 1, 2);
    String permanentAddress = excelReader.getStringData("Text Box Data", 1, 3);

   scrollIntoView(homepagePage.getElementsButton());
   homepagePage.clickOnElementsButton();
   elementsPage.clickOnTextboxButton();
   textBoxPage.enterFullName(fullName);
   textBoxPage.enterEmail(invalidEmail);
   textBoxPage.enterCurrentAddress(currentAddress);
   textBoxPage.enterPermanentAddress(permanentAddress);
   scrollIntoView(textBoxPage.getSubmitButton());
   textBoxPage.clickOnSubmitButton();

   boolean check = false;
   try {
      check = textBoxPage.getSubmitedFullName().isDisplayed();
   } catch (Exception e) {}
   Assert.assertFalse(check);

   boolean check01 = false;
   try {
   check01 = textBoxPage.getSubmitedEmail().isDisplayed();
   } catch (Exception e) {}
   Assert.assertFalse(check01);

   boolean check02 = false;
   try {
   check02 = textBoxPage.getSubmitedCurrentAddress().isDisplayed();
   } catch (Exception e) {}
   Assert.assertFalse(check02);

   boolean check03 = false;
   try {
  check03 = textBoxPage.getSubmitedEmail().isDisplayed();
  } catch (Exception e) {}
  Assert.assertFalse(check03);

  boolean check04 = false;
  try {
  check04 = textBoxPage.getSubmitedCurrentAddress().isDisplayed();
  } catch (Exception e) {}
  Assert.assertFalse(check04);

    }


  @Test (priority = 30)
  public void userCannotSubmitEmptyTextBox () throws InterruptedException {
  scrollIntoView(homepagePage.getElementsButton());
  homepagePage.clickOnElementsButton();
  elementsPage.clickOnTextboxButton();
  scrollIntoView(textBoxPage.getSubmitButton());
  textBoxPage.clickOnSubmitButton();

      boolean check = false;
      try {
          check = textBoxPage.getSubmitedFullName().isDisplayed();
      } catch (Exception e) {}
      Assert.assertFalse(check);

      boolean check01 = false;
      try {
          check01 = textBoxPage.getSubmitedEmail().isDisplayed();
      } catch (Exception e) {}
      Assert.assertFalse(check01);

      boolean check02 = false;
      try {
          check02 = textBoxPage.getSubmitedCurrentAddress().isDisplayed();
      } catch (Exception e) {}
      Assert.assertFalse(check02);

      boolean check03 = false;
      try {
          check03 = textBoxPage.getSubmitedEmail().isDisplayed();
      } catch (Exception e) {}
      Assert.assertFalse(check03);

      boolean check04 = false;
      try {
          check04 = textBoxPage.getSubmitedCurrentAddress().isDisplayed();
      } catch (Exception e) {}
      Assert.assertFalse(check04);
  }

  @Test (priority = 40)
  public void userCanCheckHomeCheckBox() throws InterruptedException {
        scrollIntoView(homepagePage.getElementsButton());
        homepagePage.clickOnElementsButton();
        elementsPage.clickOnCheckBoxButton();
        checkBoxPage.clickOnHomeCheckBox();

        Assert.assertTrue(checkBoxPage.getSuccessNotification().isDisplayed());

        String expectedNotification = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";

        Assert.assertEquals(checkBoxPage.getSuccessNotification().getText(),expectedNotification);

        checkBoxPage.clickOnHomeCheckBox();
        boolean check = false;
        try {
            check = checkBoxPage.getSuccessNotification().isDisplayed();
        } catch (Exception e) {}
        Assert.assertFalse(check);
       }

       @Test (priority = 50)
       public void userCanCheckDesktopCheckBox () throws InterruptedException {
           scrollIntoView(homepagePage.getElementsButton());
           homepagePage.clickOnElementsButton();
           elementsPage.clickOnCheckBoxButton();
           visibilityWait(checkBoxPage.getHomeExpandButton());
           checkBoxPage.clickOnHomeExpandButton();
           visibilityWait(checkBoxPage.desktopCheckBox());
           checkBoxPage.clickOnDesktopCheckBox();

           Assert.assertTrue(checkBoxPage.getSuccessNotification().isDisplayed());
           String expectedNotification = "You have selected :\n" +
                   "desktop\n" +
                   "notes\n" +
                   "commands";
           Assert.assertEquals(checkBoxPage.getSuccessNotification().getText(), expectedNotification);

           checkBoxPage.clickOnDesktopCheckBox();
           boolean check = false;
           try {
               check = checkBoxPage.getSuccessNotification().isDisplayed();
           } catch (Exception e) {}
           Assert.assertFalse(check);

       }

       @Test (priority = 60)
       public void userCanCheckDocumentsCheckBox () throws InterruptedException {
        scrollIntoView(homepagePage.getElementsButton());
        homepagePage.clickOnElementsButton();
        elementsPage.clickOnCheckBoxButton();
        wdwait.until(ExpectedConditions.visibilityOf(checkBoxPage.getHomeExpandButton()));
        checkBoxPage.clickOnHomeExpandButton();
        checkBoxPage.clickOnDocumentsCheckBox();

        wdwait.until(ExpectedConditions.visibilityOf(checkBoxPage.getSuccessNotification()));
        Assert.assertTrue(checkBoxPage.getSuccessNotification().isDisplayed());

        String expectedNotification = "You have selected :\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general";
        Assert.assertEquals(checkBoxPage.getSuccessNotification().getText(), expectedNotification);

        checkBoxPage.clickOnDocumentsCheckBox();
           boolean check = false;
           try {
               check = checkBoxPage.getSuccessNotification().isDisplayed();
           } catch (Exception e) {}
           Assert.assertFalse(check);
       }

       @Test (priority = 70)
       public void userCanCheckDownloadsCheckBox () {
        scrollIntoView(homepagePage.getElementsButton());
        homepagePage.clickOnElementsButton();
        elementsPage.clickOnCheckBoxButton();
        wdwait.until(ExpectedConditions.visibilityOf(checkBoxPage.getHomeExpandButton()));
        checkBoxPage.clickOnHomeExpandButton();
        checkBoxPage.clickOnDownloadsCheckBox();

        Assert.assertTrue(checkBoxPage.getSuccessNotification().isDisplayed());
        String expectedNotification = "You have selected :\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";
        Assert.assertEquals(checkBoxPage.getSuccessNotification().getText(), expectedNotification);

        checkBoxPage.clickOnDownloadsCheckBox();
           boolean check = false;
           try {
               check = checkBoxPage.getSuccessNotification().isDisplayed();
           } catch (Exception e) {}
           Assert.assertFalse(check);
       }

       @Test (priority = 80)
       public void userCanAddDataToWebTables () throws InterruptedException {
        scrollIntoView(homepagePage.getElementsButton());
        homepagePage.clickOnElementsButton();
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();

        String firstName = excelReader.getStringData("Web tables", 1, 0);
        String lastName = excelReader.getStringData("Web tables", 1, 1);
        String email = excelReader.getStringData("Web tables", 1, 2);
        int age = excelReader.getIntegerData("Web tables", 1, 3);
        int salary = excelReader.getIntegerData("Web tables", 1, 4);
        String department = excelReader.getStringData("Web tables", 1, 5);

        webTablesPage.enterFirstName(firstName);
        webTablesPage.enterLastName(lastName);
        webTablesPage.enterEmail(email);
        webTablesPage.enterAge(age);
        webTablesPage.enterSalary(salary);
        webTablesPage.enterDepartment(department);
        webTablesPage.clickOnSubmitButton();

        Assert.assertEquals(webTablesPage.enteredFirstName().getText(), firstName);
        Assert.assertEquals(webTablesPage.enteredLastName().getText(), lastName);
        Assert.assertEquals(webTablesPage.enteredAge(), age);
        Assert.assertEquals(webTablesPage.enteredEmail().getText(), email);
        Assert.assertEquals(webTablesPage.enteredSalary(),salary);
        Assert.assertEquals(webTablesPage.enteredDepartment().getText(), department);


       }




}
