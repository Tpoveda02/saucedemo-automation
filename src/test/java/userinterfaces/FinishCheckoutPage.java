package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class FinishCheckoutPage extends PageObject {
    public static final Target MESSAGE_COMPLETE = Target.the("Success message")
            .locatedBy("//h2[@data-test='complete-header']");

}
