import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Documentacao {

    private WebDriver driver;

    public Documentacao (WebDriver driver){
        this.driver = driver;
    }

    public void cadastrarDocumentacao (String nomePropriedade, String area, String tipoDocumento, String numeroMatricula,
                                       String dataDocumento, String livro, String folha, String uf, String municipio){

//        WebElement txtNomePropriedade = driver.findElement(By.name("documento.nome"));
        WebElement txtNomePropriedade = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.documentacao.bloco_form > div:nth-child(5) > input"));
//        WebElement txtArea = driver.findElement(By.name("documento.area"));
        WebElement txtArea = driver.findElement(By.cssSelector("#form_imovel_rural > div.bloco > div.documentacao.bloco_form > div:nth-child(6) > input"));

        WebElement combo = driver.findElement(By.name("documento.tipoDocumento"));
        Select comboTipoDoc = new Select(combo);
        comboTipoDoc.selectByVisibleText(tipoDocumento);

        txtNomePropriedade.sendKeys(nomePropriedade);
        //Float areaReal = Float.parseFloat(area);
        txtArea.sendKeys(area);


        WebElement txtNumeroMatricula = driver.findElement (By.name ("documento.numeroMatriculaContrato"));
        WebElement txtDataDocumento = driver.findElement (By.name ("documento.dataRegistro"));
        WebElement txtLivro = driver.findElement (By.name ("documento.livro"));
        WebElement txtFolha = driver.findElement (By.name ("documento.folha"));

        txtNumeroMatricula.sendKeys (numeroMatricula);
        txtDataDocumento.sendKeys (dataDocumento);
        txtLivro.sendKeys (livro);
        txtFolha.sendKeys (folha);

        WebElement comboUfCartorio = driver.findElement (By.id ("documento.cartorio.uf"));
        Select comboUF = new Select (comboUfCartorio);
        comboUF.selectByVisibleText (uf);

        WebElement comboMunicipioDoc = driver.findElement (By.id ("documento.cartorio.municipio"));
        Select comboMunicipio = new Select (comboMunicipioDoc);
        comboMunicipio.selectByVisibleText (municipio);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement adicionarDominio = driver.findElement(By.name("documento.proprietarios[]"));
        executor.executeScript("arguments[0].click();", adicionarDominio);

        WebElement adicionarTodos = driver.findElement(By.id("todos_proprietario_documento"));
        executor.executeScript("arguments[0].click();", adicionarTodos);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botaoAdicionar = driver.findElement(By.xpath("//*[@id=\"form_imovel_rural\"]/div[1]/div[5]/div[24]/button[1]"));
        executor.executeScript("arguments[0].click();", botaoAdicionar);
    }

}
