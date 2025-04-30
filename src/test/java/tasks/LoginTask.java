package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static userinterfaces.LoginPage.*;

public class LoginTask implements Task {

    private final String userName;
    private final String password;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTask.class);

    public LoginTask(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("{} intenta iniciar sesión con usuario: {}", actor.getName(), userName);
        actor.attemptsTo(
                Clear.field(FIELD_USERNAME),
                Enter.theValue(userName).into(FIELD_USERNAME),
                Clear.field(FIELD_PASSWORD),
                Enter.theValue(password).into(FIELD_PASSWORD),
                Click.on(SUBMIT_LOGIN)
        );
    }

    public static LoginTask withCredentials(String userName, String password) {
        return Tasks.instrumented(LoginTask.class, userName, password);
    }
}