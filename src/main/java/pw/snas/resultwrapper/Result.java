
package pw.snas.resultwrapper;

/**
 * @author Scott Nicholas Allan Smith
 * @version 1.0.1
 * @since 1.0.0
 * @param <T>   The type of the result that the class wraps
 */

public class Result<T> {

    /**
     * The default error message
     * to be returned in the case
     * that the message is not set/updated
     */
    private static final String DEFAULT_REASON = "No result found";

    /**
     * Records whether the
     * operation to produce
     * the result was successful
     */
    private boolean success;

    /**
     * The reason that
     * the operation failed
     */
    private String failureReason;

    /**
     * The result of the operation
     * stored if it is successful
     */
    private T result;

    /**
     * Default constructor -
     * assumes failure initially
     * and sets the reason
     * to the default one
     */
    public Result() {
        success = false;
        failureReason = DEFAULT_REASON;
        result = null;
    }

    /**
     * Report that the operation was successful and provide the result of the operation
     * @param result    The result produced by the successful operation
     */
    public void succeed(T result) {
        this.result = result;
        success = true;
        failureReason = "";
    }

    /**
     * Report that the operation failed and provide a reason for the failure
     * @param message   A message to describe why the operation failed
     */
    public void fail(String message) {
        // If first time adding a reason for failure
        if (DEFAULT_REASON.equals(failureReason)) {
            // Overwrite default
            failureReason = message;
        } else {
            failureReason = failureReason + " " + message;
        }
    }

    /**
     * Check whether the operation was successful
     * @return True when the operation was reported successful, False otherwise
     */
    public boolean succeeded() {
        return success;
    }

    /**
     * Check whether the operation failed
     * @return False when the operation was reported failed, True otherwise
     */
    public boolean failed() {
        return !success;
    }

    /**
     * Get the message String explaining the reason for the failed operation
     * @return Reason or reasons that the operation did not succeed
     */
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * Get the result stored in the wrapper
     * @return The result produced by the operation
     */
    public T getResult() {
        return result;
    }

}
