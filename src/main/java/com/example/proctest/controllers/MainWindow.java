package com.example.proctest.controllers;

import com.example.proctest.model.Procurement;
import com.example.proctest.repository.ProcurementRepository;
import com.example.proctest.services.Procservice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

@Component
@FxmlView
public class MainWindow {


private Procservice procservice;
    private final FxControllerAndView<SomeDialog, VBox> someDialog;

    @FXML
    public TableView table;


    @Autowired
    public MainWindow(FxControllerAndView<SomeDialog, VBox> someDialog, Procservice procservice) {
        this.someDialog = someDialog;
        this.procservice = procservice;

    }

    @FXML
    public void initialize() {
        ObservableList<Procurement> data = FXCollections.observableArrayList(procservice.findAll());
        Field[] fields = Procurement.class.getDeclaredFields();
        for (Field field : fields) {
            TableColumn tableColumn = new TableColumn<>(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory(field.getName()));
            table.getColumns().add(tableColumn);
        }
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.setItems(data);

        table.setRowFactory(tv -> {
            TableRow<Procurement> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Procurement rowData = row.getItem();
                    someDialog.getController().labelId(rowData);
                    someDialog.getController().show();
                }
            });
            return row;
        });

    }

}
