package pageFactory;
import static Core.Driver.getDriver;
import Core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class produtosPageFactory {

    WebDriver driver;

    telaInicialPageFactory TelaInicialPageFactory = new telaInicialPageFactory(driver);

    @FindBy(id = "search_product")
    WebElement txt_pesquisar_produtos;

    @FindBy(id = "submit_search")
    WebElement btn_pesquisar_produtos;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    WebElement btn_continuar_comprando;

    By btn_add_cart_produto = By.xpath("//div[@class='overlay-content']//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart']");

    public produtosPageFactory (WebDriver driver) {
//        this.driver = driver;
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void seachProductTxt(String produto) {
        txt_pesquisar_produtos.sendKeys(produto);
    }

    public void cleanSeachProductTxt() {
        txt_pesquisar_produtos.clear();
    }

    public void clickBtnProduct() {
        btn_pesquisar_produtos.click();
    }

    public void clickContinueBuy() {
        btn_continuar_comprando.click();
    }

    public By xpathProdutoCompra(String produto) {
        return By.xpath("//div[@class='productinfo text-center']//p[contains(text(),'" + produto + "')]");
    }

    public void clickXpathProduto(String produto) {
        getDriver().findElement(xpathProdutoCompra(produto)).click();
    }

    public void waitProductPresence(String produto) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathProdutoCompra(produto)));
    }

    public void waitAddCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(btn_add_cart_produto));
        wait.until(ExpectedConditions.elementToBeClickable(btn_add_cart_produto));

        TelaInicialPageFactory.waitSeconds(2);
    }

    public void listElementsAddCartClick() {
        List<WebElement> elementos = getDriver().findElements(btn_add_cart_produto);
        elementos.get(0).click();
        TelaInicialPageFactory.waitSeconds(1);
    }

    public void waitContinueBuy() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btn_continuar_comprando));
    }

    public void buy1Product(String produto) {
        clickXpathProduto(produto);
        waitAddCart();
        listElementsAddCartClick();
        waitContinueBuy();
        clickContinueBuy();
        cleanSeachProductTxt();
    }

    public void searchProduct(String produto) {
        seachProductTxt(produto);
        clickBtnProduct();
        TelaInicialPageFactory.waitSeconds(2);
        xpathProdutoCompra(produto);
    }
}