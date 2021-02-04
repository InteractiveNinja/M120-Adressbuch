package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Messages.FieldNames;
import eu.imninja.GUI.POJO.Adresse;

import javax.swing.*;
import java.awt.*;

public class AddView extends GUI implements FieldNames {

    private JTextField vname = new JTextField();
    private JTextField name = new JTextField();
    private JTextField alter = new JTextField();
    private JTextField strasse = new JTextField();
    private JTextField plz = new JTextField();
    private JTextField ort = new JTextField();
    private JTextField telefon = new JTextField();
    private JTextField mobile = new JTextField();
    private JTextField email = new JTextField();

    private Controller controller;
    public AddView(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
        setElements();
    }

    private void setElements(){
        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(0,2,10,10));

        form.add(new JLabel(NAMEFIELD));
        form.add(vname);
        form.add(new JLabel(NACHNAMEFIELD));
        form.add(name);
        form.add(new JLabel(ALTERFIELD));
        form.add(alter);
        form.add(new JLabel(STRASSEFIELD));
        form.add(strasse);
        form.add(new JLabel(PLZFIELD));
        form.add(plz);
        form.add(new JLabel(ORTFIELD));
        form.add(ort);
        form.add(new JLabel(TELEFIELD));
        form.add(telefon);
        form. add(new JLabel(MOBILETELEFIELD));
        form.add(mobile);
        form.add(new JLabel(EMAILFIELD));
        form.add(email);


        add(form,BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton saveButton = new JButton("Speichern");
        JButton cancelButton = new JButton("Abbrechen");

        saveButton.addActionListener((e) ->{
            controller.addContact(checks());
            controller.showListView();
        });

        cancelButton.addActionListener((e) ->{
            controller.showListView();
        });

        buttons.add(saveButton);
        buttons.add(cancelButton);
        add(buttons,BorderLayout.SOUTH);



    }

    private Adresse checks() {
        return new Adresse(vname.getText(),name.getText(),alter.getText(),strasse.getText(),plz.getText(),ort.getText(),telefon.getText(),mobile.getText(),email.getText());
    }
}
