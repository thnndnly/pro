package newchess.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputWrapper {

    private final Scanner scanner;
    private final PrintStream out;

    public InputWrapper(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String question) {
        out.println(question);
        return scanner.nextLine();
    }
}
