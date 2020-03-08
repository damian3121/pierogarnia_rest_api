package jezowe.pierogarnia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CanNotFindResourceProblem extends RuntimeException {
    public CanNotFindResourceProblem() {
        super();
    }

    public CanNotFindResourceProblem(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotFindResourceProblem(String message) {
        super(message);
    }

    public CanNotFindResourceProblem(Throwable cause) {
        super(cause);
    }
}
