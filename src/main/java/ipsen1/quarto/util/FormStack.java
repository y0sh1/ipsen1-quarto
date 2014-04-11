package ipsen1.quarto.util;

import ipsen1.quarto.form.Form;

import java.util.ArrayList;

public class FormStack extends ArrayList<Form> {
    /**
     * Get the first element of the stack.
     * @return Form
     */
    public Form first() {
        return this.get(0);
    }

    /**
     * Get the last element of the stack.
     * @return Form
     */
    public Form last() {
        return this.get(this.size() - 1);
    }

    /**
     * Pop the last element off the stack and return it.
     * @return Form
     */
    public Form pop() {
        Form f = last();
        remove(this.size() - 1);
        return f;
    }

    /**
     * Shift the first form off the stack and return it.
     * @return Form
     */
    public Form shift() {
        Form f = first();
        remove(0);
        return f;
    }
}
