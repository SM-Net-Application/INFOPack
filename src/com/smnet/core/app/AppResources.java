package com.smnet.core.app;

import com.smnet.core.config.PropertiesReader;
import com.smnet.core.css.Styler;
import com.smnet.core.dialog.AlertBuilder;

import java.io.File;

public class AppResources {

    private final String appName;
    private final String appVersion;
    private final String appDeveloper;

    private AlertBuilder alertBuilder;
    private Styler styler;

    private AppSettings appSettings;
    private PropertiesReader language;

    public AppResources(String appName, String appVersion, String appDeveloper, File css, File icon, boolean showDev) {

        this.appName = appName;
        this.appVersion = appVersion;
        this.appDeveloper = appDeveloper;

        this.styler = new Styler(this.fullTitle(true), css, icon);

        this.alertBuilder = new AlertBuilder(this.fullTitle(showDev));
        this.alertBuilder.setCSS(css, "alert_001");
        this.alertBuilder.setIcon(icon);
    }

    public String fullTitle() {
        return this.fullTitle(false);
    }

    public String fullTitle(boolean dev) {

        return dev
                ? String.format("%s: %s %s", this.appDeveloper, this.appName, this.appVersion)
                : String.format("%s %s", this.appName, this.appVersion);
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppDeveloper() {
        return appDeveloper;
    }

    public AlertBuilder getAlertBuilder() {
        return alertBuilder;
    }

    public void setAlertBuilder(AlertBuilder alertBuilder) {
        this.alertBuilder = alertBuilder;
    }

    public Styler getStyler() {
        return styler;
    }

    public void setStyler(Styler styler) {
        this.styler = styler;
    }

    public PropertiesReader getLanguage() {
        return language;
    }

    public void setLanguage(PropertiesReader language) {
        this.language = language;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public void setAppSettings(AppSettings appSettings) {
        this.appSettings = appSettings;
    }
}
