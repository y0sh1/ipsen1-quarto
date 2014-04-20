package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.InGameMenu;
import ipsen1.quarto.form.Instructies;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeesInstructies extends Task {
    private boolean isInHoofdmenu() {
        return QuartoApplication.currentApplication().currentForm() instanceof Hoofdmenu;
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public void execute() {
        QuartoApplication.currentApplication().presentForm(new Instructies());
    }

    public void hideInstructies() {
        QuartoApplication.currentApplication().popForm();
    }
}
