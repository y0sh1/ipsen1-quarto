package ipsen1.quarto.form;

import ipsen1.quarto.QuartoApplication;
import ipsen1.quarto.form.menu.MenuButton;
import ipsen1.quarto.form.pionnen.PionButton;
import ipsen1.quarto.task.LaadSpel;
import ipsen1.quarto.task.LeesInstructies;
import ipsen1.quarto.task.OpslaanSpel;
import ipsen1.quarto.task.SluitSpelAf;
import ipsen1.quarto.util.FontOpenSans;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGameMenu extends Form {
    private static final String BACKGROUND_FILENAME = "src/main/resources/hout_achtergrond.jpg";
    private static Image background = new ImageIcon(BACKGROUND_FILENAME).getImage();

    public InGameMenu() {
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new BorderLayout());

        JLabel pauseLabel = new JLabel("Gepauzeerd", SwingConstants.CENTER);
        pauseLabel.setFont(FontOpenSans.create(48));
        pauseLabel.setForeground(Color.WHITE);
        add(pauseLabel, BorderLayout.NORTH);
        addButtons();
    }

    private JButton
            resumeButton = new MenuButton("Spel hervatten", MenuButton.INGAME_MENU_DIMENSION),
            savebutton = new MenuButton("Spel opslaan", MenuButton.INGAME_MENU_DIMENSION),
            loadButton = new MenuButton("Spel laden", MenuButton.INGAME_MENU_DIMENSION),
            instructionsButton = new MenuButton("Instructies", MenuButton.INGAME_MENU_DIMENSION),
            mainMenuButton = new MenuButton("Hoofdmenu", MenuButton.INGAME_MENU_DIMENSION),
            exitButton = new MenuButton("Afsluiten", MenuButton.INGAME_MENU_DIMENSION);

    private void addButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 0, 32));
        final int side_margin = (int) getPreferredSize().getWidth() / 3;
        buttonPanel.setBorder(new EmptyBorder(0, side_margin, 0, side_margin));
        buttonPanel.setOpaque(false);

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
                // Pop the in-game menu, the board and the player choice form underneath it
                QuartoApplication.currentApplication().popForm();
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

        buttonPanel.add(resumeButton);
        buttonPanel.add(savebutton);
        buttonPanel.add(loadButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
