package src.Controller.Administration.Mode;

/**
 * Eine Aktion, welche vom Best�tigungspanel entweder durchgef�hrt,
 * oder abgelehnt werden kann
 */
public class ConfirmAction
{
    private final String confirmMessage;
    private final Runnable actionOnConfirm;

    /**
     * Standardkonstruktor der ConfirmAction
     * @param confirmMessage Nachricht der Aktion
     * @param actionOnConfirm Auszuf�hrende Funktion
     */
    public ConfirmAction(String confirmMessage, Runnable actionOnConfirm)
    {
        this.confirmMessage = confirmMessage;
        this.actionOnConfirm = actionOnConfirm;
    }

    /**
     * Methode zum Ausgeben der Best�tigungsnachricht
     * @return Best�tigungsnachricht als String
     */
    public String getMessage()
    {
        return confirmMessage;
    }

    /**
     * Methode zum Ausf�hren der Aktion
     */
    public void run()
    {
        actionOnConfirm.run();
    }
}
