package ipsen1.quarto.task;

/**
 * Abstracte task waar alle andere tasks van overerven.
 */
abstract public class Task {
    abstract public boolean validate();
    abstract public void execute();

    public void run() {
        if(validate())
            execute();
    }
}
