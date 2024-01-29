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
import com.github.javafaker.Faker;

public class cadastroUsuarioPageFactory {

//    WebDriver driver;
    static Faker faker = new Faker();

    //Basics
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement txt_name_new_usuario;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement txt_email_new_usuario;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement btn_singup;

    //Full

    @FindBy(id = "id_gender1")
    WebElement radio_gender1;

    @FindBy(id = "first_name")
    WebElement txt_first_name;

    @FindBy(id = "last_name")
    WebElement txt_last_name;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "address1")
    WebElement txt_address1;

    @FindBy(id = "state")
    WebElement txt_state;

    @FindBy(id = "city")
    WebElement txt_city;

    @FindBy(id = "zipcode")
    WebElement txt_zipcode;

    @FindBy(id = "mobile_number")
    WebElement txt_mobile_number;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement btn_singup_confirm;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement msg_acount_created;

    public cadastroUsuarioPageFactory(WebDriver driver) {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void enterNameEmail() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(btn_singup));

        txt_name_new_usuario.sendKeys(faker.name().firstName());
        txt_email_new_usuario.sendKeys("testeauto"+faker.number().digits(8)+"@teste.com");
        btn_singup.click();
    }

    public void enterFullNewUser() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(btn_singup_confirm));

        radio_gender1.click();
        txt_password.sendKeys(faker.internet().password());
        txt_first_name.sendKeys(faker.name().firstName());
        txt_last_name.sendKeys(faker.name().lastName());
        txt_address1.sendKeys(faker.address().streetName());
        txt_state.sendKeys(faker.address().state());
        txt_city.sendKeys(faker.address().city());
        txt_zipcode.sendKeys(faker.address().zipCode());
        txt_mobile_number.sendKeys(faker.phoneNumber().cellPhone());
    }

    public void clickBtnProduct() {
        btn_singup_confirm.click();
    }

    public void waitProductPresence() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(msg_acount_created));
    }

}