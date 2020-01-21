
package pw.snas.resultwrapper;

public class Result<T> {

    private static final String DEFAULT_REASON = "No result found";

    private boolean success;
    private String failureReason;
    private T result;

    public Result() {
        success = false;
        failureReason = DEFAULT_REASON;
        result = null;
    }

    public void succeed(T result) {
        this.result = result;
        success = true;
        failureReason = "";
    }

    public void fail(String message) {
        // If first time adding a reason for failure
        if (DEFAULT_REASON.equals(failureReason)) {
            // Overwrite default
            failureReason = message;
        } else {
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

    public T getResult() {
        return result;
    }

}
