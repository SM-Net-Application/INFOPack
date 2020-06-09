package com.smnet.core.config;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class INIReader {

    private File fileINI;
    private Wini ini;

    public INIReader(File fileINI) throws IOException {
        super();

        this.fileINI = fileINI;

//        if (fileINI != null) {
//            if (!fileINI.exists())
//                this.created = fileINI.createNewFile();

        if (this.fileINI.exists())
            this.ini = new Wini(fileINI);
//        }
    }

    public void add(String section, String option, String value) {

        if (this.ini != null)
            this.ini.add(section, option, value);
    }

    public void store() throws IOException {

        if (this.ini != null)
            this.ini.store();
    }

    public Object get(String section, String option, Class<Object> clazz) {

        return this.ini != null ? this.ini.get(section, option, clazz) : null;
    }

    public Wini getIni() {
        return ini;
    }

    public void setIni(Wini ini) {
        this.ini = ini;
    }

    public File getFileINI() {
        return fileINI;
    }

    public void setFileINI(File fileINI) {
        this.fileINI = fileINI;
    }
}
