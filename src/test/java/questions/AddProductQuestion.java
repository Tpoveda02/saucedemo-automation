package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.exceptions.ElementNotVisibleException;

import static userinterfaces.CartPage.PRODUCT_NAME_IN_CART;

public class AddProductQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductQuestion.class);
    private final String nameProduct;

    private AddProductQuestion(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public static AddProductQuestion verifyIfAddedProduct(String nameProduct) {
        return new AddProductQuestion(nameProduct);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isVisible = PRODUCT_NAME_IN_CART.of(nameProduct).resolveFor(actor).isVisible();

        if (isVisible) {
            LOGGER.info("The product '{}' is visible in the cart.", nameProduct);
            return true;
        } else {
            LOGGER.error("The product '{}' was NOT found in the cart.", nameProduct);
            throw new ElementNotVisibleException("The product '" + nameProduct + "' was not found in the cart.");
        }
    }
}
