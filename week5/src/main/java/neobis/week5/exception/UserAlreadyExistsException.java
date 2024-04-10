package neobis.week5.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message){
        super("User Already Exists" + message);
    }

    public UserAlreadyExistsException() {
        super("User Already Exists");
    }
}
