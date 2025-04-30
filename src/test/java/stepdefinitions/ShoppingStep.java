package stepdefinitions;


import hook.OpenBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.LoginTask;

import static constants.Constants.*;

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

    }

    @When("realiza la compra con información {string}, {string}, {string} y un total {string}")
    public void realizaLaCompraConInformaciónYUnTotal$(String firstName, String lastName, String postalCode, String totalPrice) {


    }

    @Then("debería ver el mensaje de confirmación de pedido {string}")
    public void deberíaVerElMensajeDeConfirmaciónDePedido(String message) {

    }

}
