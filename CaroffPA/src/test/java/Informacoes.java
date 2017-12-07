import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Informacoes {

    private WebDriver driver;

    public Informacoes (WebDriver driver){
        this.driver = driver;
    }

    public void cadastrarInformacoes (){

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement aderirPRA = driver.findElement(By.id("deseja_aderir_pra_sim"));
        aderirPRA.click();
        //WebElement confirmarPRA = driver.findElement(By.className("bt_ok"));
        WebElement confirmarPRA = driver.findElement(By.cssSelector("#confirmBox > div.buttons > button.bt_ok"));
        confirmarPRA.click();

        WebElement deficitRL = driver.findElement(By.id("deficit_reserva_legal_nao"));
        deficitRL.click();

        WebElement tac = driver.findElement(By.id("area_uso_restrito_nao"));
        //tac.click();
        executor.executeScript("arguments[0].click();", tac);

        WebElement prad = driver.findElement(By.id("existe_programa_recuperacaoa_areas_degradadas_nao"));
        //prad.click();
        executor.executeScript("arguments[0].click();", prad);

        WebElement infracoesAte = driver.findElement(By.id("existe_infracoes_emitidas_ate_22_julho_nao"));
        //infracoes.click();
        executor.executeScript("arguments[0].click();", infracoesAte);

//        WebElement infracoesApos = driver.findElement(By.id("existe_infracoes_emitidas_apos_22_julho_sim"));
//        //infracoes.click();
//        executor.executeScript("arguments[0].click();", infracoesApos);

        WebElement remanescenteVN = driver.findElement(By.id("vegetacao_nativa_nao"));
        //remanescenteVN.click();
        executor.executeScript("arguments[0].click();", remanescenteVN);

        WebElement patrimonioNatural = driver.findElement(By.id("patrimonio_natural_nao"));
        //patrimonioNatural.click();
        executor.executeScript("arguments[0].click();", patrimonioNatural);

        WebElement cotaFlorestal = driver.findElement(By.id("cota_reserva_florestal_nao"));
        //cotaFlorestal.click();
        executor.executeScript("arguments[0].click();", cotaFlorestal);

        WebElement legislacaoRL12651 = driver.findElement(By.id("array60042"));
        //legislacaoRL.click();
        executor.executeScript("arguments[0].click();", legislacaoRL12651);

        WebElement legislacaoRL2080 = driver.findElement(By.id("array69218"));
        //legislacaoRL.click();
        executor.executeScript("arguments[0].click();", legislacaoRL2080);

        WebElement tamanhoArea = driver.findElement(By.id("tamanho_alterado_apos_2008_sim"));
        //tamanhoArea.click();
        executor.executeScript("arguments[0].click();", tamanhoArea);

        WebElement tamanho2008 = driver.findElement(By.cssSelector("#informacoes_areaAlteradoApos2008 > input"));
        tamanho2008.sendKeys("100");

//        WebElement pagamentoRespectiva = driver.findElement(By.id("houvePagamentoRespectivaReposicaoFlorestal_nao"));
//        //tamanhoArea.click();
//        executor.executeScript("arguments[0].click();", pagamentoRespectiva);

//        WebElement processoDeRecuperacao = driver.findElement(By.id("propriedadeEmProcessoDeRecuperacaoRegeneracaoRecomposicao_nao"));
//        //tamanhoArea.click();
//        executor.executeScript("arguments[0].click();", processoDeRecuperacao);



        WebElement finalizar = driver.findElement(By.cssSelector("#form_imovel_rural > div.clear > div > button"));
        //finalizar.click();
        executor.executeScript("arguments[0].click();", finalizar);

        WebElement botaoOK = driver.findElement(By.cssSelector("#confirmBox > div:nth-child(4) > button:nth-child(1)"));
        executor.executeScript("arguments[0].click();", botaoOK);
    }
}
