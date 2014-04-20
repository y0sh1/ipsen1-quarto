package ipsen1.quarto.task;

import ipsen1.quarto.business.Spel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OpslaanSpel extends Task {
    public Spel huidigespel = new Spel();

    public OpslaanSpel(Spel gekozenspel) {
        huidigespel = gekozenspel;
    }

    public boolean validate() {
        if (huidigespel != null){
            System.out.println("Spel is niet Null");
            return true;
        } else {
            System.out.println("Spel is wel Null");
            return false;
        }
    }

    @Override
    public void execute() {
        try{
            // Serialize data object to a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("MyObject.ser"));
            out.writeObject(huidigespel);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
