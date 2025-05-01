package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject {
    public static final Target FIELD_USERNAME = Target.the("Username input box")
            .locatedBy("//input[@data-test='username']");

    public static final Target FIELD_PASSWORD = Target.the("Password input box")
            .locatedBy("//input[@data-test='password']");

    public static final Target SUBMIT_LOGIN = Target.the("Login button")
            .locatedBy("//input[@type='submit']");


}