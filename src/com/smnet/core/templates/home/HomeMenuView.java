package com.smnet.core.templates.home;

import com.smnet.core.templates.enums.EnumMenu;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;

public class HomeMenuView {

    @FXML
    private ListView<EnumMenu> menuListView;
    @FXML
    private Label menuLabel;

    @FXML
    public void initialize() {

        this.menuListView.getStyleClass().add("list_view_001");
        this.menuLabel.getStyleClass().add("label_header_001");

        this.menuListViewCellFactory();
        this.listener();
    }

    public void init() {

        // TODO
        this.menuLabel.setText("Menu");

        // TODO : build menu
        this.menuListView.getItems().add(EnumMenu.MENU1);
    }

    private void listener() {
        this.menuListView.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) -> change(newValue.intValue())));
    }

    private void change(Integer newValue) {

        if (newValue > -1) {

            switch (this.menuListView.getSelectionModel().getSelectedItem()) {
                case MENU1:
                    // TODO : show menu 1
                    break;
            }
        }
    }

    private void menuListViewCellFactory() {

        this.menuListView.setCellFactory(param -> new ListCell<EnumMenu>() {

            @Override
            public void updateItem(EnumMenu item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {

                    ImageView imageView = new ImageView();

                    File imageFile = new File(new File("resources", "images"), item.getImageName());
                    if (imageFile != null) {

                        int width = 32;
                        int height = 32;

                        Image image = new Image(imageFile.toURI().toString(), width, height, false, true);
                        if (image != null) {
                            imageView.setFitWidth(width);
                            imageView.setFitHeight(height);
                            imageView.setImage(image);
                        }
                    }

                    StackPane sp = new StackPane();
                    StackPane.setMargin(imageView, new Insets(5, 25, 5, 5));
                    sp.getChildren().add(imageView);

                    // TODO
                    // String text = application.getLanguage().getString(item.getText());
                    String text = "";

                    setText(text);
                    setGraphic(sp);
                }
            }
        });
    }
}
