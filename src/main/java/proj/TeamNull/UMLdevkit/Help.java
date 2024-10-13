package proj.TeamNull.UMLdevkit;

public class Help {

    public enum HelpType{
        METHOD,
        FIELD,
        PARAMETER,
        CLASS,
        DISPLAY,
        GENERAL
    }


    public String getHelp(HelpType type) {

        if(type == null){
            return "Invalid help type.";
        }

        switch (type) {
            case METHOD: return "Method help info.";
            case FIELD: return "Field help info.";
            case PARAMETER: return "Parameter help info.";
            case CLASS: return "Class help info.";
            case DISPLAY: return "Display help info.";
            case GENERAL: return "General help info.";
            default: return "Invalid help type.";
        }
    }
}
