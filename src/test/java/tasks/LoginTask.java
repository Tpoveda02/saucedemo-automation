package tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.exceptions.AuthenticationException;

import static userinterfaces.LoginPage.*;

public class LoginTask implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTask.class);
    private final String userName;
    private final String password;

    public LoginTask(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Actor '{}' attempting to login with username: '{}'",
                actor.getName(),
                userName);

        try {
            actor.attemptsTo(
                    Clear.field(FIELD_USERNAME),
                    Enter.theValue(userName).into(FIELD_USERNAME),
                    Clear.field(FIELD_PASSWORD),
                    Enter.theValue(password).into(FIELD_PASSWORD),
                    Click.on(SUBMIT_LOGIN)
            );

            LOGGER.info("Actor '{}' successfully submitted login credentials",
                    actor.getName());

        } catch (Exception e) {
            LOGGER.error("Login failed for actor '{}' with username '{}'. Error: {}",
                    actor.getName(),
                    userName,
                    e.getMessage());
            throw new AuthenticationException(userName, e);
        }
    }

    public static LoginTask withCredentials(String userName, String password) {
        return Tasks.instrumented(LoginTask.class, userName, password);
    }
}