import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Imovel {

    private WebDriver driver;

    public Imovel (WebDriver driver){
        this.driver = driver;
    }

    public void cadastrarImovel (String nome, String cep, String acesso, String endereco, String numero, String bairro,
                                 String email, String UF, String municipio, String tipologia, String areaTipologia){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement txtNome = driver.findElement(By.name("imovel.nome"));
        WebElement txtCep = driver.findElement(By.name("imovel.cep"));
        WebElement txtAreaAcesso = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.imovel.bloco_form > div.campo.gigante.relative.sem_altura > textarea"));
        WebElement txtEndereco = driver.findElement(By.name("imovel.endereco.logradouro"));
        WebElement txtNumero = driver.findElement(By.name("imovel.endereco.numero"));
        WebElement txtBairro = driver.findElement(By.name("imovel.endereco.bairro"));
        WebElement txtCepLogradouro = driver.findElement(By.name("imovel.endereco.cep"));
        WebElement txtEmail = driver.findElement(By.name("imovel.endereco.email"));
        WebElement txtAreaTipologia = driver.findElement (By.name ("imovel.tipologia.area"));

        WebElement atividadeDesenvolvida = driver.findElement(By.id("Agricultura_desenvolvida"));
        executor.executeScript("arguments[0].click();", atividadeDesenvolvida);

        txtNome.sendKeys(nome);
        txtCep.sendKeys(cep);
        txtAreaAcesso.sendKeys(acesso);
        txtEndereco.sendKeys(endereco);
        txtNumero.sendKeys(numero);
        txtBairro.sendKeys(bairro);
        txtCepLogradouro.sendKeys(cep);
        txtEmail.sendKeys(email);

        //selecao de estado
        WebElement combo = driver.findElement(By.name("imovel.endereco.uf"));
        Select comboUF = new Select(combo);
        comboUF.selectByVisibleText(UF);

        // Municipio
        WebElement combo2 = driver.findElement(By.id ("imovel.municipio"));
        Select comboMunicipio = new Select(combo2);
        comboMunicipio.selectByVisibleText(municipio);

        WebElement botaoOK = driver.findElement(By.cssSelector("#winBox > div.buttons > button"));
        botaoOK.click();

        WebElement combo3 = driver.findElement(By.id ("imovel.endereco.municipio"));
        Select comboMunicipio2 = new Select(combo3);
        comboMunicipio2.selectByVisibleText(municipio);

        //tipologia
        WebElement combo4 = driver.findElement (By.name ("imovel.tipologia.tipo"));
        Select comboTipologia = new Select(combo4);
        comboTipologia.selectByVisibleText (tipologia);

        txtAreaTipologia.sendKeys (areaTipologia);

        WebElement botaoAdicionarTipologia = driver.findElement(By.xpath ("//*[@id=\"form_imovel_rural\"]/div[1]/div[3]/div[22]/div/div[3]/button"));
        executor.executeScript("arguments[0].click();", botaoAdicionarTipologia);


    }

//    public void proximaPagina (){
//        WebElement proximo = driver.findElement(By.cssSelector("#button avancar"));
//        proximo.click();
//    }

}
