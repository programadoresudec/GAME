package assets;

public class SoundException extends Exception {

    SoundException(String string) {
        super(string);
    }
//this is a builder's
    public SoundException(String fileName, Throwable cause) {
        super("Cannot read/play " + fileName + ": " + cause.getMessage());
    }

    public SoundException(Throwable cause) {
        super(cause);
    }
}
