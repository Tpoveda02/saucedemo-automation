package stepdefinitions;


import hook.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.AddProductQuestion;
import tasks.AddProductTask;
import tasks.GoToOtherPage;
import tasks.LoginTask;

import static constants.Constants.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.ProductPage.LINK_GO_CART;

public class ShoppingStep {

    @Given("un usuario se ingresó a la página de login")
    public void unUsuarioSeIngresóALaPáginaDeLogin() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenBrowser.openBrowser(WEB_URL)
        );
    }

    @When("ingresa sus credenciales válidas: usuario {string} y contraseña {string}")
    public void ingresaSusCredencialesVálidasUsuarioYContraseña(String userName, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTask.withCredentials(userName, password)
        );
    }


    @When("agrega los productos {string} y {string} al carrito")
    public void agregaLosProductosYAlCarrito(String product1, String product2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductTask.withProduct(product1),
                AddProductTask.withProduct(product2),
                GoToOtherPage.withLink(LINK_GO_CART, "se dirige al carrito de compras")
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto " + product1 + " está en la lista",
                        AddProductQuestion.verifyIfAddedProduct(product1), equalTo(true)
                )
        );

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El producto " + product2 + " está en la lista",
                        AddProductQuestion.verifyIfAddedProduct(product2), equalTo(true))
        );

    }

    @When("realiza la compra con información {string}, {string}, {string} y un total {string}")
    public void realizaLaCompraConInformaciónYUnTotal$(String firstName, String lastName, String postalCode, String totalPrice) {


    }

    @Then("debería ver el mensaje de confirmación de pedido {string}")
    public void deberíaVerElMensajeDeConfirmaciónDePedido(String message) {

    }

}
