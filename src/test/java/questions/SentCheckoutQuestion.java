package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterfaces.CheckoutOverviewPage.PRICE_TOTAL_IN_CHECKOUT;

public class SentCheckoutQuestion implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentCheckoutQuestion.class);
    private final String expectedPriceTotal;

    private SentCheckoutQuestion(String expectedPriceTotal) {
        this.expectedPriceTotal = expectedPriceTotal;
    }

    public static SentCheckoutQuestion verifyTotalPrice(String expectedPriceTotal) {
        return new SentCheckoutQuestion(expectedPriceTotal);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualPrice = PRICE_TOTAL_IN_CHECKOUT.resolveFor(actor).getText();
        LOGGER.debug("Price verification - Expected: {}, Actual: {}",
                expectedPriceTotal, actualPrice);

        if (!actualPrice.contains(expectedPriceTotal)) {
            String errorMsg = String.format("Price verification failed. Expected: %s, Actual: %s",
                    expectedPriceTotal, actualPrice);
            LOGGER.error(errorMsg);
            throw new AssertionError(errorMsg);
        }

        return true;
    }
}