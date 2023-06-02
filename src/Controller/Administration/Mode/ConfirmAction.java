package src.Controller.Administration.Mode;

/**
 * Eine Aktion, welche vom Bestätigungspanel entweder durchgeführt,
 * oder abgelehnt werden kann
 */
public class ConfirmAction
{
    private final String confirmMessage;
    private final Runnable actionOnConfirm;

    public ConfirmAction(String confirmMessage, Runnable actionOnConfirm)
    {
        this.confirmMessage = confirmMessage;
        this.actionOnConfirm = actionOnConfirm;
    }

    /**
     * Methode zum Ausgeben der Bestätigungsnachricht
     * @return Bestätigungsnachricht als String
     */
    public String getMessage()
    {
        return confirmMessage;
    }

    /**
     * Methode zum Ausführen der Aktion
     */
    public void run()
    {
        actionOnConfirm.run();
    }
}
