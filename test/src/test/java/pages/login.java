package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class login {
    WebDriver driver;
    WebDriverWait wait;
    public login(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,5);
    }

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(className = "loginButton")
    WebElement login;

    @FindBy(id = "error")
    WebElement  errorMessage;

    @FindBy(id = "success")
    WebElement  successMessage;
    public void Login(){
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("jaime@gmail.com");
        password.sendKeys("12345678");
        login.click();
        assertTrue(successMessage.isDisplayed());
    }

    public void loginWithWrongPassword(){
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("jaime@gmail.com");
        password.sendKeys("123456");
        login.click();
        assertTrue(errorMessage.isDisplayed());
    }
}
