package by.bsuir.LabApp.Exceptions;

public class NegativeNumberException extends IllegalArgumentException{

    public NegativeNumberException(String line) {
        super(line);
    }
}
