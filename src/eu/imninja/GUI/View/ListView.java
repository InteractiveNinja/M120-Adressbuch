package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListView extends GUI {

    private Controller controller;
    private JList<String> list = new JList<>();
    private JScrollPane scrollPane = new JScrollPane();

    public ListView(String title, Controller controller,Point location) throws HeadlessException {
        super(title,location);
        this.controller = controller;
        setElements();
        loadModel();
    }

    private void setElements() {
        //Root Background
        setLayout(new BorderLayout());

        //Titel des Programmes
        Label title = new Label("Adressliste");
        title.setAlignment(Label.CENTER);
        scrollPane.setViewportView(list);
        add(title,BorderLayout.NORTH);

        //Liste wird hinzugefügt
        add(scrollPane,BorderLayout.CENTER);

        //Buttons werden hinzugefügt
        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton addButton = new JButton("Hinzufügen");
        JButton removeButton = new JButton("Löschen");

        addButton.addActionListener((e) ->{

            controller.showAddView();
        });

        removeButton.addActionListener((e) ->{
            if(list.getSelectedIndex() > -1) {
                controller.removeAddress(list.getSelectedIndex());
                loadModel();

            }
        });

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() >= 2) {
                    controller.showDetailView(controller.getAddressByIndex(list.getSelectedIndex()));
                }
            }
        });

        buttons.add(addButton);
        buttons.add(removeButton);
        add(buttons,BorderLayout.SOUTH);
        setVisible(true);
    }
    private void loadModel() {
        list.setModel(controller.getListModel());
    }

}
