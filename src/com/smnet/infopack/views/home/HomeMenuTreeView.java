package com.smnet.infopack.views.home;

import com.smnet.core.app.AppResources;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;

import java.io.File;

public class HomeMenuTreeView {

    @FXML
    private TreeView<String> menu;
    @FXML
    private Label label;
    @FXML
    private Button add;
    @FXML
    private Button addChild;
    @FXML
    private Button edit;

    private AppResources appResources;

    public void init(AppResources appResources) {

        this.appResources = appResources;

        this.appResources.getStyler().initStyle("tree_view_001", this.menu);
        this.appResources.getStyler().initStyle("label_header_001", this.label);
        this.appResources.getStyler().initStyle("button_image_001", this.add, this.addChild, this.edit);

        this.label.setText(this.appResources.getLanguage().getString("home.menu.label"));

        File file = new File(new File("resources", "images"), "add.png");
        this.appResources.getStyler().initButtonImage(this.add, "", file, 25, 25, false, true);

        file = new File(new File("resources", "images"), "add.png");
        this.appResources.getStyler().initButtonImage(this.addChild, "", file, 25, 25, false, true);

        file = new File(new File("resources", "images"), "edit.png");
        this.appResources.getStyler().initButtonImage(this.edit, "", file, 25, 25, false, true);

        // Listeners

        this.listener();

        // TODO : build tree
    }

    private void listener() {

        this.menu.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue)
                -> change(newValue.intValue())));
    }

    private void change(Integer newValue) {

        if (newValue > -1) {

//            switch (this.menu.getSelectionModel().getSelectedItem()) {
//                case "":
//                    break;
//            }
        }
    }

}