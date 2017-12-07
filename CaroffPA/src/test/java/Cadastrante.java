import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Cadastrante {

    private WebDriver driver;

    public Cadastrante (WebDriver driver) {
        this.driver = driver;
    }

    public void cadastrarCadastrante (String cpf, String data, String nome, String nomeMae, int representante, String email,
                                      String rg, String sexo, String estadoCivil, String naturalidade, String nacionalidade,
                                      String profissao, String registro, String numeroArt, String endereco, String cep, String uf,
                                      String municipio){

        //Busca aos elementos da página
        WebElement txtCpf = driver.findElement(By.name("cadastrante.cpf"));
        txtCpf.sendKeys(cpf);

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement txtRG = driver.findElement (By.name ("cadastrante.rg"));
        WebElement txtData = driver.findElement(By.name("cadastrante.dataNascimento"));
        WebElement txtNome = driver.findElement(By.name("cadastrante.nome"));
        WebElement txtNomeMae = driver.findElement(By.name("cadastrante.nomeMae"));
        WebElement txtEmail = driver.findElement(By.id("email_representante"));

        WebElement txtEstadoCivil = driver.findElement (By.name ("cadastrante.estadoCivil"));
        WebElement txtNaturalidade = driver.findElement (By.name ("cadastrante.naturalidade"));
        WebElement txtNacionalidade = driver.findElement (By.name ("cadastrante.nacionalidade"));
        WebElement txtProfissao = driver.findElement (By.name ("cadastrante.profissao"));
        WebElement txtRegistro = driver.findElement (By.name ("cadastrante.registro"));
        WebElement txtNumeroArt = driver.findElement (By.name ("cadastrante.numeroArt"));
        WebElement txtEmailContato = driver.findElement (By.id ("email_meios_contato"));
        WebElement txtDescricaoEndereco = driver.findElement (By.cssSelector ("#form_imovel_rural > div.bloco > div.cadastrante.bloco_form > div.campo.gigante.relative.sem_altura > textarea"));
        WebElement txtCep = driver.findElement (By.name ("cadastrante.endereco.cep"));


        //Limpar campos relacionados ao CPF
        txtRG.clear ();
        txtData.clear ();
        txtNome.clear ();
        txtNomeMae.clear ();
        txtEstadoCivil.clear ();
        txtNaturalidade.clear ();
        txtNacionalidade.clear ();
        txtProfissao.clear ();
        txtRegistro.clear ();
        txtNumeroArt.clear ();
        txtEmailContato.clear ();


        WebElement comboUF = driver.findElement (By.id ("cadastrante.endereco.uf"));
        Select combo = new Select(comboUF);
        combo.selectByVisibleText(uf);

        WebElement comboMunicipio = driver.findElement (By.id ("cadastrante.endereco.municipio"));
        Select combo2 =new Select(comboMunicipio);
        combo2.selectByVisibleText (municipio);


        if (representante == 1){
            WebElement idRepresentante = driver.findElement(By.cssSelector("#representante_proprietario"));
            executor.executeScript("arguments[0].click();", idRepresentante);
            txtEmail.sendKeys(email);
        }
        else if (representante == 2){
            driver.findElement(By.id("representante_cadastrante")).click();
        }
        else if (representante == 3){
            driver.findElement(By.id("representante_pessoaJuridicaOrgao")).click();
        }

        txtNome.clear();
        txtNomeMae.clear();
        txtRG.clear();
        txtDescricaoEndereco.clear();

        //Preenchimento dos dados nas caixas de diálogo
        txtRG.sendKeys(rg);
        txtData.sendKeys(data);
        txtNome.sendKeys(nome);
        txtNomeMae.sendKeys(nomeMae);

        if (sexo.equals ("M")){
            WebElement clickSexo = driver.findElement (By.id ("sexo_masculino"));
            executor.executeScript("arguments[0].click();", clickSexo);
        }
        else {
            WebElement clickSexo = driver.findElement (By.id ("sexo_feminino"));
            executor.executeScript("arguments[0].click();", clickSexo);
        }



        txtEstadoCivil.sendKeys(estadoCivil);
        txtNaturalidade.sendKeys (naturalidade);
        txtNacionalidade.sendKeys (nacionalidade);
        txtProfissao.sendKeys (profissao);
        txtRegistro.sendKeys (registro);
        txtNumeroArt.sendKeys (numeroArt);
        txtEmailContato.sendKeys (email);
        txtDescricaoEndereco.sendKeys (endereco);
        txtCep.sendKeys (cep);




    }
}
