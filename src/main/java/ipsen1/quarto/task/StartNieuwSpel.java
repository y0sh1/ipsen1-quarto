package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.KiesSpelersForm;

import javax.swing.*;

public class StartNieuwSpel extends Task{
    private boolean isInHoofdmenu() {
        return QuartoApplication.currentApplication().currentForm() instanceof Hoofdmenu;
    }

    @Override
    public boolean validate() {
        return isInHoofdmenu();
    }

    @Override
    public void execute() {
        Spel spel = new Spel();
        BordForm bord = new BordForm();
//        String[] spelers = new String[2];
//        spelers[0] = JOptionPane.showInputDialog("Vul de naam van Speler 1 in");
//        spelers[1] = JOptionPane.showInputDialog("Vul de naam van Speler 2 in");
//        spel.setSpelers(spelers);


        new SpeelBeurt().execute(spel, bord);

        QuartoApplication.currentApplication().presentForm(bord);
        QuartoApplication.currentApplication().presentForm(new KiesSpelersForm());
    }
}
