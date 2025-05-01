package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.exceptions.MessageContentMismatchException;

public class MessageConfirmationQuestion implements Question<Boolean> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConfirmationQuestion.class);

    private final String expectedText;
    private final Target target;

    public MessageConfirmationQuestion(String expectedText, Target target) {
        this.expectedText = expectedText;
        this.target = target;
    }

    public static MessageConfirmationQuestion verifyContentOfMessage(String expectedText, Target target) {
        return new MessageConfirmationQuestion(expectedText, target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualText = target.resolveFor(actor).getText();

        LOGGER.info("Expected message: '{}'", expectedText);
        LOGGER.info("Actual UI message: '{}'", actualText);

        if (actualText.contains(expectedText)) {
            LOGGER.info("The confirmation message is correct.");
            return true;
        } else {
            LOGGER.error("Message mismatch. Expected: '{}', but found: '{}'", expectedText, actualText);
            throw new MessageContentMismatchException(expectedText, actualText);
        }
    }
}
