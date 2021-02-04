package eu.imninja.GUI.View;

import eu.imninja.GUI.Controller.Controller;

import java.awt.*;

public class AddView extends GUI {

    private Controller controller;
    public AddView(String title, Controller controller) throws HeadlessException {
        super(title);
        this.controller = controller;
    }
}
