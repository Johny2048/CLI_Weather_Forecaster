public class ExceptionMessagePrinter {
    // Inspired by: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public ExceptionMessagePrinter() {

    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ANSI_RED + exceptionMessage + ANSI_RESET);
    }
}
