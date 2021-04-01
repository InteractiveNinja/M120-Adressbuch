package eu.imninja.GUI.Controller;

import eu.imninja.GUI.Messages.TextsMessages;
import eu.imninja.GUI.Model.Model;
import eu.imninja.GUI.POJO.Adresse;
import eu.imninja.GUI.View.*;

import javax.swing.*;

public class Controller implements TextsMessages {

    private ListView listView;
    private AddView addView;
    private EditView editView;
    private DetailView detailView;
    private Model model;


    public Controller() {
        this.model = new Model();
        showListView();
    }

    public void showListView() {

        hideAll();
        listView = new ListView(LISTETITLE,this);
    }


    public DefaultListModel<String> getListModel() {
        return model.getListModel();
    }

    public void showDetailView(Adresse adresse) {
        hideAll();
        detailView = new DetailView(DETAILTITLE,this,adresse);
    }
    public void showAddView() {
        hideAll();
        addView = new AddView(ADDTITLE,this);
    }

    public Adresse getAdressByIndex(int index) {
        return model.getAddressByIndex(index);
    }



    public void removeAdress(int index){
        if(model.removeAddressByIndex(index)) new ErrorGUI(DEFAULTERROR);
    }

    public void addContact(Adresse adresse) {
        if(model.addToList(adresse)) new ErrorGUI(DEFAULTERROR);
    }
    public void setAdresse(Adresse oldAdresse,Adresse newAdresse) {
        model.setAdresse(oldAdresse,newAdresse);
    }

    public void editAdress(Adresse adresse) {
        hideAll();
        editView = new EditView(EDITTITLE,this,adresse);

    }




    private void hideAll() {

        if(detailView != null) detailView.dispose();
        if(addView != null) addView.dispose();
        if(listView!= null) listView.dispose();
        if(editView != null) editView.dispose();

    }



}
