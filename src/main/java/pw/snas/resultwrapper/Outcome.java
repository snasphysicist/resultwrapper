
package pw.snas.resultwrapper;

public class Outcome {

    private static final String DEFAULT_MESSAGE = "Success has not been confirmed";

    private boolean success;
    private String failureReason;

    public Outcome() {
        success = false;
        failureReason = DEFAULT_MESSAGE;
    }

    public void succeed() {
        success = true;
        failureReason = "";
    }

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

    public boolean succeeded() {
        return success;
    }

    public boolean failed() {
        return !success;
    }

    public String getFailureReason() {
        return failureReason;
    }

}
