package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class GoToOtherPage implements Task {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoToOtherPage.class);

    private final Target link;
    private final String description;

    public GoToOtherPage(Target link, String description) {
        this.link = link;
        this.description = description;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Actor '{}' initiating navigation to: '{}'",
                actor.getName(),
                description);

        LOGGER.debug("Locating navigation link for: {}", description);
        actor.attemptsTo(
                WaitUntil.the(link, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(link)
        );

        LOGGER.debug("Navigation action completed for: {}", description);
    }

    public static GoToOtherPage withLink(Target link, String description) {
        return Tasks.instrumented(GoToOtherPage.class, link, description);
    }

}
