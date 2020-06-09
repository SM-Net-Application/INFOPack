package com.smnet.infopack.views.home;

import com.smnet.core.app.AppResources;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class HomeAccessView {

    @FXML
    private Label label;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;

    private AppResources appResources;

    public void init(AppResources appResources) {

        this.appResources = appResources;

        this.appResources.getStyler().initStyle("label_set_001", this.label);
        this.appResources.getStyler().initStyle("text_field_set_001", this.password);
        this.appResources.getStyler().initStyle("button_image_001", this.login);

        this.label.setText(this.appResources.getLanguage().getString("home.access.password.label"));

        String label = this.appResources.getLanguage().getString("home.access.login.button");
        this.appResources.getStyler().initButtonImage(this.login, label);
        this.login.setDefaultButton(true);

        // Listeners
    }
}