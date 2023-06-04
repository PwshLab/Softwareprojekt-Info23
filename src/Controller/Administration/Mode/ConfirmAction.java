package src.Controller.Administration.Mode;

/**
 * Eine Aktion, welche vom Bestaetigungspanel entweder durchgefuehrt,
 * oder abgelehnt werden kann
 */
public class ConfirmAction
{
    private final String confirmMessage;
    private final Runnable actionOnConfirm;

    /**
     * Standardkonstruktor der ConfirmAction
     * @param confirmMessage Nachricht der Aktion
     * @param actionOnConfirm Auszufuehrende Funktion
     */
    public ConfirmAction(String confirmMessage, Runnable actionOnConfirm)
    {
        this.confirmMessage = confirmMessage;
        this.actionOnConfirm = actionOnConfirm;
    }

    /**
     * Methode zum Ausgeben der Bestaetigungsnachricht
     * @return Bestaetigungsnachricht als String
     */
    public String getMessage()
    {
        return confirmMessage;
    }

    /**
     * Methode zum Ausfuehren der Aktion
     */
    public void run()
    {
        actionOnConfirm.run();
    }
}
