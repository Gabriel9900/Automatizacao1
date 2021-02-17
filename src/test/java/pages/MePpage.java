package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePpage extends BasePage{
    public MePpage(WebDriver navegador) {
        super(navegador);
    }

    public MePpage clicarAbaMoreDataAboutYou(){
        //Clicar em um link que possui um texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        return this;
    }

    public AddContactPage clicarNoBotaoAddMoreDataAboutYou(){
        //Clicar no botao atraves do seu xpath //button[@data-target="addmoredata"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        return new AddContactPage(navegador);
    }

}
