package ipsen1.quarto.task;

/**
 * Created by Y0sh1 on 08/04/14.
 */
public class SluitSpelAf extends Task {
    @Override
    public boolean validate() {
        return true; // We kunnen altijd afsluiten
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
