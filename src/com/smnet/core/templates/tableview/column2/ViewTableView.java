package com.smnet.core.templates.tableview.column2;

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
    public void initialize() {

    }

    private AppResources appResources;

    public void init(AppResources appResources, Stage stage) {

        this.appResources = appResources;

        this.appResources.getStyler().initStyle("table_view_001", this.table);
        this.appResources.getStyler().initStyle("table_column_001", this.column1, this.column2);
    }
}
