package neobis.week4.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message){
        super("User Already Exists" + message);
    }

    public UserAlreadyExistsException() {
        super("User Already Exists");
    }
}
