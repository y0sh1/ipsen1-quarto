package ipsen1.quarto;

import ipsen1.quarto.form.Form;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.util.FormStack;

import javax.swing.*;
import java.awt.*;

/**
 * Quarto app
 */
public class QuartoApplication extends JFrame {
    public static void main(String[] args) {
        QuartoApplication app = new QuartoApplication();
        app.start(); // Kick off the application
    }

    private static QuartoApplication currentApplication = null;
    public static QuartoApplication currentApplication() {
        return currentApplication;
    }

    /**
     * The application manages a stack of Frames, of which
     * only one can be visible at a time. A new form can be pushed on
     * the stack using presentForm() and becomes the current visible form.
     * When we are done with it, we can pop it off the stack and the
     * previous form will take its place again.
     */
    private FormStack formStack = new FormStack();

    public QuartoApplication() {
        super("Quarto!");
        currentApplication = this;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * This method exists so we can run the application 'headless' for unit testing.
     */
    public void start() {
        presentForm(new Hoofdmenu());
        setVisible(true);
    }

    /**
     * Push a form to the stack and add it to the frame
     * @param Form f
     */
    public void presentForm(Form f) {
        if(formStack.notEmpty())
            remove(formStack.last());

        formStack.add(f);
        add(f);
        resizeFrame();
    }

    /**
     * Pop the last form off the stack, remove it from the frame
     * and return it.
     * @return Form
     */
    public Form popForm() {
        Form f = formStack.pop();
        if(f != null) remove(f);

        if(formStack.notEmpty()) {
            add(formStack.last());
            resizeFrame();
        }
        return f;
    }

    public Form currentForm() {
        return formStack.last();
    }

    /**
     * Resize the frame to the dimensions (preferredSize) of
     * the current form.
     */
    public void resizeFrame() {
        if(formStack.notEmpty()) {
            Dimension dim = formStack.last().getPreferredSize();
            dim.height += 20;
            dim.width += 20;
            setSize(dim);
        }
    }
}