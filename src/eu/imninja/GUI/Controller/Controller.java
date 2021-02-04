package eu.imninja.GUI.Controller;

import eu.imninja.GUI.Messages.TextsMessages;
import eu.imninja.GUI.Model.Model;
import eu.imninja.GUI.POJO.Adresse;
import eu.imninja.GUI.View.AddView;
import eu.imninja.GUI.View.ErrorGUI;
import eu.imninja.GUI.View.ListView;

public class Controller implements TextsMessages {

    private ListView listView;
    private AddView addView;
    private Model model;

    public Controller() {
        this.model = new Model();
        this.listView = new ListView(LISTETITLE,this);
        this.addView = new AddView(ADDTITLE,this);
        showListView();
    }

    public void showListView() {

        hideAll();
        listView.setShown(true);
        listView.fillList(model.getList());
    }

    public void removeContact(int index){
        if(!model.removeFromList(index)) new ErrorGUI(DEFAULTERROR);
    }

    public void addContact(Adresse adresse) {
        model.addToList(adresse);
    }


    public void showAddView() {
        hideAll();
        addView.setShown(true);
    }

    private void hideAll() {
        listView.setShown(false);
        addView.setShown(false);
    }


}
