package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

            controller.showAddView();
        });

        removeButton.addActionListener((e) ->{
            if(list.getSelectedIndex() > -1) {
                controller.removeContact(list.getSelectedIndex());

            }
        });

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() >= 2) {
                    controller.showDetailView(controller.findAdressById(list.getSelectedIndex()).get());
                }
            }
        });

        buttons.add(addButton);
        buttons.add(removeButton);
        add(buttons,BorderLayout.SOUTH);





    }

    public void fillList(DefaultListModel<String> model) {
        list.setModel(model);
    }
}
