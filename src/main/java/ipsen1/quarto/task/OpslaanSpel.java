package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpslaanSpel extends Task {
    public Spel huidigespel = new Spel();

    public OpslaanSpel(Spel gekozenspel) {
        huidigespel = gekozenspel;
    }

    public boolean validate() {
        return huidigespel != null;
    }

    @Override
    public void execute() {
        try{
            // Serialize data object to a file

            // Formatteer Date
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH mm");
            String dateString = df.format(new Date());

            // Voorbeeld save bestandsnaam: "Quarto 20-04-2014 21 35.sav"
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Quarto " +
                    dateString + ".sav"));
            out.writeObject(huidigespel);
            out.close();

            // Informatieve message als spel succesvol is opgeslagen.
            String message = "Het spel is succesvol opgeslagen met de naam: " + "\"Quarto " +
                    dateString + ".sav\"";
            String title = "Spel opslaan";
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
