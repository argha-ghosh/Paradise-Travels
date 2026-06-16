package Plane;

import LogIn.FirstPage;
import LogIn.SecondPage;

public class FieldEmptyException extends Exception {
    public FieldEmptyException(String message) {
        super(message);
    }
}