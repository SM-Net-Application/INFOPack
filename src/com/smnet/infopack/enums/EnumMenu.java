package com.smnet.infopack.enums;

public enum EnumMenu {

    MENU1("menu1.png", "menu1fromLanguageProperties");

    private String imageName;
    private String text;

    EnumMenu(String imageName, String text) {
        this.imageName = imageName;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.getText();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
