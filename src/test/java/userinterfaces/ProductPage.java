package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    public static final Target BUTTON_ADD_PRODUCT_INTO_CART = Target.the("Button to add product '{0}' to the cart")
            .locatedBy("//div[contains(@class, 'inventory_item')][.//div[contains(@class, 'inventory_item_name') and text()='{0}']]//button[contains(@class, 'btn_inventory')]");

    public static final Target LINK_GO_CART = Target.the("Link to the shopping cart")
            .locatedBy("//a[@class='shopping_cart_link']");


}