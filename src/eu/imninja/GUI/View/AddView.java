package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;
import eu.imninja.GUI.Messages.FieldNames;
import eu.imninja.GUI.Messages.SpecialNames;
import eu.imninja.GUI.POJO.Addresse;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class AddView  extends GUI implements FieldNames, SpecialNames {

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
    public AddView(String title, Controller controller,Point location) throws HeadlessException {
        super(title,location);
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
            controller.addAddress(checks());
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

    private Addresse checks()  {
        boolean isAName = Arrays.stream(specialNames).anyMatch((e) -> e.equalsIgnoreCase(vname.getText()));
        if(isAName) {
            try {
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstleyVEVO"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }


        return new Addresse(vname.getText(),name.getText(),alter.getText(),strasse.getText(),plz.getText(),ort.getText(),telefon.getText(),mobile.getText(),email.getText());
    }
}
