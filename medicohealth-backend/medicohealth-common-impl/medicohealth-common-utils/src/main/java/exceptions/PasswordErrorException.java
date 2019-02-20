package exceptions;

/**
 * Created by supiccc on 2019-02-19 15:37
 */
public class PasswordErrorException extends Exception {
    public PasswordErrorException() {
        super("Your password is not true, please check your password");
    }
}
