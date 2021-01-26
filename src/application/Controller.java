package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button newTypologyBtn;

    @FXML
    private TextField date;
    
    @FXML
    private ChoiceBox<?> typology;

    @FXML
    private ChoiceBox<?> subType;

    @FXML
    private ChoiceBox<?> subSubType;

    @FXML
    private ComboBox<String> frequency;

    @FXML
    private ComboBox<?> severity;

    @FXML
    private ComboBox<?> nonDetectability;

    @FXML
    private TextArea comment;

    @FXML
    private ListView<?> documentsListView;

    @FXML
    private Button deleteFileBtn;

    @FXML
    private Button fileChooser;

    @FXML
    private TableView<?> actionTableQR;

    @FXML
    private TableColumn<?, ?> colVal;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colWho;

    @FXML
    private TableColumn<?, ?> colWhat;

    @FXML
    private TableView<?> actionTableQC;

    @FXML
    private TableColumn<?, ?> colVal2;

    @FXML
    private TableColumn<?, ?> colDate2;

    @FXML
    private TableColumn<?, ?> colWho2;

    @FXML
    private TableColumn<?, ?> colWhat2;

    @FXML
    private Button valActionBtn;

    @FXML
    private Button addActionBtn;

    @FXML
    private Button deleteIncidentBtn;

    @FXML
    private Label errorLabel;
    
    private String[] frequencyValues = { "X1", "X2", "X3", "X10", "X20" }; 
    
    @FXML
    public void initialize() {
        frequency.setItems(FXCollections.observableArrayList(frequencyValues));
    }

}

