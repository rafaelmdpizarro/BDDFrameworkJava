package pageFactory;
import static Core.Driver.getDriver;
import Core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class telaInicialPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    WebElement menuHome;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement menuProdutos;

    @FindBy(id = "search_product")
    WebElement txt_pesquisar_produtos;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement menuSignupLogin;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement menuCarrinho;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement btnCheckOut;

    public telaInicialPageFactory (WebDriver driver) {
//        this.driver = driver;
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void waitLoadingHomePage () {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(menuHome));
        wait.until(ExpectedConditions.visibilityOf(menuProdutos));
    }

    public void clickMenuProduto () {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(menuProdutos));
        menuProdutos.click();
        wait.until(ExpectedConditions.visibilityOf(txt_pesquisar_produtos));
    }

    public void clickSignupLogin () {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(menuSignupLogin));
        menuSignupLogin.click();
    }

    public void clickMenuCarrinho () {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(menuCarrinho));
        menuCarrinho.click();
    }

    public void waitCheckOut () {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(btnCheckOut));
    }

    public void waitSeconds (int time){

        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
