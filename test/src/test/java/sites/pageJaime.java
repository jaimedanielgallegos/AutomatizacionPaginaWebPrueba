package sites;

import org.openqa.selenium.WebDriver;
import pages.*;

public class pageJaime {
    public WebDriver driver;

    public pageJaime(WebDriver driver){
        this.driver = driver;
    }
    public login getLogin(){
        return new login(driver);
    }
    public registro getRegistro(){return new registro(driver);}
}
