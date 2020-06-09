package com.smnet.core.templates.tableview.column4;

import com.smnet.core.app.AppResources;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ViewTableView {

    @FXML
    private TableView<String> table;
    @FXML
    private TableColumn<String, String> column1;
    @FXML
    private TableColumn<String, String> column2;
    @FXML
    private TableColumn<String, String> column3;
    @FXML
    private TableColumn<String, String> column4;

    private AppResources appResources;

    @FXML
    public void initialize() {

    }

    public void init(AppResources appResources, Stage stage) {

        this.appResources = appResources;

        this.appResources.getStyler().initStyle("table_view_001", this.table);
        this.appResources.getStyler().initStyle("table_column_001",
                this.column1, this.column2, this.column3, this.column4);
    }
}
