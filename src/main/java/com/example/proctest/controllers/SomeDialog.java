package com.example.proctest.controllers;

import com.example.proctest.model.Procurement;
import com.example.proctest.repository.ProcurementRepository;
import com.example.proctest.services.Procservice;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@FxmlView
public class SomeDialog {

    private final Procservice procservice;


    @Autowired
    public SomeDialog(Procservice procservice) {
        this.procservice = procservice;
    }

    private Stage stage;

    @FXML
    private Button closeButton;
    @FXML
    private VBox dialog;
    @FXML
    private TextArea text;


    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));

    }

    public void show() {
        stage.show();
    }


    public void labelId(Procurement rowData) {
        text.setWrapText(true);
        text.setText(rowData.getName());
        System.out.println(rowData);
        System.out.println(procservice.findById(rowData.getId()).get());
        System.out.println(procservice.getById(rowData.getId()));

    }
}
