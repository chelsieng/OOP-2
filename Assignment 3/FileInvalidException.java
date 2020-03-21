/**
 * @author Chelsie Ng - 40071692
 * FileInvalidException Class which throws exception when file is invalid
 */
public class FileInvalidException extends Exception {
    /**
     * This is a default constructor
     */
    public FileInvalidException() {
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
    }

    /**
     * This is a constructor to pass any different error message
     *
     * @param message error message
     */
    public FileInvalidException(String message) {
        super(message);
    }
}
