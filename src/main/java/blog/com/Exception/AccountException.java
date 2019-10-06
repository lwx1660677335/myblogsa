package blog.com.Exception;

import org.apache.shiro.authc.AuthenticationException;

public class AccountException extends AuthenticationException {
    public AccountException() {
        super();
    }
    public AccountException(String message){
        super(message);
    }

}
