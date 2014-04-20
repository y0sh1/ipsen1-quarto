package ipsen1.quarto.form;

import ipsen1.quarto.form.menu.MenuButton;
import ipsen1.quarto.task.*;
import ipsen1.quarto.util.FontOpenSans;
import ipsen1.quarto.util.TaskListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Hoofdmenu extends Form {
    private final String title = "Quarto!";
    private final int vMargin = 32,
                      hMargin = 32;

    public Hoofdmenu() {
        setLayout(new BorderLayout(hMargin, vMargin));

        add(createTitleLabel(), BorderLayout.NORTH);
        add(createButtonsPanel(), BorderLayout.WEST);
    }

    private JLabel createTitleLabel() {
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT / 6));

        Font titleFont = FontOpenSans.create(64).deriveFont(Font.BOLD);

        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);

        return titleLabel;
    }

    private final String[] buttons = new String[] {
            "Spel starten",
            "Spel laden",
            "Instructies",
            "Afsluiten"
    };
    private final TaskListener[] listeners = new TaskListener[] {
            new TaskListener(new StartNieuwSpel()),
            new TaskListener(new LaadSpel()),
            new TaskListener(new LeesInstructies()),
            new TaskListener(new SluitSpelAf())
    };

    private JPanel createButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 1, hMargin, vMargin));
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBorder(new EmptyBorder(0, hMargin * 2, 0, 0));

        for(int i = 0; i < buttons.length; i++) {
            JButton button = new MenuButton(buttons[i]);
            TaskListener listener = listeners[i];

            button.addActionListener(listener);

            buttonsPanel.add(button);
        }

        buttonsPanel.setPreferredSize(new Dimension(DEFAULT_WIDTH / 3, DEFAULT_HEIGHT));

        return buttonsPanel;
    }
}
