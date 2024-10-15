package proj.TeamNull.UMLdevkit.Menu;

import java.util.Scanner;

public class Help {

    public enum HelpType {
        METHOD(1),
        FIELD(2),
        PARAMETER(3),
        CLASS(4),
        DISPLAY(5),
        GENERAL(6);

        private final int menuChoice;

        HelpType(int menuChoice) {
            this.menuChoice = menuChoice;
        }

        public static HelpType fromInt(int menuChoice) {
            for (HelpType type : HelpType.values()) {
                if (type.menuChoice == menuChoice) {
                    return type;
                }
            }
            return null;
        }
    }


    public String getHelp(HelpType type) {
        if (type == null) {
            return "Invalid help type.";
        }

        switch (type) {
            case METHOD:
                return "Method help info.";
            case FIELD:
                return "Field help info.";
            case PARAMETER:
                return "Parameter help info.";
            case CLASS:
                return "Class help info.";
            case DISPLAY:
                return "Display help info.";
            case GENERAL:
                return "General help info.";
            default:
                return "Invalid help type.";
        }
    }

    public void printHelpMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("+-----------------------------+");
        System.out.println("|       Help Menu             |");
        System.out.println("+-----------------------------+");
        System.out.println("| 1. Methods                  |");
        System.out.println("| 2. Fields                   |");
        System.out.println("| 3. Parameters               |");
        System.out.println("| 4. Classes                  |");
        System.out.println("| 5. Displays                 |");
        System.out.println("| 6. General                  |");
        System.out.println("| 7. Exit                     |");
        System.out.println("+-----------------------------+");
        System.out.print("Enter your choice: ");
        processHelpMenuInput(sc.nextInt());


    }

    private void processHelpMenuInput(int choice) {
        HelpType type = HelpType.fromInt(choice);
        String helpInfo = getHelp(type);
        System.out.println(helpInfo);
    }
}