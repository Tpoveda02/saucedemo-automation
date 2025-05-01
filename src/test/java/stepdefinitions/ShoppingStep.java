package stepdefinitions;


import hook.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.AddProductQuestion;
import questions.MessageConfirmationQuestion;
import questions.SentCheckoutQuestion;
import tasks.AddProductTask;
import tasks.GoToOtherPage;
import tasks.LoginTask;
import tasks.SendFormCheckoutTask;

import static constants.Constants.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static userinterfaces.CartPage.BUTTON_GO_FORM_CHECKOUT;
import static userinterfaces.CheckoutOverviewPage.BUTTON_GO_FINISH_CHECKOUT;
import static userinterfaces.FinishCheckoutPage.MESSAGE_COMPLETE;
import static userinterfaces.ProductPage.LINK_GO_CART;

public class ShoppingStep {

    @Given("un usuario se ingresó a la página de login")
    public void unUsuarioSeIngresoALaPáginaDeLogin() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                OpenBrowser.openBrowser(WEB_URL)
        );
    }

    @When("ingresa sus credenciales válidas: usuario {string} y contraseña {string}")
    public void ingresaSusCredencialesValidasUsuarioYContrasena(String userName, String password) {
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
    public void realizaLaCompraConInformacionYUnTotal$(String firstName, String lastName, String postalCode, String totalPrice) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToOtherPage.withLink(BUTTON_GO_FORM_CHECKOUT, "se dirige al formulario para completar su información"),
                SendFormCheckoutTask.withData(firstName, lastName, postalCode)
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El precio total de la compra sería " + totalPrice,
                        SentCheckoutQuestion.verifyTotalPrice(totalPrice), equalTo(true))
        );
        OnStage.theActorInTheSpotlight().attemptsTo(
                GoToOtherPage.withLink(BUTTON_GO_FINISH_CHECKOUT, "finaliza la compra")
        );

    }

    @Then("debería ver el mensaje de confirmación de pedido {string}")
    public void deberiaVerElMensajeDeConfirmacionDePedido(String message) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("El mensaje de confirmación sería " + message,
                        MessageConfirmationQuestion.verifyContentOfMessage(message, MESSAGE_COMPLETE), equalTo(true))
        );
    }

}
