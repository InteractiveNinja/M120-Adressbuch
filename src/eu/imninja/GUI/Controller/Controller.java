package eu.imninja.GUI.Controller;

import eu.imninja.GUI.Messages.TextsMessages;
import eu.imninja.GUI.Model.Model;
import eu.imninja.GUI.POJO.Adresse;
import eu.imninja.GUI.View.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Controller implements TextsMessages {

    private ListView listView;
    private AddView addView;
    private DetailView detailView;
    private Model model;

    private ArrayList<GUI> views = new ArrayList<>(Arrays.asList(listView,addView,detailView));

    public Controller() {
        this.model = new Model();
        showListView();
    }

    public void showListView() {

        hideAll();
        listView = new ListView(LISTETITLE,this,model.getList());
    }

    public void showDetailView(Adresse adresse) {
        hideAll();
        detailView = new DetailView(DETAILTITLE,this,adresse);
    }
    public void showAddView() {
        hideAll();
        addView = new AddView(ADDTITLE,this);
    }

    public Optional<Adresse> findAdressById(int index) {
        return model.findAdressByIndex(index);
    }



    public void removeContact(int index){
        if(!model.removeFromList(index)) new ErrorGUI(DEFAULTERROR);
    }

    public void addContact(Adresse adresse) {
        model.addToList(adresse);
    }




    private void hideAll() {

        if(detailView != null) detailView.dispose();
        if(addView != null) addView.dispose();
        if(listView!= null) listView.dispose();

    }


}
