package sprint2;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class JLineTest {
    public static void main(String[] args) {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            System.out.println("JLine 3 is working correctly.");
        } catch (Exception e) {
            System.err.println("JLine 3 encountered an error: " + e.getMessage());
        }
    }
}
