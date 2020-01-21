
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

}
