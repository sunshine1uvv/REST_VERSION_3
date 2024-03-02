package by.bsuir.LabApp.Handler;


import by.bsuir.LabApp.Exceptions.NegativeNumberException;
import by.bsuir.LabApp.Exceptions.ZeroDayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        logger.error("*LOGGER* NullPointerException was thrown. The user did not submit any values");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ZeroDayException.class)
    public ResponseEntity<String> handleZeroDayException(ZeroDayException e) {
        logger.error("*LOGGER* ZeroDayException was thrown. The user entered a day equal to 0");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NegativeNumberException.class)
    public ResponseEntity<String> handleNegativeNumberException(NegativeNumberException e) {
        logger.error("*LOGGER* NegativeNumberException was thrown. The user entered a negative values");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("*LOGGER* " + e.getClass() + " was thrown.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}