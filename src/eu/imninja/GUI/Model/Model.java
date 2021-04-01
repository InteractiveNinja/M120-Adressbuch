package eu.imninja.GUI.Model;

import eu.imninja.GUI.POJO.Addresse;

import javax.swing.*;
import java.util.ArrayList;

public class Model {

    private ArrayList<Addresse> addresses = new ArrayList<>();


    public Model() {

        //Fügt Statische Addressen hinzu
        for (int i = 1; i <= 5; i++) {
            addAdressToList(new Addresse("Hans", "Meier "  +i ));
        }
    }


    /**
     * Fügt eine Eintrag zur Addressliste hinzu
     * @param addresse
     * @return True wenn der Vorgang fehlschlägt
     */
    public boolean addAdressToList(Addresse addresse) {
        return !addresses.add(addresse);
    }

    /**
     * Holt sich die Addresse aus der Arraylist anhand des Indexes
     * @param index JList Index
     * @return Addresse
     */
    public Addresse getAddressByIndex(int index) {
        return addresses.get(index);
    }

    /**
     * Löscht eine Addresse aus dem AdressArray
     * @param index
     * @return True wenn der Eintrag nicht gelöscht worden ist
     */
    public boolean removeAddressByIndex(int index){
        return addresses.remove(index) == null;
    }


    /**
     * Verändert die Daten der Addresse die selektiert worden ist
     * @param oldAddresse
     * @param newAddresse
     */
    public void setAdresse(Addresse oldAddresse, Addresse newAddresse) {
        addresses.set(addresses.indexOf(oldAddresse), newAddresse);
    }


    /**
     * Erstellt aus dem interne Addresselisten ArrayList ein DefaultModel für die JList
     * @return
     */
    public DefaultListModel<String> getListModel() {
        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Addresse a: addresses) {
            model.addElement(a.getModelString());
        }

        return model;
    }
}
