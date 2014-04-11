package ipsen1.quarto.form;

import ipsen1.quarto.task.*;
import ipsen1.quarto.util.TaskListener;

import javax.swing.*;
import java.awt.*;

public class Hoofdmenu extends Form {
    private final String title = "Quarto!";
    private final int width = 800,
                      height = 600;
    private final int margin = 32;

    public Hoofdmenu() {
        super();
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout(margin, margin));

        add(createTitleLabel(), BorderLayout.NORTH);
        add(createButtonsPanel(), BorderLayout.WEST);
    }

    private JLabel createTitleLabel() {
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(width, height / 6));
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));

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
        buttonsPanel.setLayout(new GridLayout(5, 1, margin, margin));

        for(int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            TaskListener listener = listeners[i];

            button.addActionListener(listener);
            buttonsPanel.add(button);
        }

        buttonsPanel.setPreferredSize(new Dimension(width / 4, height));

        return buttonsPanel;
    }
}
