package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.menu.MenuButton;
import ipsen1.quarto.util.FontOpenSans;
import ipsen1.quarto.util.QuartoColor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructies extends Form {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public Instructies() {
        // Instellen Formaat en layout
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new BorderLayout(10, 10));
        setBackground(QuartoColor.DARK_BROWN);
        // Defineren Titel koptekst
        JLabel titelLabel = new JLabel("Instructies", SwingConstants.CENTER);
        titelLabel.setFont(FontOpenSans.create(48));
        titelLabel.setForeground(QuartoColor.WHITE);

        // Defineren Instructie tekst
        JLabel instructieTekst = new JLabel();
        instructieTekst.setForeground(QuartoColor.WHITE);

        final int side_margin = 1024 / 6;
        setBorder(new EmptyBorder(0, side_margin, 55, side_margin));

        // Vullen instructie tekst
        StringBuilder sb = new StringBuilder();
        sb.append("<HTML>");
        sb.append("Quarto is een bordspel dat bestaat uit 16 stukken met elk een unieke combinatie van 4 eigenschappen:<br>");
        sb.append("<br>");
        sb.append("- Hoog of laag<br>");
        sb.append("- Vol of hol<br>");
        sb.append("- Licht of donker<br>");
        sb.append("- Rond of vierkant<br>");
        sb.append("<br>");
        sb.append("Aan het begin van elke beurt kan de speler een spelstuk plaatsen op het bord, en vervolgens een spelstuk uitkiezen uitkiezen" +
                " die de tegenstander tijdens zijn beurt moet plaatsen. Spelstukken die op het bord geplaatst zijn behoren niet tot een" +
                " bepaalde speler en zijn dus neutraal<br>");
        sb.append("<br><br>");
        sb.append("Doel:<br>");
        sb.append("<br>");
        sb.append("Het doel van Quarto is, is om 4 op een rij te creëren op het bord met stukken die 1 eigenschap delen, voorbeeld hiervan is 4 lichte spelstukken" +
                " of 4 ronde spelstukken.");
        sb.append("Op het moment dat een spelstuk geplaatst is en de speler ziet een rij met gelijke eigenschappen, mag de huidige speler Quarto roepen. " +
                "Door deze roep te doen, is het mogelijk dat de speler de beurt wint. Als de speler de Quarto niet ziet, kan de tegenstander dit alsnog afroepen, " +
                "voordat deze zijn gegeven spelstuk plaatst. Mochten beide spelers de Quarto niet zien binnen 1 beurt, zal de Quarto als ongeldig gerekend worden" +
                " en is deze niet meer geldig. Mocht een speler onterecht Quarto roepen, zal diens beurt eindigen en is de volgende speler aan zet.<br>");
        sb.append("Het spel eindigt in gelijkspel als beide spelers geen Quarto afroepen nadat alle spelstukken geplaatst zijn.<br>");
        sb.append("</HTML>");
        instructieTekst.setText(sb.toString());

        // Knop aanmaken en invullen
        JButton okKnop = new MenuButton("OK, Terug naar menu");
        okKnop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuartoApplication.currentApplication().popForm();
            }
        });
        okKnop.setSize(20,20);
        okKnop.setBorder(new EmptyBorder(0,0,0,0));

        // Toevoegen Labels
        add(titelLabel, BorderLayout.NORTH);
        add(instructieTekst, BorderLayout.CENTER);
        add(okKnop, BorderLayout.SOUTH);
    }
}