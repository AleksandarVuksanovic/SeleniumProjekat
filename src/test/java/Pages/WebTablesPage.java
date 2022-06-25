package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebTablesPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement addButton;
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    WebElement age;
    WebElement salary;
    WebElement department;
    WebElement submitButton;
    WebElement enteredData;
    WebElement ageEntered;
    WebElement salaryEntered;
    WebElement deleteEnteredData;

    public WebTablesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getAge() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSalary() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getDepartment() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public List <WebElement> getEnteredData() {
        return driver.findElements(By.className("rt-td"));
    }

    public WebElement getAgeEntered() {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]"));
    }

    public WebElement getSalaryEntered() {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]"));
    }

    public WebElement getDeleteEnteredData() {
        return driver.findElement(By.id("delete-record-4"));
    }


    //-------------------

    public void clickOnAddButton () {
        getAddButton().click();
    }

    public void enterFirstName (String firstName) {
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void enterLastName (String lastName) {
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }

    public void enterEmail (String email) {
        getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void enterAge (int age) {
        getAge().clear();
        getAge().sendKeys("" + age);
    }

    public void enterSalary (int salary) {
        getSalary().clear();
        getSalary().sendKeys("" + salary);
    }

    public void enterDepartment (String department) {
        getDepartment().clear();
        getDepartment().sendKeys(department);
    }

    public void clickOnSubmitButton () {
        getSubmitButton().click();
    }

    public void clickOnDeleteEnteredData () {
        getDeleteEnteredData().click();
    }

    public WebElement enteredFirstName () {
        int index = 0;
        for (int i = 0; i < getEnteredData().size(); i++) {
            if (getEnteredData().get(i).getText().equals("Marko")) {index = i;}
        }
        return getEnteredData().get(index);
    }

    public WebElement enteredLastName () {
        int index = 0;
        for (int i = 0; i < getEnteredData().size(); i++) {
            if (getEnteredData().get(i).getText().equals("Marković")) {index = i;}
        }

        return getEnteredData().get(index);
    }

    public int enteredAge () {
        String ageString = getAgeEntered().getText();
        int enteredAge = Integer.valueOf(ageString);
        return enteredAge;
    }


    public WebElement enteredEmail () {
        int index = 0;
        for (int i = 0; i < getEnteredData().size(); i++) {
            if (getEnteredData().get(i).getText().equals("mmarkovic@mail.com")) {index = i;}
        }
        return getEnteredData().get(index);
    }

    public int enteredSalary () {
        String salary = getSalaryEntered().getText();
        int enteredSalary = Integer.valueOf(salary);
        return enteredSalary;
    }


    public WebElement enteredDepartment () {
        int index = 0;
        for (int i = 0; i < getEnteredData().size(); i++) {
            if (getEnteredData().get(i).getText().equals("QA")) {index = i;}
        }
        return getEnteredData().get(index);
    }




    }



