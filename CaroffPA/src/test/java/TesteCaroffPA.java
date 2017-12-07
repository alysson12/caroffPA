import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteCaroffPA {

    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\barba\\Documents\\Selenium\\chromedriver.exe");
    //private ChromeDriver driver;
    private FirefoxDriver driver;
    private CadastroCadastrante cadastrante;
    private CadastroImovel imovel;
    private CadastroDominio dominio;
    private CadastroDocumentacao documentacao;
    private CadastroGeo geo;
    private CadastroInformacoes informacoes;


    @Before
    public void inicializa(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barba\\Documents\\Selenium\\geckodriver.exe");
        //this.driver = new ChromeDriver();
        this.driver = new FirefoxDriver();
        this.cadastrante = new CadastroCadastrante(driver);
        this.imovel = new CadastroImovel(driver);
        this.dominio = new CadastroDominio(driver);
        this.documentacao = new CadastroDocumentacao(driver);
        this.geo = new CadastroGeo(driver);
        this.informacoes = new CadastroInformacoes(driver);

    }


    @Test
    public void testeCaroff() throws InterruptedException {

        for (int i=1; i<2; i++) {

            String cpf = "40566043807";
            String dataNasc = "01121993";
            String nome = "Fernanda Costa";
            String nomeMae = "Pi Costa";
            String rg = "MG15737795";
            String sexo = "F"; //"M" ou "F"
            String naturalidade = "Piquete";
            String nacionalidade = "Brasil";
            String profissao = "Analista de Sistemas";
            String registro = "123454321";
            String numeroArt = "98765";
            String estadoCivil = "Solteiro(a)";

            String nomeImovel = "Fazenda Paralela " + i;
            String cep = "37200-000";
            String acesso = "Acesso via estrada de terra";
            String endereco = "Rua Antonieta";
            String numero = "1250";
            String bairro = "Centro";
            String email = "fernanda.lemaf@gmail.com";
            String uf = "Pará";
            String municipio = "Água Azul do Norte";

            String area = "100";
            String tipoDocumento = "Escritura";
            String numeroMatricula = "54321";
            String dataDocumento = "15/01/1991";
            String livro = "25";
            String folha = "512";

            String tipologia = "Floresta";
            String areaTipologia = "10";

            //String arquivoQGIS = new String("C:\\Users\\barba\\Documents\\teste_selenium\\imovel_teste.shp");
            String arquivoQGIS = new String("C:\\Users\\barba\\Documents\\Testes_com_Selenium\\PA\\imovel_" + i + ".zip");
            String pontoQGIS = new String("C:\\Users\\barba\\Documents\\Testes_com_Selenium\\PA\\imovel_" + i + "_ponto" +".shp");




            //----------------------REPRESENTANTE----------------------//
            //Representante
            //1 - Não possuo representante
            //2 - Possuo representante, e ele é o cadastrante
            //3 - Possuo representante, mas ele não é o cadastrante
            //---------------------------------------------------------//

            //-----------------------CADASTRANTE-----------------------//
            cadastrante.visita();
            cadastrante.clickAba();
            cadastrante.novoCadastrante().cadastrarCadastrante(cpf, dataNasc, nome, nomeMae,1, email,
                    rg, sexo, estadoCivil, naturalidade, nacionalidade, profissao, registro, numeroArt, endereco,
                    cep, uf, municipio);
            //---------------------------------------------------------//

            //--------------------------IMOVEL-------------------------//
            imovel.clickAba();
            imovel.novoImovel().cadastrarImovel(nomeImovel, cep, acesso, endereco, numero, bairro,
                    email, uf, municipio, tipologia, areaTipologia);
            //---------------------------------------------------------//

            //---------------------------GEO---------------------------//
//            geo.clickAba();
//            String areaImovel = geo.novoGeo().cadastrarGeo(arquivoQGIS, pontoQGIS);
            //---------------------------------------------------------//

            //-------------------------DOMINIO-------------------------//
            dominio.clickAba();
            dominio.novoDominio().cadastrarDominio(cpf);
            //---------------------------------------------------------//

            //----------------------DOCUMENTACAO----------------------//
            documentacao.clickAba();
            //documentacao.novaDocumentacao().cadastrarDocumentacao(nomeImovel, area, tipoDocumento);
//            documentacao.novaDocumentacao().cadastrarDocumentacao(nomeImovel, areaImovel, tipoDocumento, numeroMatricula,
//            dataDocumento, livro, folha, uf, municipio);
            documentacao.novaDocumentacao().cadastrarDocumentacao(nomeImovel, area, tipoDocumento, numeroMatricula,
                    dataDocumento, livro, folha, uf, municipio);
            //---------------------------------------------------------//

            //-----------------------INFORMAÇÕES-----------------------//
            informacoes.clickAba();
            informacoes.novoInformacoes().cadastrarInformacoes();
            //---------------------------------------------------------//


            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            //Não estou conseguindo puxar o valor do campo
            //Assert.assertTrue(cadastrante.existeCadastrante("Alysson Pereira", "Mãe Pereira"));
        }
    }

    //após cada método @test
    @After
    public void finaliza(){
        driver.close();
        //driver.quit();
    }

    //após o último método @test
//    @AfterClass
//    public void fechando() throws InterruptedException{
//        if (driver != null) {
//            driver.quit();
//        }
//    }


}
