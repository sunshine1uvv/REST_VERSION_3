package by.bsuir.LabApp.Exceptions;

public class ZeroDayException extends IllegalArgumentException{
    public ZeroDayException(String line) {
        super(line);
    }
}
