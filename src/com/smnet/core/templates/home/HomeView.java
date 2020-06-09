package com.smnet.core.templates.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeView {

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize() {

        this.borderPane.getStyleClass().add("main_color_001");
    }

    public void init() {

        headerView();
        menuView();
    }

    private void headerView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeHeaderView.class.getResource("HomeHeaderView.fxml"));

            AnchorPane ap = fxmlLoader.load();

            HomeHeaderView ctrl = fxmlLoader.getController();
            ctrl.init();

            borderPane.setTop(ap);

        } catch (IOException e) {
            // TODO
        }
    }

    private void menuView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeMenuView.class.getResource("HomeMenuView.fxml"));

            AnchorPane anchorPane = fxmlLoader.load();

            HomeMenuView ctrl = fxmlLoader.getController();
            ctrl.init();

            borderPane.setLeft(anchorPane);

        } catch (IOException e) {
            // TODO
        }
    }
}
