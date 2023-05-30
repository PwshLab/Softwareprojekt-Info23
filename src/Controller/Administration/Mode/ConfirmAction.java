package src.Controller.Administration.Mode;

public class ConfirmAction
{
    private final String confirmMessage;
    private final Runnable actionOnConfirm;

    public ConfirmAction(String confirmMessage, Runnable actionOnConfirm)
    {
        this.confirmMessage = confirmMessage;
        this.actionOnConfirm = actionOnConfirm;
    }

    public String getMessage()
    {
        return confirmMessage;
    }

    public void run()
    {
        actionOnConfirm.run();
    }
}
