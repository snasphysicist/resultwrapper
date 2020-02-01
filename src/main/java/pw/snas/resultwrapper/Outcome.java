
package pw.snas.resultwrapper;

/**
 * @author Scott Nicholas Allan Smith
 * @version 1.0.1
 * @since 1.0.0
 */

public class Outcome {

    /**
     * Default operation failure message for when no more specific message is provided
     */
    private static final String DEFAULT_MESSAGE = "Success has not been confirmed";

    /**
     * Indicates whether the operation succeeded
     */
    private boolean success;

    /**
     * A message to describe the reason for failure
     */
    private String failureReason;

    /**
     * Default constructor -
     * assumes that the operation
     * is not successful initially
     * and sets the failure message
     * to the default one
     */
    public Outcome() {
        success = false;
        failureReason = DEFAULT_MESSAGE;
    }

    /**
     * Indicate that the operation was a success
     */
    public void succeed() {
        success = true;
        failureReason = "";
    }

    /**
     * Indicate that the operation failed and set a reason for the failure
     * @param message   A message explaining the reason that the operation failed
     */
    public void fail(String message) {
        // If the reason has not yet been updated
        if (DEFAULT_MESSAGE.equals(failureReason)) {
            // Overwrite it completely
            failureReason = message;
        } else {
            // Otherwise append new message
            failureReason = failureReason + " " + message;
        }
    }

    /**
     * Check whether the operation succeeded
     * @return True if the operation was reported successful, False otherwise
     */
    public boolean succeeded() {
        return success;
    }

    /**
     * Check whether the operation failed
     * @return False if the operation was reported successful, True otherwise
     */
    public boolean failed() {
        return !success;
    }

    /**
     * Get the reported reason(s) for the operation's failure
     * @return The provided description for the reason(s) that the operation failed
     */
    public String getFailureReason() {
        return failureReason;
    }

}
