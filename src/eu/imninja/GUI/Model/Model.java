package eu.imninja.GUI.Model;

import eu.imninja.GUI.POJO.Adresse;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Model {

    private DefaultListModel<String> list = new DefaultListModel<>();
    private ArrayList<Adresse> adresses = new ArrayList<>();


    public Model() {

        for (int i = 1; i <= 50; i++) {
            addToList(new Adresse("Hans", "Meier "  +i ));
        }
    }

    public void addToList(Adresse adresse) {
        adresses.add(adresse);
        list.addElement(adresse.getModelString());
    }

    /**
     * Löscht Eintrag mit Hilfe des Indexs aus einer Liste, Wenn Suche Fehlschlägt wird ein Fehler ausgegeben
     * @param index Listen Index
     * @return Erfolgreich?
     */
    public boolean removeFromList(int index) {

        Optional<Adresse> ad = findAdressByIndex(index);


        if(ad.isPresent()) {

            Adresse found = ad.get();

            list.remove(index);
            adresses.remove(index);

            return true;

        } else {
            return false;
        }
    }

    public void setAdresse(Adresse oldAdresse, Adresse newAdresse) {
        adresses.set(adresses.indexOf(oldAdresse),newAdresse);
        list.set(list.indexOf(oldAdresse.getModelString()),newAdresse.getModelString());
    }

    private Optional<Adresse> findAdresseByString(String search) {
        return adresses.stream().filter(adresse -> adresse.getModelString().equals(search)).findFirst();

    }

    public Optional<Adresse> findAdressByIndex(int index) {
        String search = list.get(index);

        return findAdresseByString(search);

    }

    public DefaultListModel<String> getList() {
        return list;
    }
}
