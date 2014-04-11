package ipsen1.quarto.util;

import ipsen1.quarto.form.Form;

import java.util.ArrayList;

public class FormStack extends ArrayList<Form> {
    /**
     * Get the first element of the stack.
     * @return Form
     */
    public Form first() {
        if(this.size() > 0)
            return this.get(0);
        return null;
    }

    /**
     * Get the last element of the stack.
     * @return Form
     */
    public Form last() {
        if(this.size() > 0)
            return this.get(this.size() - 1);
        return null;
    }

    /**
     * Pop the last element off the stack and return it.
     * @return Form
     */
    public Form pop() {
        if(this.size() > 0) {
            Form f = last();
            remove(this.size() - 1);
            return f;
        }
        return null;
    }

    /**
     * Shift the first form off the stack and return it.
     * @return Form
     */
    public Form shift() {
        if(this.size() > 0) {
            Form f = first();
            remove(0);
            return f;
        }
        return null;
    }

    /**
     * Check whether the stack is empty.
     * @return boolean
     */
    public boolean empty() {
        return this.size() == 0;
    }

    /**
     * Check whether the stack isn't empty.
     * @return boolean
     */
    public boolean notEmpty() {
        return this.size() > 0;
    }
}
