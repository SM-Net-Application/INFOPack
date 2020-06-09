package com.smnet.core.css;

import javafx.css.Styleable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Styler {

    private String appTitle;
    private File css;
    private File icon;

    public Styler(String appTitle, File css, File icon) {

        this.appTitle = appTitle;

        if (css != null)
            if (css.exists())
                this.css = css;

        if (icon != null)
            if (icon.exists())
                this.icon = icon;
    }

    public void css(Scene scene) throws MalformedURLException {

        if (this.css != null)
            if (this.css.exists())
                scene.getStylesheets().add(this.css.toURI().toURL().toString());
    }

    public void initStyle(String className, Styleable... styleables) {

        for (Styleable styleable : styleables)
            styleable.getStyleClass().add(className);
    }

    public void initStage(Stage stage, Scene scene) {

        if (stage != null) {

            if (this.appTitle != null)
                stage.setTitle(this.appTitle);

            if (this.icon != null)
                if (this.icon.exists())
                    stage.getIcons().add(new Image(this.icon.toURI().toString(), 50, 50, true, true));

            if (scene != null)
                stage.setScene(scene);
        }
    }

    public void initScene(Scene scene) throws MalformedURLException {

        if (scene != null)
            if (this.css != null)
                if (this.css.exists())
                    scene.getStylesheets().add(this.css.toURI().toURL().toString());
    }

    public Image initImage(File fileImage) {

        if (fileImage != null)
            if (fileImage.exists())
                return new Image(fileImage.toURI().toString());

        return null;
    }

    public Image initImage(File fileImage, double width, double height, boolean preservRatio, boolean smooth) {

        if (fileImage != null)
            if (fileImage.exists())
                return new Image(fileImage.toURI().toString(), width, height, preservRatio, smooth);

        return null;
    }

    public void initButtonImage(Button button, String label, File file, int width, int height, boolean preservRatio, boolean smooth) {

        Image image = this.initImage(file, width, height, preservRatio, smooth);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setImage(image);

        button.setText(label);
        button.setGraphic(imageView);
    }

    public void initButtonImage(Button button, String label) {

        button.setText(label);
        button.setGraphic(null);
    }
}
