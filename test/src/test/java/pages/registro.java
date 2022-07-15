package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sites.pageJaime;

import static org.junit.Assert.*;

public class registro {
    WebDriver driver;
    WebDriverWait wait;
    public pageJaime pagejaime;
    public registro(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver,5);
        this.pagejaime= new pageJaime(driver);
    }
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="repeatPassword")
    WebElement repeatPassword;

    @FindBy(className="next")
    WebElement next;

    @FindBy(css = "[value='female']")
    WebElement female;

    @FindBy(css = "[value='male']")
    WebElement male;

    @FindBy(css = "[value='Nuevo León']")
    WebElement edo;

    @FindBy(id = "age")
    WebElement age;

    @FindBy(className="send")
    WebElement submit;
    public void EnterInformationFirstForm(){
        username.sendKeys("jaime");
        email.sendKeys("jaime@jaime.com");
        password.sendKeys("12345678");
        repeatPassword.sendKeys("12345678");
        next.click();
        wait.until(ExpectedConditions.visibilityOf(male));
        male.click();
        edo.click();
        age.sendKeys("25");
        submit.click();
        wait.until(ExpectedConditions.visibilityOf(pagejaime.getLogin().email));
        assertEquals("http://127.0.0.1:5000/",driver.getCurrentUrl());
    }
    public void EnterWorngEmail(){
        username.sendKeys("jaime");
        email.sendKeys("jaime");
        password.sendKeys("12345678");
        repeatPassword.sendKeys("12345678");
        next.click();
        assertFalse(male.isDisplayed());
    }
    public void EnterInformationWithoutSex(){
        username.sendKeys("jaime");
        email.sendKeys("jaime@jaime.com");
        password.sendKeys("12345678");
        repeatPassword.sendKeys("12345678");
        next.click();
        wait.until(ExpectedConditions.visibilityOf(male));
        edo.click();
        age.sendKeys("25");
        submit.click();
        assertEquals("http://127.0.0.1:5000/register",driver.getCurrentUrl());
    }
    public void EnterWorngRepeatPassword(){
        username.sendKeys("jaime");
        email.sendKeys("jaime@jaime.com");
        password.sendKeys("12345678");
        repeatPassword.sendKeys("123456789");
        next.click();
        assertFalse(male.isDisplayed());
    }
}
