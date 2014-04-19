package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.task.LaadSpel;
import ipsen1.quarto.task.LeesInstructies;
import ipsen1.quarto.task.OpslaanSpel;
import ipsen1.quarto.task.SluitSpelAf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGameMenu extends Form {
    public InGameMenu() {
        super();

        setPreferredSize(new Dimension(1024, 768));

        setLayout(new GridLayout(7, 1));
        JLabel pauseLabel = new JLabel("Gepauzeerd", SwingConstants.CENTER);
        pauseLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
        add(pauseLabel);
        addButtons();
    }

    private JButton
            resumeButton = new JButton("Spel hervatten"),
            savebutton = new JButton("Spel opslaan"),
            loadButton = new JButton("Spel laden"),
            instructionsButton = new JButton("Instructies"),
            mainMenuButton = new JButton("Hoofdmenu"),
            exitButton = new JButton("Afsluiten");

    private void addButtons() {
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pop the in-game menu
                QuartoApplication.currentApplication().popForm();
            }
        });

        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OpslaanSpel().run();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LaadSpel().run();
            }
        });

        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LeesInstructies().run();
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pop the in-game menu and the form underneath it
                QuartoApplication.currentApplication().popForm();
                QuartoApplication.currentApplication().popForm();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SluitSpelAf().run();
            }
        });

        add(resumeButton);
        add(savebutton);
        add(loadButton);
        add(instructionsButton);
        add(mainMenuButton);
        add(exitButton);
    }
}
