package eu.imninja.GUI.View;

import eu.imninja.GUI.Messages.TextsMessages;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements TextsMessages {
    public GUI(String title,Point location) throws HeadlessException {
        super(title);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300,400);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("eu/imninja/Images/icon.png")).getImage());
        setVisible(false);

        if(location != null) {
            setLocation(location);
        } else {
            setLocationRelativeTo(null);
        }

    }

}
