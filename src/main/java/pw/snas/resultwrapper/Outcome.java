
package pw.snas.resultwrapper;

public class Outcome {

    private static final String DEFAULT_MESSAGE = "Success has not been confirmed";

    private boolean success;
    private String failureMessage;

    public Outcome() {
        success = false;
        failureMessage = DEFAULT_MESSAGE;
    }

}
