package fr.paul.tChaton.api.exception;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public class UserIdNotFound extends Exception {

    private static String id = "E001";

    public UserIdNotFound(String message) {
        super("id: "+id+". "+message);
    }
}
