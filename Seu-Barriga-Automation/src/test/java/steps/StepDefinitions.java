package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class StepDefinitions {

    private WebDriver driver;

    @Dado("que estou acessando a aplicacao")
    public void queEuEstouAcessandoAAplicacao() {
        //System.out.println("Acessando a aplicação");
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Quando("informo o usuario {string}")
    public void informoOUsuario(String usuario) {
        //System.out.println("Informando o usuário: " + usuario);
        driver.findElement(By.id("email")).sendKeys(usuario);
    }

    @E("a senha {string}")
    public void aSenha(String senha) {
        //System.out.println("Informando a senha: " + senha);
        driver.findElement(By.id("senha")).sendKeys(senha);
    }

    @E("seleciono entrar")
    public void selecionoEntrar() {
        //System.out.println("Selecionando entrar");
        driver.findElement(By.xpath("/html/body/div[2]/form/button")).click();
    }

    @Entao("visualizo a pagina inicial")
    public void visualizoAPaginaInicial() {
        //System.out.println("Visualizando a pagina inicial");
        String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
        Assert.assertEquals("Bem vindo, Abc!", texto);
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        //System.out.println("Selecionando Contas");
        driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a")).click();
    }

    @E("seleciono Adicionar")
    public void selecionoAdicionar() {
        //System.out.println("Selecionando Adicionar");
        driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a")).click();
    }

    @E("informo a conta {string}")
    public void informoAConta(String conta) {
        //System.out.println("Informando a conta: " + conta);
        driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys(conta);
    }

    @E("seleciono Salvar")
    public void selecionoSalvar() {
        //System.out.println("Selecionando Salvar");
        driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button")).click();
    }

//    @Entao("a conta e inserida com sucesso")
//    public void aContaEInseridaComSucesso() {
//        System.out.println("Conta inserida com sucesso");
//        String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
//        Assert.assertEquals("Conta adicionada com sucesso!", texto);
//    }
//
//    @Entao("sou notificado que o nome da conta e obrigatorio")
//    public void souNotificadoQueONomeDaContaEObrigatorio() {
//        System.out.println("Nome da conta e obrigatorio");
//        String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
//        Assert.assertEquals("Informe o nome da conta", texto);
//    }
//
//    @Entao("sou notificado que ja existe uma conta com esse nome")
//    public void souNotificadoQueJaExisteUmaContaComEsseNome() {
//        System.out.println("Ja existe uma conta com esse nome");
//        String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
//        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
//    }

    @Entao("recebo a mensagem {string}")
    public void receboAMensagem(String mensagem) {
        //System.out.println("Recebendo a mensagem: " + mensagem);
        String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
        Assert.assertEquals(mensagem, texto);
    }

    @After(order = 1)
    public void screenshot(Scenario cenario) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getId() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0)
    public void fecharBrowser() {
        driver.quit();
    }

}
