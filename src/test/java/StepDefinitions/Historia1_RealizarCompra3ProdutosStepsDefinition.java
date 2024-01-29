package StepDefinitions;

import Core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import pageFactory.telaInicialPageFactory;
import pageFactory.produtosPageFactory;

public class Historia1_RealizarCompra3ProdutosStepsDefinition {

    WebDriver driver;
    telaInicialPageFactory TelaInicialPageFactory;
    produtosPageFactory ProdutosPageFactory;

    @Before
    public void startBrowser(){
        new Driver();
    }

    @After
    public void fechaNavegador() {
        Driver.getDriver().quit();
    }

    @Dado("que estou no portal de venda Automation Exercise")
    public void que_estou_no_portal_de_venda_automation_exercise() {
        TelaInicialPageFactory = new telaInicialPageFactory(driver);
        TelaInicialPageFactory.waitLoadingHomePage();
    }

    @Quando("clico na menu de produtos")
    public void clico_na_menu_de_produtos() {
        TelaInicialPageFactory.clickMenuProduto();
    }

    @Quando("clico na menu de Signup Login")
    public void clico_na_menu_de_signup_login() {
        TelaInicialPageFactory.clickSignupLogin();
    }

    @E("faco uma compra de tres produtos")
    public void faco_uma_compra_de_tres_produtos() {
        String Produto1 = "Stylish Dress";
        String Produto2 = "Beautiful Peacock Blue Cotton Linen Saree";
        String Produto3 = "Men Tshirt";

        //Inclusao dos Produtos 1

        ProdutosPageFactory = new produtosPageFactory(driver);

        ProdutosPageFactory.searchProduct(Produto1);

        ProdutosPageFactory.buy1Product(Produto1);
        ProdutosPageFactory.buy1Product(Produto1);
        ProdutosPageFactory.buy1Product(Produto1);

        //Inclusao dos Produtos 2

        ProdutosPageFactory.searchProduct(Produto2);

        ProdutosPageFactory.buy1Product(Produto2);
        ProdutosPageFactory.buy1Product(Produto2);

        //Inclusao do Produto 3

        ProdutosPageFactory.searchProduct(Produto3);

        ProdutosPageFactory.buy1Product(Produto3);
    }

    @Entao("a venda e concluida com sucesso")
    public void a_venda_e_concluida_com_sucesso() {
        TelaInicialPageFactory.clickMenuCarrinho();
        TelaInicialPageFactory.waitCheckOut();
    }

}