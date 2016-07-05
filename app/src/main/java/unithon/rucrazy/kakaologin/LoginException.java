package unithon.rucrazy.kakaologin;

public class LoginException extends RuntimeException {
    public static final String USER_NAME_ERROR = "user_name error";
    public static final String PASSWORD_ERROR = "password error";
    public static final String CONNECT_ERROR = "connect_error";

    private String message;

    public LoginException(String message) {
        this.message = message;
    }
}
