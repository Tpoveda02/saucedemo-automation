package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
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

        SearchableTarget buttonAddProduct = BUTTON_ADD_PRODUCT_INTO_CART.of(productName);
        actor.attemptsTo(
                WaitUntil.the(buttonAddProduct, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(buttonAddProduct)
        );

        LOGGER.debug("Product '{}' successfully added to cart", productName);
    }

    public static AddProductTask theProduct(String productName) {
        return Tasks.instrumented(AddProductTask.class, productName);
    }
}
