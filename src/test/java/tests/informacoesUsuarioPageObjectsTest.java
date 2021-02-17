package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioPageObjectsTest.csv")

public class informacoesUsuarioPageObjectsTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    } // Cria uma instancia no navegador chrome

   // @Test
    public void testAdicionarUmaInforcacaoAdicionalDoUsuario(
            @Param(name="login")String login,
                @Param(name="senha")String senha,
                    @Param(name="tipo")String tipo,
                        @Param(name="contato")String contato,
                            @Param(name="mensagem")String mensagemEsperada
    ){
        String textToast = new LoginPage(navegador)
            .clicarSignIn()
            .fazerLogin(login,senha)
            .clicarMe()
            .clicarAbaMoreDataAboutYou()
            .clicarNoBotaoAddMoreDataAboutYou()
            .adicionarContato(tipo, contato)
            .capturarTextoToast();

                assertEquals(mensagemEsperada, textToast);
    }

    @After
    public void tearDown() {
        //fechar o navegador
           // navegador.quit();
    }
}
