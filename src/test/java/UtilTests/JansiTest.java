package UtilTests;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class JansiTest {
    public static void main(String[] args) {
        // Enable Jansi on the console
        AnsiConsole.systemInstall();

        // Print colored text
        System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("This text is red").reset());
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a("This text is green").reset());

        // Restore the console
        AnsiConsole.systemUninstall();
    }
}
