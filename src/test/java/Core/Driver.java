package Core;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

public class Driver {

    private static WebDriver driver;
    private void startChrome() {

        //Configuração do Navegador Chrome para inibir a exibição de Ads (Anuncios) durante a execução dos testes

        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        opt.addExtensions(new File("./Extensions/AdBlock.crx"));
        opt.addArguments("--force-device-scale-factor=0.75");

        driver = new ChromeDriver(opt);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        wait.until(ExpectedConditions.titleIs("Automation Exercise"));

        String mainWindowHandle = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);

            if (!driver.getTitle().equals("Automation Exercise")) {
                wait.until(ExpectedConditions.titleIs("AdBlock está instalado!"));
                driver.close();
            }
        }

        driver.switchTo().window(mainWindowHandle);
        driver.navigate().refresh();
        driver.navigate().refresh();

        //Fim da abertura do Navegador
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public Driver(){
        startChrome();
    }
}
