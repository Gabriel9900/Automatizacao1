package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    //Teste na nuvem
    public static final String AUTOMATE_USERNAME = "gabrielnogueira2";
    public static final String AUTOMATE_ACCESS_KEY = "jrsW62xTrMGxpsD6V2sb";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Gabri\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navegar para a pagina do taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador; // retorna o navegador

        // Cria uma instancia no navegador chrome
    }

    public static WebDriver creatBrowserStack(){
            //Teste na nuvem
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "60.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("browserstack.debug", "true");


        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //navegar para a pagina do taskit!
            navegador.get("http://www.juliodelima.com.br/taskit");
        } catch (MalformedURLException e) {
            System.out.printf("Houveram problemas com sua url: " + e.getMessage());
        }

        return navegador;

        // Cria uma instancia no navegador chrome pela nuvem
    }
}

