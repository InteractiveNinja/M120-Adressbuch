package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Model.Model;

import javax.swing.*;
import java.awt.*;

public class ListView extends GUI {

    private Controller controller;
    private JList<String> list = new JList<>();

    public ListView(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
        setElements();
    }

    private void setElements() {
        //Root Background
        setLayout(new BorderLayout());

        //Titel des Programmes
        Label title = new Label("Adressliste");
        title.setAlignment(Label.CENTER);
        add(title,BorderLayout.NORTH);

        //Liste wird hinzugefügt
        add(list,BorderLayout.CENTER);

        //Buttons werden hinzugefügt
        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton addButton = new JButton("Hinzufügen");
        JButton removeButton = new JButton("Löschen");

        addButton.addActionListener((e) ->{
            controller.addContacts();
        });

        removeButton.addActionListener((e) ->{
            controller.removeContact(list.getSelectedIndex());
        });

        buttons.add(addButton);
        buttons.add(removeButton);
        add(buttons,BorderLayout.SOUTH);





    }

    public void fillList(DefaultListModel<String> model) {
        list.setModel(model);
    }
}
