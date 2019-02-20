package exceptions;

/**
 * Created by supiccc on 2019-02-19 15:36
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("user not found, please check your username");
    }
}
