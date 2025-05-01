package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class CheckoutOverviewPage extends PageObject {

    public static final Target PRICE_TOTAL_IN_CHECKOUT = Target.the("The total purchase price")
            .locatedBy("//div[@class='summary_total_label']");

    public static final Target BUTTON_GO_FINISH_CHECKOUT = Target.the("Button to finish the purchase")
            .locatedBy("//button[@data-test='finish']");

}
