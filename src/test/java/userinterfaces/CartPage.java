package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    public static final Target PRODUCT_NAME_IN_CART = Target.the("El producto '{0}' esta en el carrito")
            .locatedBy("//div[@class='cart_item']//div[text()='{0}']");
    public static final Target BUTTON_GO_FORM_CHECKOUT = Target.the("Botón hacia el forumalario de la información de {0}")
            .locatedBy("//button[@data-test='checkout']");



}
