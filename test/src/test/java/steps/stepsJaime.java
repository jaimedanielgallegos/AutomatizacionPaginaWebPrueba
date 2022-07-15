package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sites.pageJaime;

public class stepsJaime {
    private WebDriver driver;
    public pageJaime pagejaime;

    @Before
    public void open(){
        driver = new ChromeDriver();
        pagejaime = new pageJaime(driver);
    }
    @After
    public void close(){
        driver.close();
    }
    @Test
    public void happyPathRegister(){
        driver.get("http://127.0.0.1:5000/register");
        pagejaime.getRegistro().EnterInformationFirstForm();
    }
    @Test
    public void registerWithWrongEmail(){
        driver.get("http://127.0.0.1:5000/register");
        pagejaime.getRegistro().EnterWorngEmail();
    }
    @Test
    public void registerWithoutSexSelected(){
        driver.get("http://127.0.0.1:5000/register");
        pagejaime.getRegistro().EnterInformationWithoutSex();
    }
    @Test
    public void registerWithWrongRepeatPassword(){
        driver.get("http://127.0.0.1:5000/register");
        pagejaime.getRegistro().EnterWorngRepeatPassword();
    }
    @Test
    public void HappyPathLogin(){
        driver.get("http://localhost:5000/");
        pagejaime.getLogin().Login();
    }
    @Test
    public void loginWithWrongPassword(){
        driver.get("http://127.0.0.1:5000/");
        pagejaime.getLogin().loginWithWrongPassword();
    }
}
