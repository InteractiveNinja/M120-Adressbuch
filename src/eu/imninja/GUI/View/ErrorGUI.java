package eu.imninja.GUI.View;

import javax.swing.*;

public class ErrorGUI extends JOptionPane {

    /**
     * Erstellt einen Neuer Fehlernachricht
     * @param msg Nachricht die Angezeigt werden muss
     */
    public ErrorGUI(String msg) {

        showMessageDialog(null,msg);
    }
}
