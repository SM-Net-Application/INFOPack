package com.smnet.infopack.views.home;

import com.smnet.core.app.AppResources;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class HomeHeaderView {

    @FXML
    private ImageView logo;

    private AppResources appResources;

    public void init(AppResources appResources) {

        this.appResources = appResources;

        File logoFile = new File(new File("resources", "images"), "logo.png");
        Image image = this.appResources.getStyler().initImage(logoFile);
        if (image != null)
            this.logo.setImage(image);
    }
}