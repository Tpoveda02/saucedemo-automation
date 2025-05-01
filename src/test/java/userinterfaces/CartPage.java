package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    public static final Target PRODUCT_NAME_IN_CART = Target.the("The product '{0}' is in the cart")
            .locatedBy("//div[@class='cart_item']//div[text()='{0}']");

    public static final Target BUTTON_GO_FORM_CHECKOUT = Target.the("Button to go to the information form for {0}")
            .locatedBy("//button[@data-test='checkout']");



}
