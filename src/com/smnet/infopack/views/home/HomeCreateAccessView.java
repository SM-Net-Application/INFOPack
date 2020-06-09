package com.smnet.infopack.views.home;

import com.smnet.core.app.AppResources;
import com.smnet.core.utils.PasswordUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class HomeCreateAccessView {

    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField password;
    @FXML
    private Label passwordRepeatLabel;
    @FXML
    private PasswordField passwordRepeat;
    @FXML
    private Button create;

    private AppResources appResources;
    private Stage ownerStage;

    public void init(AppResources appResources) {

        this.appResources = appResources;

        this.appResources.getStyler().initStyle("label_set_001", this.passwordLabel, this.passwordRepeatLabel);
        this.appResources.getStyler().initStyle("text_field_set_001", this.password, this.passwordRepeat);
        this.appResources.getStyler().initStyle("button_image_001", this.create);

        this.passwordLabel.setText(this.appResources.getLanguage().getString("home.create.access.password.label"));
        this.passwordRepeatLabel.setText(this.appResources.getLanguage().getString("home.create.access.password.repeat.label"));

        String label = this.appResources.getLanguage().getString("home.create.access.password.button");
        this.appResources.getStyler().initButtonImage(this.create, label);
        this.create.setDefaultButton(true);

        // Listeners

        this.create.setOnAction(event -> checkPassword());
    }

    private void checkPassword() {

        if (valid()) {

        }
    }

    private boolean valid() {

        String password = this.password.getText();
        String passwordRepeat = this.passwordRepeat.getText();
        String error = this.appResources.getLanguage().getString("password.error.equals");

        if (password.equals(passwordRepeat))
            switch (PasswordUtils.isStrong(password)) {
                case NO_UPPERCASE:
                    error = this.appResources.getLanguage().getString("password.error.uppercase");
                    break;
                case NO_LOWERCASE:
                    error = this.appResources.getLanguage().getString("password.error.lowercase");
                    break;
                case NO_SPECIAL:
                    error = this.appResources.getLanguage().getString("password.error.special");
                    break;
                case NO_DIGIT:
                    error = this.appResources.getLanguage().getString("password.error.digit");
                    break;
                case NO_LENGTH:
                    error = this.appResources.getLanguage().getString("password.error.lenght");
                    break;
                case SPACES:
                    error = this.appResources.getLanguage().getString("password.error.spaces");
                    break;
                case UMLAUTS:
                    error = this.appResources.getLanguage().getString("password.error.umlauts");
                    break;
                case STRONG:
                    return true;
            }

        this.appResources.getAlertBuilder().error(this.ownerStage, error);

        return false;
    }

    public Stage getOwnerStage() {
        return ownerStage;
    }

    public void setOwnerStage(Stage ownerStage) {
        this.ownerStage = ownerStage;
    }
}