package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class FormCheckoutPage extends PageObject {
    public static final Target FIELD_FIRSTNAME = Target.the("First name input box for {0}")
            .locatedBy("//input[@data-test='firstName']");

    public static final Target FIELD_LASTNAME = Target.the("Last name input box for {0}")
            .locatedBy("//input[@data-test='lastName']");

    public static final Target FIELD_POSTAL_CODE = Target.the("Postal code input box for {0}")
            .locatedBy("//input[@data-test='postalCode']");

    public static final Target SUBMIT_NEXT = Target.the("Continue and submit the form button")
            .locatedBy("//input[@type='submit']");

}
