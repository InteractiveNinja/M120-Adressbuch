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
        setupListView();
    }

    private void setupListView() {

        model.addToList(new Adresse("Hans","Meier"));
        model.addToList(new Adresse("Hanfwes","Meier"));
        model.addToList(new Adresse("Hanfewfs","Meier"));

        listView.setShown(true);
        listView.fillList(model.getList());
    }

    public void removeContact(int index){
        if(!model.removeFromList(index)) new ErrorGUI(DEFAULTERROR);
    }



    public void addContacts() {
        listView.setShown(false);
        addView.setShown(true);
    }


}
