package eu.imninja.GUI.Controller;

import eu.imninja.GUI.Messages.TextsMessages;
import eu.imninja.GUI.Model.Model;
import eu.imninja.GUI.POJO.Addresse;
import eu.imninja.GUI.View.*;

import javax.swing.*;
import java.awt.*;

public class Controller implements TextsMessages {

    private ListView listView;
    private AddView addView;
    private EditView editView;
    private DetailView detailView;
    private Model model;
    private Point location;

    public Controller() {
        this.model = new Model();
        showListView();
    }

    public void showListView() {

        hideAll();
        listView = new ListView(LISTETITLE,this,location);
    }


    public DefaultListModel<String> getListModel() {
        return model.getListModel();
    }

    public void showDetailView(Addresse addresse) {
        hideAll();
        detailView = new DetailView(DETAILTITLE,this, addresse,location);
    }
    public void showAddView() {
        hideAll();
        addView = new AddView(ADDTITLE,this,location);
    }
    public void showEditAdress(Addresse addresse) {
        hideAll();
        editView = new EditView(EDITTITLE,this, addresse,location);

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






    private void hideAll() {

        if(detailView != null) {
            location = detailView.getLocation();
            detailView.dispose();

        }
        if(addView != null){
            location = addView.getLocation();

            addView.dispose();
        }
        if(listView!= null) {
            location = listView.getLocation();

            listView.dispose();
        }
        if(editView != null){
            location = editView.getLocation();
            editView.dispose();
        }

    }



}
