package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Messages.FieldNames;
import eu.imninja.GUI.POJO.Addresse;

import javax.swing.*;
import java.awt.*;

public class EditView extends GUI implements FieldNames {

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
    private Addresse addresse;
    public EditView(String title, Controller controller, Addresse addresse,Point location) throws HeadlessException {
        super(title,location);
        this.controller = controller;
        this.addresse = addresse;
        setElements();
    }

    private void setElements(){
        setLayout(new BorderLayout(10,10));
        JPanel form = new JPanel(new GridLayout(0,2,10,10));

        form.add(new JLabel(NAMEFIELD));
        vname.setText(addresse.getVname());
        form.add(vname);
        form.add(new JLabel(NACHNAMEFIELD));
        name.setText(addresse.getNname());

        form.add(name);
        form.add(new JLabel(ALTERFIELD));
        alter.setText(addresse.getAlter());

        form.add(alter);
        form.add(new JLabel(STRASSEFIELD));
        strasse.setText(addresse.getStrasse());

        form.add(strasse);
        form.add(new JLabel(PLZFIELD));
        plz.setText(addresse.getPlz());

        form.add(plz);
        form.add(new JLabel(ORTFIELD));
        ort.setText(addresse.getOrt());

        form.add(ort);
        form.add(new JLabel(TELEFIELD));
        telefon.setText(addresse.getTelefonnummer());

        form.add(telefon);
        form. add(new JLabel(MOBILETELEFIELD));
        mobile.setText(addresse.getMobilenummer());

        form.add(mobile);
        form.add(new JLabel(EMAILFIELD));
        email.setText(addresse.getEmail());

        form.add(email);


        add(form,BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(0,1));

        JButton saveButton = new JButton("Speichern");
        JButton cancelButton = new JButton("Abbrechen");

        saveButton.addActionListener((e) ->{
            controller.setAddress(addresse,checks());
            controller.showListView();
        });

        cancelButton.addActionListener((e) ->{
            controller.showListView();
        });

        buttons.add(saveButton);
        buttons.add(cancelButton);
        add(buttons,BorderLayout.SOUTH);

        setVisible(true);


    }

    private Addresse checks() {
        return new Addresse(vname.getText(),name.getText(),alter.getText(),strasse.getText(),plz.getText(),ort.getText(),telefon.getText(),mobile.getText(),email.getText());
    }
}
