package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterfaces.FormCheckoutPage.*;

public class SendFormCheckoutTask implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    private static final Logger LOGGER = LoggerFactory.getLogger(SendFormCheckoutTask.class);

    public SendFormCheckoutTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Actor '{}' submitting checkout form for {} {} (ZIP: {})",
                actor.getName(),
                firstName,
                lastName,
                postalCode);

        LOGGER.debug("Executing form submission steps...");
        actor.attemptsTo(
                Clear.field(FIELD_FIRSTNAME),
                Enter.theValue(firstName).into(FIELD_FIRSTNAME),
                Clear.field(FIELD_LASTNAME),
                Enter.theValue(lastName).into(FIELD_LASTNAME),
                Clear.field(FIELD_POSTAL_CODE),
                Enter.theValue(postalCode).into(FIELD_POSTAL_CODE),
                Click.on(SUBMIT_NEXT)
        );

        LOGGER.info("Checkout form submission completed");
    }
    public static SendFormCheckoutTask withData(String firstName, String lastName, String postalCode){
        return Tasks.instrumented(SendFormCheckoutTask.class, firstName, lastName, postalCode);
    }
}
