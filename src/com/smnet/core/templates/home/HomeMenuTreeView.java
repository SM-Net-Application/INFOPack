package com.smnet.core.templates.home;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;

public class HomeMenuTreeView {

    @FXML
    private TreeView<String> menu;
    @FXML
    private Label label;

    @FXML
    public void initialize() {

        this.menu.getStyleClass().add("list_view_001");
        this.label.getStyleClass().add("label_header_001");

        this.listener();
    }

    public void init() {

        // TODO
        this.label.setText("Menu");

        // TODO : build menu
    }

    private void listener() {
        this.menu.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) -> change(newValue.intValue())));
    }

    private void change(Integer newValue) {

        if (newValue > -1) {

//            switch (this.menu.getSelectionModel().getSelectedItem()) {
//                case "":
//                    // TODO : show menu 1
//                    break;
//            }
        }
    }

}