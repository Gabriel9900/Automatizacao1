package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage digitarLogin(String login) { // METODO ESTRUTURAL

        //Identificando o formulario Login e digitar no campo com o name "Login" que esta dentro do formulario de id "signinbox"
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
        }

        public LoginFormPage digitarSenha(String password){
            //Digitar no campo com o name "Password" que esta dentro do formulario de id "signinbox"
            navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
        }

        public SecretaPage clicasSignIn(){
            //Clicar no link com o texto "SIGN IN"
            navegador.findElement(By.linkText("SIGN IN")).click();

            return new SecretaPage(navegador);
        }

        public SecretaPage fazerLogin(String login, String password){  // METODO FUNCIONAL
            digitarLogin(login);
            digitarSenha(password);
            clicasSignIn();

            return new SecretaPage(navegador);
        }
}
