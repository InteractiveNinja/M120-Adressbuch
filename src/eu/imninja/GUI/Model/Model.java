package eu.imninja.GUI.Model;

import eu.imninja.GUI.POJO.Adresse;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Model {

    private ArrayList<Adresse> adresses = new ArrayList<>();


    public Model() {

        //Fügt Statische Adresse hinzu
        for (int i = 1; i <= 5; i++) {
            addToList(new Adresse("Hans", "Meier "  +i ));
        }
    }


    public boolean addToList(Adresse adresse) {
        return !adresses.add(adresse);
    }

    public Adresse getAddressByIndex(int index) {
        return adresses.get(index);
    }

    public boolean removeAddressByIndex(int index){
        return adresses.remove(index) == null;
    }


    public void setAdresse(Adresse oldAdresse, Adresse newAdresse) {
        adresses.set(adresses.indexOf(oldAdresse),newAdresse);
    }


    public DefaultListModel<String> getListModel() {
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Adresse a: adresses) {
            model.addElement(a.getModelString());
        }

        return model;
    }
}
