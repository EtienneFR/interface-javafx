package application;

import java.io.File;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Controller {

    @FXML
    private Button newTypologyBtn;

    @FXML
    private DatePicker date;
    
    @FXML
    private ChoiceBox<String> typology;

    @FXML
    private ChoiceBox<String> subType;

    @FXML
    private ChoiceBox<String> subSubType;

    @FXML
    private ComboBox<String> frequency;

    @FXML
    private ComboBox<String> severity;

    @FXML
    private ComboBox<String> nonDetectability;

    @FXML
    private TextArea comment;

    @FXML
    private ListView<String> documentsListView;

    @FXML
    private Button deleteFileBtn;

    @FXML
    private Button fileChooser;
    
    @FXML
    private Button btnViderListe;

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
    private Button btnExit;

    @FXML
    private Label errorLabel;
    
    @FXML
    void deleteFile(ActionEvent event) {
    	ObservableList<String> selectedIndices = documentsListView.getSelectionModel().getSelectedItems();
    	if(!(selectedIndices.isEmpty())) {
    		for(Object o : selectedIndices){
                documentsListView.getItems().remove(o);
            }
    	} 
    }
    
    @FXML
    void emptyListFiles(ActionEvent event) {
    	documentsListView.getItems().clear();
    }

    @FXML
    void selectFile(ActionEvent event) {
    	FileChooser filePicker = new FileChooser();
    	filePicker.setTitle("Open Resource File");
    	File f = filePicker.showOpenDialog(Window.getWindows().get(0));
    	if (f != null) {
    		documentsListView.getItems().add(f.getName());
        }
    }

    @FXML
    void Quit(ActionEvent event) {
    	Platform.exit();
    }
    
    private String[] typologyValues = { "Type 1", "Type 2", "Type 3" };
    private String[] subTypeValues = { "A1", "A2", "A3" }; 
    private String[] subSubTypeValues = { "Général", "Partiel" }; 
    
    private String[] frequencyValues = { "X1", "X2", "X3", "X10", "X20" }; 
    private String[] severityValues = { "Peu importante", "Moyenne", "Importante", "Très importante"};
    private String[] nonDetectabilityValues = { "Avant réception", "Après réception" };
    
    
    @FXML
    public void initialize() {
    	typology.setItems(FXCollections.observableArrayList(typologyValues));
    	subType.setItems(FXCollections.observableArrayList(subTypeValues));
    	subSubType.setItems(FXCollections.observableArrayList(subSubTypeValues));
    	
        frequency.setItems(FXCollections.observableArrayList(frequencyValues));
        severity.setItems(FXCollections.observableArrayList(severityValues));
        nonDetectability.setItems(FXCollections.observableArrayList(nonDetectabilityValues));
    }

}

