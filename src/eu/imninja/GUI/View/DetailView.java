package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Messages.FieldNames;
import eu.imninja.GUI.POJO.Adresse;

import javax.swing.*;
import java.awt.*;

public class DetailView extends GUI implements FieldNames {

    private Controller controller;
    private Adresse adresse;
    public DetailView(String title, Controller controller,Adresse adresse) throws HeadlessException {
        super(title);
        this.controller = controller;
        this.adresse = adresse;
        setElements();
    }

    private void setElements(){

        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(0,2,10,10));

        form.add(new JLabel(NAMEFIELD));
        form.add(new JLabel(adresse.getVname()));
        form.add(new JLabel(NACHNAMEFIELD));
        form.add(new JLabel(adresse.getNname()));

        form.add(new JLabel(ALTERFIELD));
        form.add(new JLabel(adresse.getAlter()));

        form.add(new JLabel(STRASSEFIELD));
        form.add(new JLabel(adresse.getStrasse()));

        form.add(new JLabel(PLZFIELD));
        form.add(new JLabel(adresse.getPlz()));

        form.add(new JLabel(ORTFIELD));
        form.add(new JLabel(adresse.getOrt()));

        form.add(new JLabel(TELEFIELD));
        form.add(new JLabel(adresse.getTelefonnummer()));

        form. add(new JLabel(MOBILETELEFIELD));
        form.add(new JLabel(adresse.getMobilenummer()));

        form.add(new JLabel(EMAILFIELD));
        form.add(new JLabel(adresse.getEmail()));



        add(form,BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton saveButton = new JButton("Ändern");
        JButton cancelButton = new JButton("Zurück");

        saveButton.addActionListener((e) ->{

        });

        cancelButton.addActionListener((e) ->{
        });

        buttons.add(saveButton);
        buttons.add(cancelButton);
        add(buttons,BorderLayout.SOUTH);



    }


}
