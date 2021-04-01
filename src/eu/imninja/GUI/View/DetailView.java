package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Messages.FieldNames;
import eu.imninja.GUI.POJO.Addresse;

import javax.swing.*;
import java.awt.*;

public class DetailView extends GUI implements FieldNames {

    private Controller controller;
    private Addresse addresse;
    public DetailView(String title, Controller controller, Addresse addresse,Point location) throws HeadlessException {
        super(title,location);
        this.controller = controller;
        this.addresse = addresse;
        setElements();
    }

    private void setElements(){

        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(0,2,10,10));

        form.add(new JLabel(NAMEFIELD));
        form.add(new JLabel(addresse.getVname()));
        form.add(new JLabel(NACHNAMEFIELD));
        form.add(new JLabel(addresse.getNname()));

        form.add(new JLabel(ALTERFIELD));
        form.add(new JLabel(addresse.getAlter()));

        form.add(new JLabel(STRASSEFIELD));
        form.add(new JLabel(addresse.getStrasse()));

        form.add(new JLabel(PLZFIELD));
        form.add(new JLabel(addresse.getPlz()));

        form.add(new JLabel(ORTFIELD));
        form.add(new JLabel(addresse.getOrt()));

        form.add(new JLabel(TELEFIELD));
        form.add(new JLabel(addresse.getTelefonnummer()));

        form. add(new JLabel(MOBILETELEFIELD));
        form.add(new JLabel(addresse.getMobilenummer()));

        form.add(new JLabel(EMAILFIELD));
        form.add(new JLabel(addresse.getEmail()));



        add(form,BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton changeButton = new JButton("Ändern");
        JButton backButton = new JButton("Zurück");

        changeButton.addActionListener((e) ->{
            controller.showEditAdress(addresse);
        });

        backButton.addActionListener((e) ->{
            controller.showListView();
        });

        buttons.add(changeButton);
        buttons.add(backButton);
        add(buttons,BorderLayout.SOUTH);
        setVisible(true);



    }


}
