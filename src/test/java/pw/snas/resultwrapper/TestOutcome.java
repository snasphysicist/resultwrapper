
package pw.snas.resultwrapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestOutcome {

    private static final String failureMessage1 = "Something went wrong";
    private static final String failureMessage2 = "Something else went wrong";

    @Test
    void givenSuccessfulOutcomeFailureMessageShouldBeEmptyString() {
        Outcome outcome = new Outcome();
        outcome.succeed();
        assertEquals("", outcome.getFailureReason());
    }

    @Test
    void givenFailedOutcomeOnlyFailureMessageNotDefaultMessageShouldBeReturned() {
        Outcome outcome = new Outcome();
        outcome.fail(failureMessage1);
        assertEquals(failureMessage1, outcome.getFailureReason());
    }

    @Test
    void givenFailedCalledTwiceBothFailureMessagesShouldBeInReturnedMessage() {
        Outcome outcome = new Outcome();
        outcome.fail(failureMessage1);
        outcome.fail(failureMessage2);
        assertNotNull(outcome.getFailureReason());
        assertTrue(outcome.getFailureReason().contains(failureMessage1));
        assertTrue(outcome.getFailureReason().contains(failureMessage2));
    }

}
