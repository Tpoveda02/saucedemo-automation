package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterfaces.ProductPage.BUTTON_ADD_PRODUCT_INTO_CART;

public class AddProductTask implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddProductTask.class);
    private final String productName;

    public AddProductTask(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Adding product '{}' to cart by actor '{}'",
                productName, actor.getName());

        actor.attemptsTo(
                Click.on(BUTTON_ADD_PRODUCT_INTO_CART.of(productName))
        );

        LOGGER.debug("Product '{}' successfully added to cart", productName);
    }

    public static AddProductTask theProduct(String productName) {
        return Tasks.instrumented(AddProductTask.class, productName);
    }
}
