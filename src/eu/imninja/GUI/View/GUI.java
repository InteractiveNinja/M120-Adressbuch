package eu.imninja.GUI.View;

import eu.imninja.GUI.Messages.TextsMessages;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements TextsMessages {
    public GUI(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,400);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("eu/imninja/Images/icon.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(false);
    }

}
