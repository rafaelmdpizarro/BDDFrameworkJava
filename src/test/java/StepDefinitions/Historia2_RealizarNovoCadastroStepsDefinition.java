package StepDefinitions;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pageFactory.cadastroUsuarioPageFactory;
import pageFactory.telaInicialPageFactory;

public class Historia2_RealizarNovoCadastroStepsDefinition {

    WebDriver driver;
    cadastroUsuarioPageFactory CadastroUsuarioPageFactory;

    @E("informo Nome e Email")
    public void informo_nome_e_email() {
        CadastroUsuarioPageFactory = new cadastroUsuarioPageFactory(driver);
        CadastroUsuarioPageFactory.enterNameEmail();
    }
    @E("preencho as informacoes obrigatorios para o cadastro")
    public void preencho_as_informacoes_obrigatorios_para_o_cadastro() {
        CadastroUsuarioPageFactory.enterFullNewUser();
    }
    @E("confirmo o novo cadastro")
    public void confirmo_o_novo_cadastro() {
        CadastroUsuarioPageFactory.clickBtnProduct();
    }
    @Entao("o novo cadastro e realizado")
    public void o_novo_cadastro_e_realizado() {
        CadastroUsuarioPageFactory.waitProductPresence();
    }

}