import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastroDominio {

    private WebDriver driver;

    public CadastroDominio (WebDriver driver){
        this.driver = driver;
    }

    public Dominio novoDominio(){
        return new Dominio(driver);
    }

    public void clickAba(){

        WebElement aba = driver.findElement(By.cssSelector("#navs > li.dominio.navs-links"));
        aba.click();
    }

}
