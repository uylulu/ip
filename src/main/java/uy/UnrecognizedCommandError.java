package uy;
public class UnrecognizedCommandError extends Exception{
    public UnrecognizedCommandError(String message){
        super(message);
    }
}
