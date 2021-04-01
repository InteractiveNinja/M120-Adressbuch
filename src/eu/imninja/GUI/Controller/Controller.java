package eu.imninja.GUI.Controller;

import eu.imninja.GUI.Messages.TextsMessages;
import eu.imninja.GUI.Model.Model;
import eu.imninja.GUI.POJO.Addresse;
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

    public void showDetailView(Addresse addresse) {
        hideAll();
        detailView = new DetailView(DETAILTITLE,this, addresse);
    }
    public void showAddView() {
        hideAll();
        addView = new AddView(ADDTITLE,this);
    }

    public Addresse getAddressByIndex(int index) {
        return model.getAddressByIndex(index);
    }



    public void removeAddress(int index){
        if(model.removeAddressByIndex(index)) new ErrorGUI(DEFAULTERROR);
    }

    public void addAddress(Addresse addresse) {
        if(model.addAdressToList(addresse)) new ErrorGUI(DEFAULTERROR);
    }
    public void setAddress(Addresse oldAddresse, Addresse newAddresse) {
        model.setAdresse(oldAddresse, newAddresse);
    }

    public void editAddress(Addresse addresse) {
        hideAll();
        editView = new EditView(EDITTITLE,this, addresse);

    }




    private void hideAll() {

        if(detailView != null) detailView.dispose();
        if(addView != null) addView.dispose();
        if(listView!= null) listView.dispose();
        if(editView != null) editView.dispose();

    }



}
