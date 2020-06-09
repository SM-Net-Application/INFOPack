package com.smnet.infopack;

import com.smnet.core.app.AppResources;
import com.smnet.core.app.AppSettings;
import com.smnet.core.config.INIReader;
import com.smnet.core.config.PropertiesReader;
import com.smnet.infopack.views.home.HomeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class INFOPack extends Application {

    private AppResources appResources;

    public INFOPack() {

        File css = new File(new File("resources", "css"), "dark.css");
        File icon = new File(new File("resources", "images"), "icon.png");

        this.appResources = new AppResources("INFOPack", "0.1.0", "SM-Net", css, icon, false);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Languages 2

        File lang = new File(new File("resources", "languages"), "it.properties");
        this.appResources.setLanguage(new PropertiesReader(lang, "- empty -"));

        // Main-View

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(HomeView.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        this.appResources.getStyler().initScene(scene);
        this.appResources.getStyler().initStage(primaryStage, scene);

        primaryStage.setMinWidth(1024);
        primaryStage.setMinHeight(768);

        HomeView controller = fxmlLoader.getController();

        // Settings

        File ini = new File(new File("resources", "config"), "settings.ini");
        this.appResources.setAppSettings(new AppSettings(new INIReader(ini), controller));

        controller.init(this.appResources, primaryStage);
    }

    public AppResources getAppResources() {
        return appResources;
    }

    public void setAppResources(AppResources appResources) {
        this.appResources = appResources;
    }
}
