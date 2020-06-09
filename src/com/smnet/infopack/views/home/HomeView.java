package com.smnet.infopack.views.home;

import com.smnet.core.app.AppResources;
import com.smnet.core.app.AppSettings;
import com.smnet.core.app.AppSettingsLoadable;
import com.smnet.core.config.INIReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HomeView implements AppSettingsLoadable {

    @FXML
    private BorderPane borderPane;

    private AppResources appResources;
    private Stage ownerStage;

    public void init(AppResources appResources, Stage stage) {

        this.appResources = appResources;
        this.ownerStage = stage;

        this.appResources.getStyler().initStyle("main_color_001", this.borderPane);

        headerView();

        if (this.appResources.getAppSettings().settingsFileExists())
            accessView();
        else
            createAccessView();

        // Stage show

        stage.show();
    }

    private void createAccessView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeCreateAccessView.class.getResource("HomeCreateAccessView.fxml"));
            this.borderPane.setCenter(fxmlLoader.load());

            HomeCreateAccessView controller = fxmlLoader.getController();
            controller.setOwnerStage(this.ownerStage);
            controller.init(this.appResources);

        } catch (IOException e) {
            this.appResources.getAlertBuilder().error(this.ownerStage, e.getMessage());
        }
    }

    private void accessView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeAccessView.class.getResource("HomeAccessView.fxml"));
            this.borderPane.setCenter(fxmlLoader.load());

            HomeAccessView controller = fxmlLoader.getController();
            controller.init(this.appResources);

        } catch (IOException e) {
            this.appResources.getAlertBuilder().error(this.ownerStage, e.getMessage());
        }
    }

    private void headerView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeHeaderView.class.getResource("HomeHeaderView.fxml"));
            this.borderPane.setTop(fxmlLoader.load());

            HomeHeaderView controller = fxmlLoader.getController();
            controller.init(this.appResources);

        } catch (IOException e) {
            this.appResources.getAlertBuilder().error(this.ownerStage, e.getMessage());
        }
    }

    private void menuView() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HomeMenuTreeView.class.getResource("HomeMenuTreeView.fxml"));
            this.borderPane.setLeft(fxmlLoader.load());

            HomeMenuTreeView controller = fxmlLoader.getController();
            controller.init(this.appResources);

        } catch (IOException e) {
            this.appResources.getAlertBuilder().error(this.ownerStage, e.getMessage());
        }
    }

    @Override
    public void load(AppSettings appSettings) {

        INIReader ini = appSettings.getIni();
        HashMap<Object, Object> data = appSettings.getData();

        // Load Settings to HashMap

//        if (ini.isCreated()) {

        // Default Settings

//        data.put("applicationKey", null);
//        data.put("mysqlDatabaseKey", null);
//        data.put("mysqlHost", "");
//        data.put("mysqlDatabase", "");
//        data.put("mysqlUsername", "");
//        data.put("mysqlPassword", "");

//        } else {

        // Load Settings

//        }
    }
}
