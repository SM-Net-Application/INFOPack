package com.smnet.core.app;

import com.smnet.core.config.INIReader;

import java.util.HashMap;

public class AppSettings {

    private INIReader ini;
    private HashMap<Object, Object> data;
    private AppSettingsLoadable appSettingsLoader;

    public AppSettings(INIReader ini, AppSettingsLoadable appSettingsLoader) {

        this.ini = ini;
        this.data = new HashMap<>();
        this.appSettingsLoader = appSettingsLoader;
    }

    public boolean settingsFileExists() {
        return this.ini.getFileINI().exists();
    }

    public void load() {
        this.appSettingsLoader.load(this);
    }

    public INIReader getIni() {
        return ini;
    }

    public void setIni(INIReader ini) {
        this.ini = ini;
    }

    public HashMap<Object, Object> getData() {
        return data;
    }

    public void setData(HashMap<Object, Object> data) {
        this.data = data;
    }
}
