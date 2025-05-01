package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    public static final Target BUTTON_ADD_PRODUCT_INTO_CART = Target.the("Botón para agregar el producto '{0}' al carrito")
            .locatedBy("//div[contains(@class, 'inventory_item')][.//div[contains(@class, 'inventory_item_name') and text()='{0}']]//button[contains(@class, 'btn_inventory')]");
    public static final Target LINK_GO_CART = Target.the("Enlace hacia el carrito de compras")
            .locatedBy("//a[@class='shopping_cart_link']");

}