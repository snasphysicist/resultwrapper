
package pw.snas.resultwrapper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestResult {

    private static final String failureMessage1 = "Something went wrong";
    private static final String failureMessage2 = "Something else went wrong";

    @Test
    void givenSuccessfulResultFailureMessageShouldBeEmptyString() {
        Result<String> result = new Result<String>();
        result.succeed("Example string");
        assertEquals("", result.getFailureReason());
    }

    @Test
    void givenFailedResultReturnedResultShouldBeNull() {
        Result<String> result = new Result<String>();
        result.fail(failureMessage1);
        assertNull(result.getResult());
    }

    @Test
    void givenFailedResultOnlyFailureMessageNotDefaultMessageShouldBeReturned() {
        Result<String> result = new Result<String>();
        result.fail(failureMessage1);
        assertEquals(failureMessage1, result.getFailureReason());
    }

    @Test
    void givenFailedCalledTwiceBothFailureMessagesShouldBeInReturnedMessage() {
        Result<String> result = new Result<String>();
        result.fail(failureMessage1);
        result.fail(failureMessage2);
        assertNotNull(result.getFailureReason());
        assertTrue(result.getFailureReason().contains(failureMessage1));
        assertTrue(result.getFailureReason().contains(failureMessage2));
    }

}
