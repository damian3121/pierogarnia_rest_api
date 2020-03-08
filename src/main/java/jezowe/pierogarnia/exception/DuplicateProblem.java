package jezowe.pierogarnia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateProblem extends RuntimeException {
    public DuplicateProblem() {
        super();
    }

    public DuplicateProblem(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateProblem(String message) {
        super(message);
    }

    public DuplicateProblem(Throwable cause) {
        super(cause);
    }
}
