package ipsen1.quarto.task;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.business.Spel;
import ipsen1.quarto.form.BordForm;
import ipsen1.quarto.form.Hoofdmenu;
import ipsen1.quarto.form.InGameMenu;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LaadSpel extends Task {
    private Spel spel;
    private BordForm bord;

    @Override
    public boolean validate() {
        return QuartoApplication.currentApplication().currentForm() instanceof Hoofdmenu ||
               QuartoApplication.currentApplication().currentForm() instanceof InGameMenu;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);

        int returnValue = fileChooser.showOpenDialog(QuartoApplication.currentApplication());
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            if(setSaveGame(fileChooser.getSelectedFile())) {
                bord = new BordForm();

                new SpeelBeurt().execute(spel, bord);
                QuartoApplication.currentApplication().presentForm(bord);
            }
        }
    }

    public boolean setSaveGame(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            spel = (Spel) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
